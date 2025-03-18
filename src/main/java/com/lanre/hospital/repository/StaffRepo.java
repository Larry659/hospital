package com.lanre.hospital.repository;

import com.lanre.hospital.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff,Long> {
}
