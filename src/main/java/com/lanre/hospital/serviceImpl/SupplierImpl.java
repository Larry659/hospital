package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.Supplier;
import com.lanre.hospital.repository.SupplierRepo;
import com.lanre.hospital.request.SupplierRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.SupplierService;
import com.lanre.hospital.util.AppUtil;
import org.springframework.stereotype.Service;

@Service
public class SupplierImpl implements SupplierService {
    private final SupplierRepo supplierRepo;

    public SupplierImpl(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }
    @Override
    public ApiResponse<?> saveSupplier(SupplierRequest request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setContactPhone(request.getContactPhone());
        supplier.setEmail(request.getEmail());
       supplier.setContactPerson(request.getContactPerson());
        supplierRepo.save(supplier);
        return new ApiResponse<>(AppUtil.SUCCESS,"supplier with id " + supplier.getSupplierId() + " saved successfully");
    }
}
