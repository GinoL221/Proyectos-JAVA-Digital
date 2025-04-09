import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
    // Crear una aplicacion que tenga acceso a una tabla animales
    // Los animales deben tener nombre y tipo
    // Obligatoria -> ID

    // Generar algunas constantes
    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS ANIMALES; CREATE " +
            "TABLE ANIMALES (ID INT PRIMARY KEY, " +
            "NOMBRE VARCHAR(50) NOT NULL, " +
            "TIPO VARCHAR(50) NOT NULL);";

    private static final String SQL_INSERT = "INSERT INTO ANIMALES VALUES (1, 'Molly', 'Pez'), " +
            "(2, 'Lola', 'Perro'), " +
            "(3, 'Mimi', 'Gato'), " +
            "(4, 'Paco', 'Perico');";

    private static final String SQL_SELECT = "SELECT * FROM ANIMALES;";

    private static final String SQL_DELETE = "DELETE FROM ANIMALES WHERE ID = 4;";

    private static final Logger LOGGER = Logger.getLogger(Animal.class);

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Conectarnos con la base de datos
            connection = getConnection();

            // Odenes a la BD
            Statement statement = connection.createStatement();

            // Crear la tabla
            statement.execute(SQL_DROP_CREATE);

            // Insertar datos en la tabla
            statement.execute(SQL_INSERT);

            // Consultar la tabla
            ResultSet rs = statement.executeQuery(SQL_SELECT);

            // Imprimir los resultados
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                        ", NOMBRE: " + rs.getString("NOMBRE") +
                        ", TIPO: " + rs.getString("TIPO"));
                LOGGER.info("NOMBRE: " + rs.getString("NOMBRE") +
                        ", TIPO: " + rs.getString("TIPO"));
            }

            // Eliminar un registro
            statement.execute(SQL_DELETE);
            LOGGER.warn("ADVERTENCIA: Se ha eliminado un registro de la tabla ANIMALES con ID = 4");

            // Guardar en JAVA la nueva consulta
            rs = statement.executeQuery(SQL_SELECT);

            System.out.println("-----------------");

            // Imprimir los resultados después de eliminar
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                        ", NOMBRE: " + rs.getString("NOMBRE") +
                        ", TIPO: " + rs.getString("TIPO"));
                LOGGER.info("NOMBRE: " + rs.getString("NOMBRE") +
                        ", TIPO: " + rs.getString("TIPO"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/AccesoBd", "sa", "sa");
    }
}
