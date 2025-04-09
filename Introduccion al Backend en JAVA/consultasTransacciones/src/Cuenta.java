import java.sql.*;

public class Cuenta {
    // Vamos a crear una tabla cuenta con 4 columnas (ID/Nro de cuenta/Titular/Saldo)
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS CUENTAS;" +
            "CREATE TABLE CUENTAS (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "NUMERO_CUENTA INT NOT NULL," +
            "TITULAR VARCHAR(50) NOT NULL," +
            "SALDO NUMERIC(10,2) NOT NULL" +
            ");";

            // NUMERIC(10,2) es lo mismo que DECIMAL(10,2) -> Ej: 12345678,90

    private static final String SQL_INSERT = "INSERT INTO CUENTAS VALUES (?, ?, ?, ?);";

    private static final String SQL_SELECT = "SELECT * FROM CUENTAS;";

    private static final String SQL_UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE ID = ?;";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            // Vamos a  insertar valores en la tabla
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,134255);
            preparedStatement.setString(3,"Juan Perez");
            preparedStatement.setDouble(4,1000.00);

            // Ejecutamos la inserción
            preparedStatement.executeUpdate();

            ResultSet rs = statement.executeQuery(SQL_SELECT);

            while (rs.next()) {
                System.out.println("Los datos de la cuenta y el saldo son los siguientes:" +
                " - ID: " + rs.getInt(1) +
                " - NUMERO_CUENTA: " + rs.getInt(2) +
                " - TITULAR: " + rs.getString(3) +
                " - SALDO: " + rs.getDouble(4));
            }

            // Vamos a generar una transacción
            connection.setAutoCommit(false); // Desactivamos el autocommit, para manejarlo nosotros

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);

            preparedStatementUpdate.setDouble(1,3430);
            preparedStatementUpdate.setInt(2,1);

            preparedStatementUpdate.execute();

            int exception = 1 / 0; // Simulamos una excepción para ver el rollback

            connection.commit();

            // Buena practica: reactivar el autocommit
            connection.setAutoCommit(true);

            ResultSet rs1 = statement.executeQuery(SQL_SELECT);

            while (rs1.next()){
                System.out.println("El saldo actualizado es: " +
                        "ID: " + rs1.getInt(1) +
                        " - NUMERO_CUENTA: " + rs1.getInt(2) +
                        " - TITULAR: " + rs1.getString(3) +
                        " - SALDO: " + rs1.getDouble(4));
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

            // Nos volvimos a conectar a la BD para comprobar que la transacción no se realizó

            Statement statement = connection.createStatement();
            ResultSet rs2 = statement.executeQuery(SQL_SELECT); // SELECT * FROM CUENTAS;

            while (rs2.next()){
                System.out.println("Los datos de la cuenta y el saldo son los siguientes:" +
                        " - ID: " + rs2.getInt(1) +
                        " - NUMERO_CUENTA: " + rs2.getInt(2) +
                        " - TITULAR: " + rs2.getString(3) +
                        " - SALDO: " + rs2.getDouble(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
