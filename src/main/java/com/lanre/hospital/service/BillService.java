package com.lanre.hospital.service;

import com.lanre.hospital.request.BillRequest;
import com.lanre.hospital.response.ApiResponse;

public interface BillService {
    ApiResponse<?> createBilling(BillRequest request);
}
