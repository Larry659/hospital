package com.lanre.hospital.controller;

import com.lanre.hospital.entity.AppUser;
import com.lanre.hospital.request.AppUserRequest;
import com.lanre.hospital.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppUserController {
    @Autowired
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody AppUserRequest appUser) {
        appUserService.createUser(appUser);
    }
}
