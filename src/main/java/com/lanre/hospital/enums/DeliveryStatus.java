package com.lanre.hospital.enums;

public enum DeliveryStatus {
    DELIVERED("delivered"),PENDING("pending"),CANCELED("canceled");

    private String value;

    DeliveryStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
