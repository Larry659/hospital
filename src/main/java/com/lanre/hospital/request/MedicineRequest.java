package com.lanre.hospital.request;

import lombok.Data;


@Data
public class MedicineRequest {
    private String name;
    private String description;
    private String manufacturer;
    private double price;
    private Long quantityInStock;
    private String expiryDate;
}
