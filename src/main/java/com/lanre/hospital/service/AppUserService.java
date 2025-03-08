package com.lanre.hospital.service;

import com.lanre.hospital.entity.AppUser;
import com.lanre.hospital.request.AppUserRequest;

public interface AppUserService {
    void createUser(AppUserRequest request);
}
