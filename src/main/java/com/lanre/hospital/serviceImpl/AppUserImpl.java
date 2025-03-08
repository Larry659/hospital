package com.lanre.hospital.serviceImpl;

import com.lanre.hospital.entity.AppUser;
import com.lanre.hospital.repository.AppUserRepo;
import com.lanre.hospital.request.AppUserRequest;
import com.lanre.hospital.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

@Service
public class AppUserImpl implements AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserImpl(AppUserRepo appUserRepo) {

        this.appUserRepo = appUserRepo;
    }




    @Override
    public void createUser(AppUserRequest userRequest) {
        AppUser appUser = new AppUser();
        appUser.setUserName(userRequest.getUserName());
        appUser.setFirstName(userRequest.getFirstName());
        appUser.setLastName(userRequest.getLastName());
        appUser.setRole(userRequest.getRole());
        appUser.setPassword(userRequest.getPassword());

appUserRepo.save(appUser);
        System.out.println("User created: " + appUser.toString());
    }
}
