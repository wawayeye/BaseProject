package com.tuandai.baseproject.util;

import com.tuandai.baseproject.model.DemoModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.lang.reflect.InvocationTargetException;
import java.security.PrivilegedAction;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ImpalaUtils {
    private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
    private static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    private static String CONNECTION_URL = "jdbc:impala://hadoop2-172-18-12-2:21050;AuthMech=1;KebRealm=datalab.fun;KrbHostFQDN=hadoop2-172-18-12-2;" +
            "KrbServiceName=impala";
    private static Connection connection = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static int retry;

    private ImpalaUtils() {
    }

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载出错!");
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws Exception {

        Connection conn = connections.get();
        if (conn == null) {
            conn = getConn();
            connections.set(conn);
        }
        return conn;
    }

    /**
     * 创建连接
     *
     * @return
     * @throws SQLException
     */
    private static Connection getConn() throws Exception {
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        Configuration conf = new Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        UserGroupInformation.setConfiguration(conf);
        if (System.getProperties().getProperty("os.name").equals("Windows 10")) {
            System.setProperty("java.security.krb5.conf", Thread.currentThread().getContextClassLoader().getResource("kudu/krb5.conf").getPath());
            UserGroupInformation.loginUserFromKeytab("hive/node51@HADOOP.COM",
                    Thread.currentThread().getContextClassLoader().getResource("kudu/hive.keytab").getPath());
        } else {
            System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
            UserGroupInformation.loginUserFromKeytab("hive@datalab.fun",
                    "/opt/keytabs/hive.keytab");
        }

        System.out.println(UserGroupInformation.getCurrentUser() + "------" + UserGroupInformation.getLoginUser());
        UserGroupInformation loginUser = UserGroupInformation.getLoginUser();
        loginUser.doAs(
                new PrivilegedAction<Connection>() {
                    public Connection run() {
                        try {
                            Class.forName(JDBC_DRIVER);
                            connection = DriverManager.getConnection(CONNECTION_URL);
                            return connection;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return connection;
                    }
                });
        return connection;
    }

    /**
     * 释放连接
     *
     * @return
     * @throws SQLException
     */
    public static void free(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close(); // 关闭结果集
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // 关闭PreparedStatement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close(); // 关闭连接
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取数据
     *
     * @return
     * @throws SQLException
     */
    public static <T> List<T> executeQuery(Class<T> clazz, String sql, Object... args) throws Exception {
        List<T> list = new ArrayList<T>();
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //2.处理结果集，得到 Map 的List，其中 一个 Map对象 就是一条记录
            //Map 的 key 为 resultSet 中 列的别名， Map的 value 为列的值
            List<Map<String, Object>> values = handleResultSettoMapList(rs);
            //3.把 Map的List 转为 clazz 对应的 List
            //其中 Map 的key 即为 clazz 对应的对象的 propertyName
            //而 Map 的 value 即为 clazz 对应的对象的 propertyValue。
            list = transferMapListToBeanList(clazz, values);
        } catch (Exception e) {
            System.out.println("impala exception:" +e);
            retry++;
            free(rs,ps,connection);
            //connection关闭之后，要从ThreadLocal的集合中清除Connection
            connections.remove();
            //3次失败重试
            if(retry <= 3){
                list = executeQuery(clazz,sql);
                if(list.size() > 0){
                    retry = 0;
                }
            }
        }
        return list;
    }

    /**
    * 执行sql
    */
    public static void executeQuery(String sql){
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("impala exception:" +e);
            retry++;
            free(rs,ps,connection);
            connections.remove();
            executeQuery(sql);
        }
    }

    private static List<Map<String, Object>> handleResultSettoMapList(
            ResultSet resultSet) throws SQLException {
        //5.准备一个 List<Map<String, Object>>:
        //键：存放列的别名， 值：存放列的值。其中一个Map 对象对应着一条记录
        List<Map<String, Object>> values =
                new ArrayList<Map<String, Object>>();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        Map<String, Object> map = null;

        //7.处理 ResultSet， 使用 while 循环
        while (resultSet.next()) {
            map = new HashMap<String, Object>();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                String columLabel = rsmd.getColumnLabel(i + 1);
                Object value = resultSet.getObject(i + 1);

                map.put(columLabel, value);
            }
            //11.把一条记录的一个 Map 对象放入 5 准备的List中
            values.add(map);
        }
        return values;
    }

    private static <T> List<T> transferMapListToBeanList(Class<T> clazz,
                                                         List<Map<String, Object>> values) throws InstantiationException,
            IllegalAccessException, InvocationTargetException {
        //12. 判断 List 是否为空集合，若不为空
        //则遍历List，得到一个一个的Map对象，再把一个 Map对象转换为一个 Class参数对应的 Object对象
        List<T> result = new ArrayList<T>();
        T bean = null;
        if (values.size() > 0) {
            for (Map<String, Object> m : values) {
                bean = clazz.newInstance();
                for (Map.Entry<String, Object> entry : m.entrySet()) {
                    String propertyName = entry.getKey();
                    Object value = entry.getValue();

                    BeanUtils.setProperty(bean, propertyName, value);
                }
                //13. 把 Object 对象放入到 list 中
                result.add(bean);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        List<DemoModel> list = executeQuery(DemoModel.class,"select * from test limit 2");
        System.out.println(list.toString());

    }
}
