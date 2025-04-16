package com.dh.ClinicaOdontologicaSpring.dao.impl;

import com.dh.ClinicaOdontologicaSpring.dao.BD;
import com.dh.ClinicaOdontologicaSpring.dao.IDao;
import com.dh.ClinicaOdontologicaSpring.model.Dentist;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DentistDaoH2 implements IDao<Dentist> {

    private static final Logger LOGGER = Logger.getLogger(DentistDaoH2.class);

    private static final String SQL_INSERT = "INSERT INTO DENTIST (REGISTRATION_NUMBER, NAME, LAST_NAME) " +
            "VALUES (?, ?, ?);";

    private static final String SQL_SELECT = "SELECT * FROM DENTIST WHERE ID = ?;";

    private static final String SQL_UPDATE = "UPDATE DENTIST SET REGISTRATION_NUMBER = ?, NAME = ?, LAST_NAME = ? " +
            "WHERE ID = ?;";

    private static final String SQL_DELETE = "DELETE FROM DENTIST WHERE ID = ?;";

    private static final String SQL_SELECT_ALL = "SELECT * FROM DENTIST;";

    @Override
    public Dentist save(Dentist dentist) {
        Connection connection = null;
        try {
            LOGGER.info("Se inició una operación de guardado de odontólogo");

            // Conectar a la BD
            connection = BD.getConnection();

            // Insertar valores -> guardarlos
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, dentist.getRegistrationNumber());
            psInsert.setString(2, dentist.getName());
            psInsert.setString(3, dentist.getLastName());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                dentist.setId(rs.getInt(1));
                LOGGER.info("Este es el odontólogo guardado: " + dentist.getName() + dentist.getLastName() +
                        " Matrícula: " + dentist.getRegistrationNumber());
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return dentist;
    }

    @Override
    public Dentist findById(Integer id) {
        Connection connection = null;
        LOGGER.info("Se inició una operación de búsqueda de odontólogo por ID");
        Dentist dentist = null;

        try {
            // Conectar a la BD
            connection = BD.getConnection();

            // Buscar odontólogo por ID
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1, id);

            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                dentist = new Dentist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4));
                LOGGER.info("Este es el odontólogo encontrado: ID: " + dentist.getId() +
                        ", Nombre: " + dentist.getName() + ", Apellido: " + dentist.getLastName());
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return dentist;
    }

    @Override
    public void update(Dentist dentist) {
        Connection connection = null;

        if (dentist.getId() == null) {
            throw new IllegalArgumentException("No se puede actualizar un odontólogo sin ID.");
        }

        try {
            LOGGER.info("Se inició una operación de actualización de odontólogo");

            // Conectar a la BD
            connection = BD.getConnection();

            // Actualizar odontólogo
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setInt(1, dentist.getRegistrationNumber());
            psUpdate.setString(2, dentist.getName());
            psUpdate.setString(3, dentist.getLastName());
            psUpdate.setInt(4, dentist.getId());
            psUpdate.execute();

            LOGGER.info("El atributo actualizado es: " + dentist.getName());

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        try {
            LOGGER.warn("Se inició una operación de eliminación del odontólogo con ID: " + id);

            // Conectar a la BD
            connection = BD.getConnection();

            // Eliminar odontólogo
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();

            LOGGER.info("Se eliminó el odontólogo con ID: " + id);
        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Dentist> findAll() {
        Connection connection = null;
        LOGGER.info("Se inició una operación de búsqueda de todos los odontólogos");
        List<Dentist> DentistList = new ArrayList<>();
        DentistList.add(new Dentist(1, 1234, "Juan", "Pérez"));
        Dentist dentist = null;

        try {
            // Conectar a la BD
            connection = BD.getConnection();

            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);

            // Guardamos los resultados en un ResultSet
            ResultSet rs = psSelectAll.executeQuery();

            while (rs.next()) {
                // Guardamos los resultados en un objeto odontólogo
                dentist = new Dentist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4));

                // Guardar los odontólogos en la lista
                DentistList.add(dentist);
                LOGGER.info("Este es el odontólogo encontrado:" +
                        ", ID:" + dentist.getId() +
                        ", Matricula: " + dentist.getRegistrationNumber() +
                        ", Nombre: " + dentist.getName() +
                        ", Apellido: " + dentist.getLastName());
            }

        } catch (Exception e) {
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return DentistList;
    }
}
