package com.tuandai.baseproject.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.kudu.client.*;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.List;

public class KuduUtils {
    private static final String KUDU_MASTER = System.getProperty("kuduMasters", "node51:7051");

    /**
     * 查看Kudu表中数据
     * @param client
     * @param tableName
     */
    public static void scanerTable(KuduClient client, String tableName) {
        try {
            KuduTable kuduTable = client.openTable(tableName);
            KuduScanner kuduScanner = client.newScannerBuilder(kuduTable).build();
            while(kuduScanner.hasMoreRows()) {
                RowResultIterator rowResultIterator =kuduScanner.nextRows();
                while (rowResultIterator.hasNext()) {
                    RowResult rowResult = rowResultIterator.next();

                    System.out.println(rowResult.getString("id"));
                }
            }
            kuduScanner.close();
        } catch (KuduException e) {
            e.printStackTrace();
        }
    }
    /**
     * 列出Kudu下所有的表
     * @param client
     */
    public static void tableList(KuduClient client) {
        try {
            ListTablesResponse listTablesResponse = client.getTablesList();
            List<String> tblist = listTablesResponse.getTablesList();
            for(String tableName : tblist) {
                System.out.println(tableName);
            }
        } catch (KuduException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        KuduUtils k = new KuduUtils();
        System.setProperty("java.security.krb5.conf", k.getClass().getResource("/kudu/krb5.conf").getPath());
        Configuration conf = new Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab("hive/node51@HADOOP.COM", k.getClass().getResource("/kudu/hive.keytab").getPath());
//        KuduClient kuduClient = new KuduClient.KuduClientBuilder(KUDU_MASTER).build();
        KuduClient  kuduClient  = UserGroupInformation.getLoginUser().doAs(
                (PrivilegedExceptionAction<KuduClient>) new KuduClient.KuduClientBuilder(KUDU_MASTER)::build
        );
        tableList(kuduClient);
        scanerTable(kuduClient, "impala::default.s121_loan_t_user_phone_info");
        try {
            kuduClient.close();
        } catch (KuduException e) {
            e.printStackTrace();
        }
    }
}
