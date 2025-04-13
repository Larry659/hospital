package com.lanre.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    private double balance;
    private double balanceBefore;
    private double balanceAfter;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
