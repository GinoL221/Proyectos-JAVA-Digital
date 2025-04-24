package com.dh.dentalClinicMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final String DRIVE = "com.h2.Driver";

    private static final String URL = "jdbc:h2:~/dc";

    private static final String USER = "sa";

    private static final String PASSWORD = "sa";

    private static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS ADDRESSES; " +
            "CREATE TABLE ADDRESSES (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "STREET VARCHAR(100) NOT NULL, " +
            "NUMBER INT NOT NULL, " +
            "LOCATION VARCHAR(100) NOT NULL, " +
            "PROVINCE VARCHAR(100) NOT NULL)";

    public static final String SQL_DROP_CREATE_PATIENTS = "DROP TABLE IF EXISTS PATIENTS; " +
            "CREATE TABLE PATIENTS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NAME VARCHAR(100) NOT NULL, " +
            "LAST_NAME VARCHAR(100) NOT NULL, " +
            "EMAIL VARCHAR(100) NOT NULL, " +
            "CARD_IDENTITY INT NOT NULL, " +
            "ADMISSION_DATE DATE NOT NULL, " +
            "ADDRESS_ID INT NOT NULL)";

    public static final String SQL_DROP_CREATE_DENTISTS = "DROP TABLE IF EXISTS DENTISTS; " +
            "CREATE TABLE DENTISTS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "REGISTRATION_NUMBER INT NOT NULL, " +
            "NAME VARCHAR(100) NOT NULL, " +
            "LAST_NAME VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO ADDRESSES(STREET, NUMBER, LOCATION, PROVINCE) " +
            "VALUES ('Calle 1', 123, 'Lujan de Cuyo', 'Buenos Aires'); " +
            "INSERT INTO PATIENTS(NAME, LAST_NAME, EMAIL, CARD_IDENTITY, ADMISSION_DATE, ADDRESS_ID) " +
            "VALUES ('Juan', 'Perez', JPerez@email.com, 12345678, '2023-01-01', 1); " +
            "INSERT INTO DENTISTS(REGISTRATION_NUMBER, NAME, LAST_NAME) " +
            "VALUES (123456, 'Dr. Smith', 'Johnson');";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVE);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ADDRESSES);
            statement.execute(SQL_DROP_CREATE_PATIENTS);
            statement.execute(SQL_DROP_CREATE_DENTISTS);
            statement.execute(SQL_INSERT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
