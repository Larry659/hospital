package com.lanre.hospital.controller;

import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.request.PatientRequest;
import com.lanre.hospital.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping("/patient")
    public void savePatient(@RequestBody PatientRequest request) {
        patientService.save(request);
    }
}
