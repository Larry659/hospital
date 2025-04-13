package com.lanre.hospital.controller;


import com.lanre.hospital.request.BillRequest;
import com.lanre.hospital.service.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    @PostMapping("/bill")
    public void createBill(@RequestBody BillRequest request) {
      billService.createBilling(request);
    }
}
