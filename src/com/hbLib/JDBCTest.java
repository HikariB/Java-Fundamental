package com.hbLib;

import java.sql.*;

//JDBC Transaction

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        String JDBC_URL = "jdbc:mysql://localhost:3306/test2?useSSL=false&characterEncoding=utf8&serverTimezone=CTT";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        PreparedStatement ps = conn.prepareStatement("select * from classes");
        PreparedStatement ps2 = conn.prepareStatement("update classes set name = ? where id = ?");
        ps2.setObject(1,"九班");
        ps2.setObject(2,3);
        int n =ps2.executeUpdate();
        System.out.println(n+" updated");

        ResultSet res=ps.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            System.out.print(id);
            String name = res.getString("name");
            System.out.println(name);
        }
        conn.close();

    }

}
