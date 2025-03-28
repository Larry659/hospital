package com.lanre.hospital.service;

import com.lanre.hospital.request.SupplierRequest;
import com.lanre.hospital.response.ApiResponse;

public interface SupplierService {
    ApiResponse<?> saveSupplier(SupplierRequest request);
}
