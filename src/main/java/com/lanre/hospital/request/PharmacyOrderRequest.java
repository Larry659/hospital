package com.lanre.hospital.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lanre.hospital.entity.Medicines;
import com.lanre.hospital.entity.Supplier;
import com.lanre.hospital.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties
public class PharmacyOrderRequest {
    private String medicineName;
    private Long quantity;
    private String supplierName;
    private DeliveryStatus deliverystatus;
    private Double price;
    private String description;
    private String manufacturer;
    private LocalDate expiryDate;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierPerson;
}
