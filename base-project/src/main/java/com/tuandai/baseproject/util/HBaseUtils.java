package com.tuandai.baseproject.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBaseUtils {
    static Configuration conf = null;
    static Connection connection = null;
    static Admin admin = null;
    static Table table = null;

    static {
        try {
            conf = HBaseConfiguration.create();
            if(System.getProperties().getProperty("os.name").equals("Windows 10")){
                //获取krb5.conf
                System.setProperty("java.security.krb5.conf", Thread.currentThread().getContextClassLoader().getResource("conf/krb5.conf").getPath());
                conf.set("keytab.file", Thread.currentThread().getContextClassLoader().getResource("conf/hbase.keytab").getPath());
                UserGroupInformation.loginUserFromKeytab("hbase@HADOOP.COM",
                        Thread.currentThread().getContextClassLoader().getResource("conf/hbase.keytab").getPath());
            }else{
                System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
                conf.set("keytab.file", "/opt/keytabs/hbase.keytab");
                UserGroupInformation.loginUserFromKeytab("hbase@datalab.fun",
                        "/opt/keytabs/hbase.keytab");
            }

            conf.set("hadoop.security.authentication" , "Kerberos");
            // 这个hbase.keytab也是从远程服务器上copy下来的, 里面存储的是密码相关信息，这样我们就不需要交互式输入密码了

            // 这个可以理解成用户名信息，也就是Principal
            conf.set("kerberos.principal", "hbase@datalab.fun");

//            conf.set("hbase.zookeeper.quorum", "node51:2181,node52:2181,node53:2181");
            conf.set("hbase.zookeeper.quorum", "hadoop1-172-18-12-1:2181,hadoop2-172-18-12-2:2181,hadoop3-172-18-12-3:2181");
            conf.set("hbase.zookeeper.property.clientPort", "2181");
            conf.set("hbase.security.authentication", "kerberos");
            UserGroupInformation.setConfiguration(conf);

            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("kerboers认证错误:" + e.getMessage(), e);
        }
    }
/*

     * 创建表
     *
     * @tableName 表名
     *
     * @family 列族列表
*/


    public static void creatTable(String tableName, String[] family)
            throws Exception {
        Admin admin = connection.getAdmin();
        HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
        for (int i = 0; i < family.length; i++) {
            desc.addFamily(new HColumnDescriptor(family[i]));
        }
        if (admin.tableExists(TableName.valueOf(tableName))) {
            System.out.println("table Exists!");
            System.exit(0);
        } else {
            admin.createTable(desc);
            System.out.println("create table Success!");
        }
    }

/*
     * 为表添加数据（适合知道有多少列族的固定表）
     *
     * @rowKey rowKey
     *
     * @tableName 表名
     *
     * @column1 第一个列族列表
     *
     * @value1 第一个列的值的列表
     *
     * @column2 第二个列族列表
     *
     * @value2 第二个列的值的列表
*/


    public static void addData(String rowKey, String tableName,
                               String[] column1, String[] value1, String[] column2, String[] value2)
            throws IOException {
        Put put = new Put(Bytes.toBytes(rowKey));// 设置rowkey
        Table table = connection.getTable(TableName.valueOf(tableName));// HTabel负责跟记录相关的操作如增删改查等//
        // 获取表
        HColumnDescriptor[] columnFamilies = table.getTableDescriptor() // 获取所有的列族
                .getColumnFamilies();

        for (int i = 0; i < columnFamilies.length; i++) {
            String familyName = columnFamilies[i].getNameAsString(); // 获取列族名
            if (familyName.equals("article")) { // article列族put数据
                for (int j = 0; j < column1.length; j++) {
                    put.addColumn(Bytes.toBytes(familyName),
                            Bytes.toBytes(column1[j]), Bytes.toBytes(value1[j]));
                }
            }
            if (familyName.equals("author")) { // author列族put数据·
                for (int j = 0; j < column2.length; j++) {
                    put.addColumn(Bytes.toBytes(familyName),
                            Bytes.toBytes(column2[j]), Bytes.toBytes(value2[j]));
                }
            }
        }
        table.put(put);
        System.out.println("add data Success!");
    }

    public static void insert(String tableName, String rowKey, String family, String column, String value) {
        Table table = null;
        Admin admin = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            admin = connection.getAdmin();
            //判断表是否存在，如果不存在进行创建
            if (!admin.tableExists(TableName.valueOf(Bytes.toBytes(tableName)))) {
                HTableDescriptor tableDescriptor = new HTableDescriptor(Bytes.toBytes(tableName));
                HColumnDescriptor columnDescriptor = new HColumnDescriptor(Bytes.toBytes(family));
                tableDescriptor.addFamily(columnDescriptor);
                admin.createTable(tableDescriptor);
            }
            //进行数据插入
            Put put = new Put(Bytes.toBytes(rowKey));
            put.add(Bytes.toBytes(family), Bytes.toBytes(column), Bytes.toBytes(value));
            table.put(put);
            table.close();
        } catch (Exception e) {
            try {
                if (table != null) {
                    table.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

/*
     * 根据rwokey查询
     *
     * @rowKey rowKey
     *
     * @tableName 表名*/


    public static Result getResult(String tableName, String rowKey)
            throws IOException {
        Get get = new Get(Bytes.toBytes(rowKey));
        Table table = connection.getTable(TableName.valueOf(tableName));// 获取表
        Result result = table.get(get);
//        for (Cell cell : result.listCells()) {
//            System.out.println("family:" + Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()));
//            System.out.println("qualifier:" + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()));
//            System.out.println("value:" + Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//            System.out.println("Timestamp:" + cell.getTimestamp());
//            System.out.println("-------------------------------------------");
//        }
        return result;
    }

/*     * 遍历查询hbase表
     *
     * @tableName 表名*/


    public static List<Result> getResultByTable(String tableName) throws IOException {
        List<Result> list = new ArrayList<Result>();
        Scan scan = new Scan();
        ResultScanner rs = null;
        Table table = connection.getTable(TableName.valueOf(tableName));
        try {
            rs = table.getScanner(scan);
            ResultScanner resultScanner = table.getScanner(scan);
            for (Result result : resultScanner) {
                list.add(result);
            }
            return list;
        } finally {
            rs.close();
        }
    }

/*     * 遍历查询hbase表
     *
     * @tableName 表名*/


    public static List<Result> getResultTableAndRowKey(String tableName, String start_rowkey,
                                                       String end_rowkey) throws IOException {
        List<Result> list = new ArrayList<Result>();
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes(start_rowkey));
        scan.setStopRow(Bytes.toBytes(end_rowkey));
        ResultScanner rs = null;
        Table table = connection.getTable(TableName.valueOf(tableName));
        try {
            rs = table.getScanner(scan);
            ResultScanner resultScanner = table.getScanner(scan);
            for (Result result : resultScanner) {
                list.add(result);
            }
            return list;
        } finally {
            rs.close();
        }
    }

/*
     * 查询表中的某一列
     *
     * @tableName 表名
     *
     * @rowKey rowKey
*/


    public static Result getRowsByColumn(String tableName, String rowKey,
                                         String familyName, String columnName) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName)); // 获取指定列族和列修饰符对应的列
        Result result = table.get(get);
        return result;
    }

    public static List<Result> getRowsByColumns(String tableName, String rowKey_like, String familyName, String cols[]) {
        Table table = null;
        Result result = null;
        List<Result> list = new ArrayList<Result>();
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            //rowkey的模糊匹配
            PrefixFilter filter = new PrefixFilter(rowKey_like.getBytes());
            Scan scan = new Scan();
            for (int i = 0; i < cols.length; i++) {
                scan.addColumn(familyName.getBytes(), cols[i].getBytes());
            }
            scan.setFilter(filter);
            ResultScanner resultScanner = table.getScanner(scan);
            for (Result rs : resultScanner) {
                list.add(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                table.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
/*
     * 更新表中的某一列
     *
     * @tableName 表名
     *
     * @rowKey rowKey
     *
     * @familyName 列族名
     *
     * @columnName 列名
     *
     * @value 更新后的值*/


    public static void updateTable(String tableName, String rowKey,
                                   String familyName, String columnName, String value)
            throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(familyName), Bytes.toBytes(columnName),
                Bytes.toBytes(value));
        table.put(put);
        System.out.println("update table Success!");
    }

/*
     * 查询某列数据的多个版本
     *
     * @tableName 表名
     *
     * @rowKey rowKey
     *
     * @familyName 列族名
     *
     * @columnName 列名
*/


    public static Result getResultByVersion(String tableName, String rowKey,
                                            String familyName, String columnName) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        get.setMaxVersions(5);
        Result result = table.get(get);
        return result;
    }
/*
     * 删除指定的列
     *
     * @tableName 表名
     *
     * @rowKey rowKey
     *
     * @familyName 列族名
     *
     * @columnName 列名*/


    public static void deleteColumn(String tableName, String rowKey,
                                    String falilyName, String columnName) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete deleteColumn = new Delete(Bytes.toBytes(rowKey));
        deleteColumn.addColumn(Bytes.toBytes(falilyName),
                Bytes.toBytes(columnName));
        table.delete(deleteColumn);
        System.out.println(falilyName + ":" + columnName + "is deleted!");
    }
/*
     * 删除指定的列
     *
     * @tableName 表名
     *
     * @rowKey rowKey*/


    public static void deleteAllColumn(String tableName, String rowKey)
            throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete deleteAll = new Delete(Bytes.toBytes(rowKey));
        table.delete(deleteAll);
        System.out.println("all columns are deleted!");
    }
/*
     * 删除表
     *
     * @tableName 表名*/


    public static void deleteTable(String tableName) throws IOException {
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf(tableName));
        admin.deleteTable(TableName.valueOf(tableName));
        System.out.println(tableName + "is deleted!");
    }

    public static void main(String[] args) throws Exception {
        Result result = HBaseUtils.getRowsByColumn("user_info", "11111", "info", "sum");
        System.err.println("!!!!!!!!!!!!!!!!!!"+new String(result.getRow()));

        //        Result result = HBaseUtils.getRowsByColumns("user_info", "11111", "info", "sum");
//        HashMap<String, String> hm = new HashMap<String, String>();
//        for (KeyValue kv : result.raw()) {
//            hm.put(new String(kv.getQualifier()), new String(kv.getValue()));
//        }
//        System.out.println("@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+hm.toString());


//        Result rs = getResult("area_order", "2018-05-15");
//        for(KeyValue keyValue : rs.raw()){
//            System.err.println("rowkey:"+new String(keyValue.getRow()));
//            System.err.println("qualify:"+new String(keyValue.getQualifier()));
//            System.err.println("value:"+new String(keyValue.getValue()));
//            System.err.println("-----------------------------");
//        }
//        insert("area_order2","2018-05-15","cf","order_amount","800");
//        List<Result> list = HBaseUtils.getRowsByColumns("total_out_put_money", "sum_amount", "cf", new String[]{"sum_amount"});
//        HashMap<String, Double> map = new HashMap<String, Double>();
//        for (Result rs : list) {
//            String rowkey = new String(rs.getRow());
//            for (KeyValue keyValue : rs.raw()) {
//                if ("sum_amount".equals(new String(keyValue.getQualifier()))) {
//                    map.put(rowkey, Double.parseDouble(new String(keyValue.getValue())));
//                }
//            }
//        }
//        System.out.println(map.toString());
    }
}



