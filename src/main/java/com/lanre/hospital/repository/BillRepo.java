package com.lanre.hospital.repository;

import com.lanre.hospital.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {
}
