package com.lanre.hospital.entity;

import com.lanre.hospital.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    private Appointment appointment;
    private double totalAmount;
    private double paidAmount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private LocalDate dateIssued;
    private double balance;
}
