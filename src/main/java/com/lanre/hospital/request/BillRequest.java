package com.lanre.hospital.request;

import com.lanre.hospital.enums.PaymentStatus;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BillRequest {
    private String patientFirstName;
    private String patientLastName;
    private double totalAmount;
    private double paidAmount;
    private PaymentStatus status;
    private LocalDate dateIssued;
}
