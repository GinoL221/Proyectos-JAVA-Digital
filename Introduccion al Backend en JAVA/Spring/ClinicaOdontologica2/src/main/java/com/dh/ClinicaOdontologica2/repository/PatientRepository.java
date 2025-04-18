package com.dh.ClinicaOdontologica2.repository;

import com.dh.ClinicaOdontologica2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // No se necesitan métodos adicionales para las operaciones CRUD básicas
    // JpaRepository ya proporciona métodos como save(), findById(), findAll(), deleteById(), etc.
    // Puedes agregar métodos personalizados si es necesario, por ejemplo:
    // List<Patient> findByLastName(String lastName);

    // Si necesitas realizar consultas más complejas, puedes usar JPQL o consultas nativas
}
