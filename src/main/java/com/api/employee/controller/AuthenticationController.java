package com.api.employee.controller;

import com.api.employee.entity.Role;
import com.api.employee.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/encrypt/{input}")
    public String encrypt(@PathVariable String input){
        log.info("Encrypting :"+input);
        return new BCryptPasswordEncoder().encode(input);
    }

    @PostMapping("/saverole")
    public void insertRole(@RequestBody Role role) {
        log.info("Inserting encrypted role into DB :"+role);
        String rawPassword = role.getPassword();
        String encyptedPassword = encrypt(rawPassword);
        //set encrypted password before save to db
        role.setPassword(encyptedPassword);
        authenticationService.saveRole(role);

    }
}
