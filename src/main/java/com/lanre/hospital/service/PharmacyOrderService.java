package com.lanre.hospital.service;

import com.lanre.hospital.entity.PharmacyOrder;
import com.lanre.hospital.request.PharmacyOrderRequest;
import com.lanre.hospital.response.ApiResponse;

public interface PharmacyOrderService {
    ApiResponse<?> createOrder(PharmacyOrderRequest request);
}
