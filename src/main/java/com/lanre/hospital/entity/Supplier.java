package com.lanre.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "supplier")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    private String name;
    private String contactPerson;
    @Column(nullable = false)
    private String contactPhone;
    private String email;
}
