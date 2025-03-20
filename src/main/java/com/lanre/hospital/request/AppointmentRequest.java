package com.lanre.hospital.request;

import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.enums.AppointmentStatus;
import com.lanre.hospital.enums.Department;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private String firstName;
    private String lastName;
    private Department department;
    private String appointmentDate;
    private String appointmentTime;
    private AppointmentStatus status;


}
