package com.lanre.hospital.serviceImpl;


import com.lanre.hospital.entity.Bill;
import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.exception.RecordNotFoundException;
import com.lanre.hospital.repository.BillRepo;
import com.lanre.hospital.repository.PatientRepo;
import com.lanre.hospital.request.BillRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.BillService;
import com.lanre.hospital.util.AppCode;
import com.lanre.hospital.util.AppUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepo billRepo;
    private final PatientRepo patientRepo;

    public BillServiceImpl(BillRepo billRepo, PatientRepo patientRepo) {
        this.billRepo = billRepo;
        this.patientRepo = patientRepo;
    }
    @Override
    public ApiResponse<?> createBilling(BillRequest request) {
       Patient patient = patientRepo.findByFirstNameAndLastName(request.getPatientFirstName(),request.getPatientLastName());
       if (patient == null) {
           throw new RecordNotFoundException("Patient with names " + request.getPatientFirstName() + " " + request.getPatientLastName() + " not found");
       }
        Bill bill = new Bill();
        bill.setPatient(patient);
        bill.setAppointment(patient.getAppointment());
        //come back to this code to make it dynamic from payment API
        bill.setStatus(request.getStatus());
        bill.setPaidAmount(request.getPaidAmount());
        bill.setTotalAmount(request.getTotalAmount());
        bill.setDateIssued(LocalDate.now());
        bill.setBalance(request.getTotalAmount()-request.getPaidAmount());
        billRepo.save(bill);
        return new ApiResponse<>(AppUtil.SUCCESS, AppCode.CREATED,"This bill " + bill.toString() + " has been created");
    }
}
