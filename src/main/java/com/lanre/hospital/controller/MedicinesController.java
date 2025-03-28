package com.lanre.hospital.controller;

import com.lanre.hospital.request.MedicineRequest;
import com.lanre.hospital.request.PatientRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.MedicineService;
import com.lanre.hospital.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MedicinesController {
    private final MedicineService medicineService;

    public MedicinesController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }
    @PostMapping("/medicine")
    public ApiResponse<?> saveMedicine(@RequestBody MedicineRequest request) {
      return  medicineService.addMedicines(request);
    }
}
