package com.lanre.hospital.request;


import lombok.Data;

@Data
public class SupplierRequest {
    private String name;
    private String contactPerson;
    private String contactPhone;
    private String email;
}
