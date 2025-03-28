package com.lanre.hospital.entity;

import com.lanre.hospital.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PharmacyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long orderId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
    private Medicines medicineId;
    private Long quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliverystatus;

}
