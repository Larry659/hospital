package com.lanre.hospital.repository;

import com.lanre.hospital.entity.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepo extends JpaRepository<Medicines, Long> {
    Medicines findByName(String name);
}
