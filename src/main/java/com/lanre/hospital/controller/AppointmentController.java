package com.lanre.hospital.controller;

import com.lanre.hospital.request.AppointmentRequest;
import com.lanre.hospital.request.PatientRequest;
import com.lanre.hospital.service.AppointmentService;
import com.lanre.hospital.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {

        this.appointmentService = appointmentService;
    }
    @PostMapping("/appointment")
    public void createAppointment(@RequestBody AppointmentRequest request) {
      appointmentService.createAppointment(request);
    }
}
