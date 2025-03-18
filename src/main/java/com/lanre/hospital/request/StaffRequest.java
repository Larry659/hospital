package com.lanre.hospital.request;


import com.lanre.hospital.enums.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class StaffRequest {

    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String specialty;
    private Department department;
    private String role;
}
