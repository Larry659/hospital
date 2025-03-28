package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.Medicines;
import com.lanre.hospital.repository.MedicinesRepo;
import com.lanre.hospital.request.MedicineRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.MedicineService;
import com.lanre.hospital.util.AppUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MedicineImpl implements MedicineService {
    private final MedicinesRepo medicineRepo;

    public MedicineImpl(MedicinesRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    @Override
    public ApiResponse<?> addMedicines(MedicineRequest request) {
        Medicines medicines = new Medicines();
        medicines.setName(request.getName());
        medicines.setPrice(request.getPrice());
        medicines.setDescription(request.getDescription());
        medicines.setManufacturer(request.getManufacturer());
        medicines.setExpiryDate(LocalDate.parse(request.getExpiryDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        medicines.setQuantityInStock(request.getQuantityInStock());
        medicineRepo.save(medicines);
        return new ApiResponse<>(AppUtil.SUCCESS,"medicine with Id " + medicines.getMedicineId() + " added successfully");
    }
}
