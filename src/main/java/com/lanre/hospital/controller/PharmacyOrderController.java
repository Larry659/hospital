package com.lanre.hospital.controller;

import com.lanre.hospital.request.PharmacyOrderRequest;
import com.lanre.hospital.request.SupplierRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.PharmacyOrderService;
import com.lanre.hospital.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PharmacyOrderController {
    private final PharmacyOrderService pharmacyOrderService;

    public PharmacyOrderController(PharmacyOrderService pharmacyOrderService) {
        this.pharmacyOrderService = pharmacyOrderService;
    }
    @PostMapping("/order")
    public ApiResponse<?> createOrder(@RequestBody PharmacyOrderRequest request) {
    return pharmacyOrderService.createOrder(request);
    }
}
