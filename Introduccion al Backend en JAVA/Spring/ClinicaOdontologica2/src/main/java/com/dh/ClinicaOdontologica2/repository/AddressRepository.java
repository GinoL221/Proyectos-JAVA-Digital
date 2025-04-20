package com.dh.ClinicaOdontologica2.repository;

import com.dh.ClinicaOdontologica2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
