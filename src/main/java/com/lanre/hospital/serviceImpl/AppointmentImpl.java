package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.Appointment;
import com.lanre.hospital.entity.Patient;
import com.lanre.hospital.exception.RecordNotFoundException;
import com.lanre.hospital.repository.AppointmentRepo;
import com.lanre.hospital.repository.PatientRepo;
import com.lanre.hospital.request.AppointmentRequest;
import com.lanre.hospital.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class AppointmentImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final PatientRepo patientRepo;

    public AppointmentImpl(AppointmentRepo appointmentRepo, PatientRepo patientRepo) {
        this.appointmentRepo = appointmentRepo;
        this.patientRepo = patientRepo;
    }

    @Override
    public void createAppointment(AppointmentRequest request) {
        Patient  existingPatient = patientRepo.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());

        Appointment appointment = new Appointment();
        appointment.setDepartment(request.getDepartment());
        appointment.setStatus(request.getStatus());
        System.out.println("Appointment Date String: " + request.getAppointmentDate());
        appointment.setAppointmentDate(LocalDate.parse(request.getAppointmentDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        appointment.setAppointmentTime(LocalTime.parse(request.getAppointmentTime(),DateTimeFormatter.ofPattern("HH:mm:ss")));
        if (existingPatient == null) {
            throw new RecordNotFoundException("Patient with the following name " + request.getFirstName() + " " + request.getLastName() + " does not exist");
        }
        appointment.setPatient(existingPatient);
        appointmentRepo.save(appointment);


    }
}
