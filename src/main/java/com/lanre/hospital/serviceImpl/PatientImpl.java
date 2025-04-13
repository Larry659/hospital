package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.entity.Wallet;
import com.lanre.hospital.repository.PatientRepo;
import com.lanre.hospital.repository.WalletRepo;
import com.lanre.hospital.request.PatientRequest;
import com.lanre.hospital.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PatientImpl implements PatientService {

    private final Logger log = LoggerFactory.getLogger(PatientImpl.class);

    private final PatientRepo patientRepo;
    private final WalletRepo walletRepo;

   public PatientImpl(PatientRepo patientRepo, WalletRepo walletRepo) {
       this.patientRepo = patientRepo;
       this.walletRepo = walletRepo;
   }
    @Override
    @Transactional

    public void save(PatientRequest request) {
       Patient patient = new Patient();
       patient.setFirstName(request.getFirstName());
       patient.setLastName(request.getLastName());
       patient.setEmail(request.getEmail());
        patient.setAddress(request.getAddress());
        patient.setGender(request.getGender());
        patient.setAllergies(request.getAllergies());
        patient.setBloodType(request.getBloodType());
        patient.setContactNumber(request.getContactNumber());
        patient.setEmergencyContact(request.getEmergencyContact());
        log.info("Date: {}, ", request.getDateOfBirth());
        log.info("Address: {}, ", request.getAddress());
        patient.setDateOfBirth(LocalDate.parse(request.getDateOfBirth(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        patient.setDateOfBirth(LocalDate.now());
        patient.setMedicalHistory(request.getMedicalHistory());
        // create wallet for patient
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        wallet.setBalanceBefore(0.0);
        wallet.setBalanceAfter(0.0);
        wallet.setCreatedAt(LocalDate.now());
       // wallet.setUpdatedAt(LocalDate.now());// update should come from when transaction is made
        wallet.setPatient(patient);
        walletRepo.save(wallet);
        patient.setWallet(wallet);
        System.out.println("saving patient");
    patientRepo.save(patient);
        System.out.println("Patient :" + patient.toString());
    }
}
