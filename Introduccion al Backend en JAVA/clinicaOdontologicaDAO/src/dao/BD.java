package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    public static final String SQL_TABLE_CREATE_DENTIST = "DROP TABLE IF EXISTS DENTIST;" +
            "CREATE TABLE DENTIST (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "REGISTRATION_NUMBER INT NOT NULL, " +
            "NAME VARCHAR(50) NOT NULL," +
            "LAST_NAME VARCHAR(50) NOT NULL " +
            ");";

    private static final String SQL_TABLE_CREATE_PATIENT = "DROP TABLE IF EXISTS PATIENT;" +
            "CREATE TABLE PATIENT (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "NAME VARCHAR(50) NOT NULL," +
            "LAST_NAME VARCHAR(50) NOT NULL," +
            "CARD_IDENTITY VARCHAR(50) NOT NULL," +
            "ADMISSION_DATE DATE NOT NULL" +
            ");";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/ClinicaOdontologicaDAO", "sa", "");
    }

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE_DENTIST);
            statement.execute(SQL_TABLE_CREATE_PATIENT);
            System.out.println("Tables created successfully");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
