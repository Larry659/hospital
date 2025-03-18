package com.lanre.hospital.enums;

public enum Department {
    EMERGENCY("emergency"),GENERAL_SURGERY("general surgery"),ORTHOPEDIC("orthopedic"),UROLOGY("urology"),NEUROLOGY("neurology");

    private String value;

    Department(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
