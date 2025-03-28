package com.lanre.hospital.controller;

import com.lanre.hospital.request.MedicineRequest;
import com.lanre.hospital.request.SupplierRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.MedicineService;
import com.lanre.hospital.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PostMapping("/supplier")
    public ApiResponse<?> saveMedicine(@RequestBody SupplierRequest request) {
    return supplierService.saveSupplier(request);
    }
}
