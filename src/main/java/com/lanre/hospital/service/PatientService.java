package com.lanre.hospital.service;

import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.request.PatientRequest;

public interface PatientService {
    void save(PatientRequest request);
}
