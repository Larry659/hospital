package com.lanre.hospital.entity;

import com.lanre.hospital.enums.AppointmentStatus;
import com.lanre.hospital.enums.Department;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity(name="appointment")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @Enumerated(EnumType.STRING)
   private Department department;
   private LocalDate appointmentDate;
   private LocalTime appointmentTime;
   @Enumerated(EnumType.STRING)
   private AppointmentStatus status;

}
