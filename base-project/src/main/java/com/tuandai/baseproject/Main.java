package com.tuandai.baseproject;

import com.tuandai.baseproject.util.ImpalaDataSourcePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String sql = "show tables;";
        Connection connection = ImpalaDataSourcePool.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
