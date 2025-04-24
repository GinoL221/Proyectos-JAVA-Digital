package com.dh.dentalClinicMVC.dao;

import com.dh.dentalClinicMVC.model.Patient;

import java.sql.*;
import java.util.List;

public class PatientDaoH2 implements IDao<Patient> {

    private static final String SQL_INSERT = "INSERT INTO PATIENTS(NAME, LAST_NAME, CARD_IDENTITY," +
            " ADMISSION_DATE, ADDRESS_ID) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public Patient save(Patient patient) {
        Connection connection = null;
        try{
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            addressDaoH2.save(patient.getAdress());

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setInt(3, patient.getCardIdentity());
            ps.setDate(4, java.sql.Date.valueOf(patient.getAdmissionDate()));
            ps.setInt(5, patient.getAdress().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                patient.setId(rs.getInt(1));
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
        return patient;
    }

    @Override
    public Patient findById(Integer id) {
        return null;
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }
}

