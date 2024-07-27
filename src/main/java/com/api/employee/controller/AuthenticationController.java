package com.api.employee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @GetMapping("/encrypt/{input}")
    public String encrypt(@PathVariable String input){
        log.info("Encrypting :"+input);
        return new BCryptPasswordEncoder().encode(input);
    }
}
