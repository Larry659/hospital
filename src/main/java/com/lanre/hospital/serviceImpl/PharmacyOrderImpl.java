package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.Medicines;
import com.lanre.hospital.entity.PharmacyOrder;
import com.lanre.hospital.entity.Supplier;
import com.lanre.hospital.enums.DeliveryStatus;
import com.lanre.hospital.repository.MedicinesRepo;
import com.lanre.hospital.repository.PharmacyOrderRepo;
import com.lanre.hospital.repository.SupplierRepo;
import com.lanre.hospital.request.PharmacyOrderRequest;
import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.service.PharmacyOrderService;
import com.lanre.hospital.util.AppCode;
import com.lanre.hospital.util.AppUtil;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PharmacyOrderImpl implements PharmacyOrderService {
    private final PharmacyOrderRepo pharmacyOrderRepo;
    private final MedicinesRepo medicinesRepo;
    private final SupplierRepo supplierRepo;
    public PharmacyOrderImpl(PharmacyOrderRepo pharmacyOrderRepo,MedicinesRepo medicinesRepo,SupplierRepo supplierRepo) {
        this.pharmacyOrderRepo = pharmacyOrderRepo;
        this.medicinesRepo = medicinesRepo;
        this.supplierRepo = supplierRepo;
    }
//    private Medicines medicineId;
//    private Supplier supplierId;



    @Override
    public ApiResponse<?> createOrder(PharmacyOrderRequest request) {
        Medicines orderMedicine = medicinesRepo.findByName(request.getMedicineName());
        Supplier supplier = supplierRepo.findByName(request.getSupplierName());
        PharmacyOrder pharmacyOrder = new PharmacyOrder();
        pharmacyOrder.setOrderDate(LocalDate.now());
        pharmacyOrder.setDeliverystatus(request.getDeliverystatus());
        pharmacyOrder.setQuantity(request.getQuantity());
        if(orderMedicine==null){
            Medicines newlyOrdered = new Medicines();
            newlyOrdered.setQuantityInStock(request.getQuantity());
            newlyOrdered.setName(request.getMedicineName());
            newlyOrdered.setPrice(request.getPrice());
            newlyOrdered.setDescription(request.getDescription());
            newlyOrdered.setManufacturer(request.getManufacturer());
            newlyOrdered.setExpiryDate(request.getExpiryDate());
            pharmacyOrder.setMedicineId(newlyOrdered);
        }
        else
        {
            orderMedicine.setQuantityInStock(orderMedicine.getQuantityInStock()+ request.getQuantity());
            pharmacyOrder.setMedicineId(orderMedicine);
        }
        if(supplier==null){
            Supplier newSupplier = new Supplier();
            newSupplier.setName(request.getSupplierName());
            newSupplier.setContactPerson(request.getSupplierName());
            newSupplier.setEmail(request.getSupplierEmail());
            newSupplier.setContactPerson(request.getSupplierPerson());
            newSupplier.setContactPhone(request.getSupplierPhone());
            pharmacyOrder.setSupplierId(newSupplier);
        }
        else
            pharmacyOrder.setSupplierId(supplier);
        pharmacyOrderRepo.save(pharmacyOrder);
        return new ApiResponse<>(AppUtil.SUCCESS, AppCode.CREATED,"This order " + pharmacyOrder.toString() + " has been created");
    }
}
