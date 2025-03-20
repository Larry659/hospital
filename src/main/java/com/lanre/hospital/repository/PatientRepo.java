package com.lanre.hospital.repository;

import com.lanre.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    //@Query("SELECT p FROM Patient p WHERE p.firstName = :firstName and p.lastName = :lastName")
    Patient findByFirstNameAndLastName(String firstName, String lastName);
}
