package com.lanre.hospital.service;

import com.lanre.hospital.request.MedicineRequest;
import com.lanre.hospital.response.ApiResponse;

public interface MedicineService {
    ApiResponse<?> addMedicines(MedicineRequest request);
}
