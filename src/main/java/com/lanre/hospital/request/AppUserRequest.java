package com.lanre.hospital.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AppUserRequest {
    private String firstName;
    private String userName;
    private String lastName;
    private String password;
    private String role;
}
