package com.lanre.hospital.repository;

import com.lanre.hospital.entity.PharmacyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyOrderRepo extends JpaRepository<PharmacyOrder, Integer> {

}
