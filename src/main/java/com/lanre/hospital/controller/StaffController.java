package com.lanre.hospital.controller;

import com.lanre.hospital.request.AppUserRequest;
import com.lanre.hospital.request.StaffRequest;
import com.lanre.hospital.service.AppUserService;
import com.lanre.hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StaffController {
    @Autowired
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/staff")
    public void createStaff(@RequestBody StaffRequest request) {
        staffService.addStaff(request);
    }
}
