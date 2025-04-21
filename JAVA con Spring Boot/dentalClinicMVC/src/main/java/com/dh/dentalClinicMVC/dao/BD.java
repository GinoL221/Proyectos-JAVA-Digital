package com.dh.dentalClinicMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final String DRIVE = "com.h2.Driver";

    private static final String URL = "jdbc:h2:~/dc";

    private static final String USER = "sa";

    private static final String PASSWORD = "sa";

    private static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS " +
            "ADDRESSES; (ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "STREET VARCHAR(100) NOT NULL, " +
            "NUMBER INT NOT NULL, " +
            "LOCATION VARCHAR(100) NOT NULL, " +
            "PROVINCE VARCHAR(100) NOT NULL";

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVE);
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void createTable(){
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

        } catch (Exception e) {

        }
    }
}
