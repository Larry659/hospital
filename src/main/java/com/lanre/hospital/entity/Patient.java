package com.lanre.hospital.entity;

import com.lanre.hospital.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
   private String firstName;
    @Column(name = "last_name")
   private String lastName;
    @Column(name = "date_of_birth")
     private LocalDate dateOfBirth;
    @Column(name="gender")
     @Enumerated(EnumType.STRING)
     private Gender gender;
    @Column(name="contact_number")
     private String contactNumber;
    @Column(name="email")
     private String email;
    @Column(name="address")
      private String address;
    @Column(name="emergency_contact")
    private String emergencyContact;
    @Column(name="blood_type")
    private String bloodType;
    @Column(name="allergies")
    private String allergies;
    @Column(name="medical_history")
       private String medicalHistory;

       //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }



    //Constructor


    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName,
                   LocalDate dateOfBirth, Gender gender, String contactNumber,
                   String email, String address, String emergencyContact,
                   String bloodType, String allergies, String medicalHistory) {
        this.id = id;
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
