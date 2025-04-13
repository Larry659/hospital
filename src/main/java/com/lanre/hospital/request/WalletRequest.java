package com.lanre.hospital.request;

import com.lanre.hospital.entity.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WalletRequest {
    private Patient patient;
    private double balance;
    private double balanceBefore;
    private double balanceAfter;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
