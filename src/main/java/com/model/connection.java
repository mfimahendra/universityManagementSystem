package com.model;

public class connection {
    //connect to mysql database
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "java_universitysystem";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "mfimahendra";
    private String password = "st3ph1n3";

    public java.sql.Connection getConnection(){
        java.sql.Connection conn = null;
        try{
            Class.forName(driver);
            conn = java.sql.DriverManager.getConnection(url+dbName,userName,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
