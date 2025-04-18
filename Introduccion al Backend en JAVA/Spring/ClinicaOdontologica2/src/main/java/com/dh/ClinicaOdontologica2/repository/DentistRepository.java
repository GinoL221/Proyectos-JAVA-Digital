package com.dh.ClinicaOdontologica2.repository;

import com.dh.ClinicaOdontologica2.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    // No se necesitan métodos adicionales para las operaciones CRUD básicas
    // JpaRepository ya proporciona métodos como save(), findById(), findAll(), deleteById(), etc.
    // Puedes agregar métodos personalizados si es necesario, por ejemplo:
    // List<Dentist> findByLastName(String lastName);

    // Si necesitas realizar consultas más complejas, puedes usar JPQL o consultas nativas
}
