package com.lanre.hospital.serviceImpl;


import com.lanre.hospital.entity.Staff;
import com.lanre.hospital.enums.Department;
import com.lanre.hospital.repository.StaffRepo;
import com.lanre.hospital.request.StaffRequest;
import com.lanre.hospital.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepository;


    StaffServiceImpl(StaffRepo staffRepository) {
        this.staffRepository = staffRepository;

    }

    @Override
    public void addStaff(StaffRequest request) {
       Staff staff = new Staff();
       staff.setFullName(request.getFullName());
       staff.setEmail(request.getEmail());
       staff.setPhone(request.getPhone());
       staff.setAddress(request.getAddress());
       staff.setGender(request.getGender());
       staff.setRole(request.getRole());
       staff.setSpecialty(request.getSpecialty());
       staff.setDepartment(request.getDepartment());
       staffRepository.save(staff);
    }
}
