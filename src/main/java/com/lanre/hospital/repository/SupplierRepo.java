package com.lanre.hospital.repository;

import com.lanre.hospital.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    Supplier findByNameAndContactPhone(String name, String contactPhone);
    Supplier findByName(String name);
}
