package com.lanre.hospital.enums;

public enum AppointmentStatus {
    SCHEDULED("scheduled"),COMPLETED("completed"),CANCELED("canceled");

    private String value;

    AppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
