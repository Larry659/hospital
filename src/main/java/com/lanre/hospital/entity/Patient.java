package com.lanre.hospital.entity;

import com.lanre.hospital.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Long patientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(mappedBy = "patient")
    private Appointment appointment;
    @OneToOne(mappedBy = "patient")
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @Column(name = "contact_number")
    private String contactNumber;
    private String email;
    private String address;
    @Column(name = "emergency_contact")
    private String emergencyContact;
    @Column(name = "blood_type")
    private String bloodType;
    private String allergies;
    @Column(name = "medical_history")
    private String medicalHistory;

       //Getter and Setter


    //Constructor


    public Patient() {
    }

    public Patient(Long patientId, String firstName, String lastName,
                   LocalDate dateOfBirth, Gender gender, String contactNumber,
                   String email, String address, String emergencyContact,
                   String bloodType, String allergies, String medicalHistory) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth= dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.emergencyContact = emergencyContact;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.medicalHistory = medicalHistory;
    }
}
