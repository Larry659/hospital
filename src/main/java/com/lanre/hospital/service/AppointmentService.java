package com.lanre.hospital.service;

import com.lanre.hospital.request.AppointmentRequest;
import com.lanre.hospital.request.PatientRequest;

public interface AppointmentService {
    void createAppointment(AppointmentRequest request);
}
