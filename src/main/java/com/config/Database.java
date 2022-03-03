package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "java_university";
    private static String userName = "guest";
    private static String password = "guest";

    public Database() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database");
        }
        return conn;
    }


    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }
}
