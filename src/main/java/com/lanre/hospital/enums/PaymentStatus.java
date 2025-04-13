package com.lanre.hospital.enums;

public enum PaymentStatus {
    PAID("paid"),PENDING("pending");

    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
