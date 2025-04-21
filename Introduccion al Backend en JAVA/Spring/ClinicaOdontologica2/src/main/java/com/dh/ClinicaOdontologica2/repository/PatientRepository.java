package com.dh.ClinicaOdontologica2.repository;

import com.dh.ClinicaOdontologica2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // No se necesitan métodos adicionales para las operaciones CRUD básicas
    // JpaRepository ya proporciona métodos como save(), findById(), findAll(), deleteById(), etc.

    @Query("SELECT p FROM Patient p WHERE p.lastName = ?1")
    Optional<Patient> findByLastName(String lastName);

    Optional<Patient> findByName(String name);
}
