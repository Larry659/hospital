package com.lanre.hospital.entity;

import com.lanre.hospital.enums.Department;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private String gender;
    @Column(name = "speciality")
    private String specialty;
    @Column(name = "department")
    @Enumerated(EnumType.STRING)
private Department department;
    @Column(name = "role")
    private String role;



}
