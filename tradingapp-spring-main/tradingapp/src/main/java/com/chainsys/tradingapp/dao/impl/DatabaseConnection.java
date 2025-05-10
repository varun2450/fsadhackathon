package com.chainsys.tradingapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name"; // Change this
    private static final String USERNAME = "your_db_username"; // Change this
    private static final String PASSWORD = "your_db_password"; // Change this

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8.0 and above
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
