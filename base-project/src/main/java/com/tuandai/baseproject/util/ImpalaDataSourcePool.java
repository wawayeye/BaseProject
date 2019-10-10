package com.tuandai.baseproject.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PrivilegedAction;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

public class ImpalaDataSourcePool implements DataSource{

    private static final Integer poolNum = 50;

    private static ImpalaDataSourcePool instance;

    private final static Logger logger = LoggerFactory.getLogger(ImpalaDataSourcePool.class);

    private LinkedList<Connection> pools = new LinkedList<Connection>();

    private static final String driver_class = "com.cloudera.impala.jdbc41.Driver";

    private static final String jdbc_url = "jdbc:impala://node53:21050;AuthMech=1;KebRealm=HADOOP.COM;KrbHostFQDN=node53;KrbServiceName=impala";

    public ImpalaDataSourcePool() {
        try {
            Class.forName(driver_class);
            String confpath, keypath;
            Configuration conf = new Configuration();
            conf.set("hadoop.security.authentication", "Kerberos");
            if (isWindows()) {
                confpath = ResourceUtils.getFile("classpath:kudu/krb5.conf").getPath();
                keypath = ResourceUtils.getFile("classpath:kudu/hive.keytab").getPath();
                System.setProperty("java.security.krb5.conf", confpath);
                UserGroupInformation.setConfiguration(conf);
                UserGroupInformation.loginUserFromKeytab("hive/node51@HADOOP.COM", keypath);
            }else {
                confpath = "/etc/krb5.conf";
                keypath = "/opt/keytabs/hive.keytab";
                System.setProperty("java.security.krb5.conf", confpath);
                UserGroupInformation.setConfiguration(conf);
                UserGroupInformation.loginUserFromKeytab("hive@datalab.fun", keypath);
            }
            logger.info("who is this {} ", UserGroupInformation.getLoginUser());
            UserGroupInformation loginUser = UserGroupInformation.getLoginUser();
            for (int i = 0; i < poolNum; i++) {
                loginUser.doAs(
                    new PrivilegedAction<Connection>() {
                        public Connection run() {
                            Connection connection = null;
                             connection = null;
                                try {
                                    Class.forName(driver_class);
                                    connection = DriverManager.getConnection(jdbc_url);
                                    pools.addFirst(connection);
                                } catch (Exception e) {
                                    logger.error(e.getMessage());
                                }
                            return connection;
                        }
                 });
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!    "+i);
            }
        } catch (Exception e) {
            logger.error("ImplalDataSourcePool init error {}", e.getMessage());
        }
    }

    public static ImpalaDataSourcePool getInstance() {
        if (instance == null) {
            instance = new ImpalaDataSourcePool();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = pools.removeLast();
        ClassLoader loader = conn.getClass().getClassLoader();
        Class<?>[] interfaces = conn.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            /**判断conn对象执行的方法是不是close方法，如果是，则将连接返回到连接池，而不是关闭连接 */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("close".equals(method.getName())){
                    pools.addFirst(conn);
                    return null;
                }else{
                    return method.invoke(conn, args);
                }
            }
        };
        Connection proxyConn = (Connection) Proxy.newProxyInstance(loader, new Class[] { Connection.class }, h);
        return proxyConn;
    }


    public void free(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            } finally {
                pools.addFirst(conn);
            }
        }
    }

    private static boolean isWindows() {
        boolean flag = false;
        Properties props = System.getProperties();
        String osName = props.getProperty("os.name");
        if(osName.startsWith("Win")) {
            flag = true;
        }
        return flag;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

}
