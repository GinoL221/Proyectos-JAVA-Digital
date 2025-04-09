import org.apache.log4j.Logger;

import java.sql.*;

public class ClinicaOdontologica {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS DENTIST; " +
            "CREATE TABLE DENTIST (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "REGISTRATION_NUMBER INT NOT NULL, " +
            "NAME VARCHAR(50) NOT NULL, " +
            "LAST_NAME VARCHAR(50) NOT NULL" +
            ");";

    private static final String SQL_INSERT = "INSERT INTO DENTIST (ID, REGISTRATION_NUMBER, NAME, LAST_NAME) " +
            "VALUES (?, ?, ?, ?);";

    private static final String SQL_SELECT = "SELECT * FROM DENTIST;";

    private static final String SQL_UPDATE = "UPDATE DENTIST SET NAME=? WHERE ID=?;";

    private static final String SQL_SELECT_ID = "SELECT * FROM DENTIST WHERE ID=?";

    private static final String SQL_DELETE_ID = "DELETE FROM DENTIST WHERE ID=?;";

    private static final Logger LOGGER = Logger.getLogger(ClinicaOdontologica.class);

    public static void main(String[] args) throws SQLException {

        Dentist dentist1 = new Dentist(1, 1357, "Juan", "Pérez");
        Dentist dentist2 = new Dentist(2, 2468, "Ana", "Gómez");

        Connection connection = null;

        try {
            connection = getConnection();

            // Crear la tabla y definir sus columnas en la BD
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            // Insertar valores en la BD
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            psInsert.setInt(1, dentist1.getId());
            psInsert.setInt(2, dentist1.getRegistrationNumber());
            psInsert.setString(3, dentist1.getName());
            psInsert.setString(4, dentist1.getLastName());
            psInsert.execute();

            psInsert.setInt(1, dentist2.getId());
            psInsert.setInt(2, dentist2.getRegistrationNumber());
            psInsert.setString(3, dentist2.getName());
            psInsert.setString(4, dentist2.getLastName());
            psInsert.execute();

            // Consultar la carga de los datos en la tabla
            ResultSet rs = statement.executeQuery(SQL_SELECT);

            int n = 1;

            while (rs.next()) {
                System.out.println("Los valores insertados en la tabla son: " +
                        "En la fila " + n +
                        " - ID: " + rs.getInt(1) +
                        " - Matrícula: " + rs.getInt(2) +
                        " - Nombre: " + rs.getString(3) +
                        " - Apellido: " + rs.getString(4));
                n++;
            }

            // Actualizar algún dato de una las filas (de unos de los objetos) en la BD
            // Transacción
            connection.setAutoCommit(false); // Desactivar el autocommit

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            String updateName = "Roberto Gabriel";
            psUpdate.setString(1, updateName);
            psUpdate.setInt(2, dentist1.getId());
            psUpdate.execute();

            // Commit de la transacción
            connection.commit();
            LOGGER.warn("Se actualizó el nombre del dentista con ID = " + dentist1.getId() + " a " + updateName);
            connection.setAutoCommit(true); // Volver a activar el autocommit

            // Borrar un registro de la BD
            // Transacción
            connection.setAutoCommit(false);

            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE_ID);

            int deleteId = dentist2.getId();

            psDelete.setInt(1, dentist2.getId());
            psDelete.execute();

            connection.commit();
            LOGGER.warn("AVISO: Se borró el dentista con ID = " + deleteId);
            connection.setAutoCommit(true);

            int error = 10 / 0; // Forzar un error para probar el rollback

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            connection.close();
        }

        // Imprimir por consola el valor que modificamos
        try {
            connection = getConnection();

            int id = 1;

            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Los datos actualizados son: " +
                        " - ID: " + rs.getInt(1) +
                        " - Matrícula: " + rs.getInt(2) +
                        " - Nombre: " + rs.getString(3) +
                        " - Apellido: " + rs.getString(4));
                LOGGER.info("Los datos actualizados son: " +
                        " - ID: " + rs.getInt(1) +
                        " - Matrícula: " + rs.getInt(2) +
                        " - Nombre: " + rs.getString(3) +
                        " - Apellido: " + rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        // Imprimir/chequear por consola el valor que borramos
        try {
            connection = getConnection();

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(SQL_SELECT);

            while (rs.next()) {
                System.out.println("La consulta final luego de borrar el registro con ID = 2 es: " + rs.getInt(1) + " son: " +
                        " - ID: " + rs.getInt(1) +
                        " - Matrícula: " + rs.getInt(2) +
                        " - Nombre: " + rs.getString(3) +
                        " - Apellido: " + rs.getString(4));
                LOGGER.info("La consulta final luego de borrar el registro con ID = 2 es: " + rs.getInt(1) + " son: " +
                        " - ID: " + rs.getInt(1) +
                        " - Matrícula: " + rs.getInt(2) +
                        " - Nombre: " + rs.getString(3) +
                        " - Apellido: " + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica", "sa", "");
    }
}
