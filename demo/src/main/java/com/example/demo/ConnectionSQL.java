package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static Connection getMySQLConnection () throws SQLException {
        Connection conn = null;
        String hostName = "localhost";//127.0.0.1
        String dbName = "test2";
        String username = "root";
        String password = "";
        String connURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connURL, username, password);
        return conn;
    }

}
