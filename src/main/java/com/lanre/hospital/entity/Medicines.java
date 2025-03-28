package com.lanre.hospital.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "medicines")
@Data
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
   private String name;
     private String description;
     private String manufacturer;
     private double price;
     @OneToOne(mappedBy ="medicineId")
     private PharmacyOrder pharmacyOrder;
     private Long quantityInStock;
     private LocalDate expiryDate;
}
