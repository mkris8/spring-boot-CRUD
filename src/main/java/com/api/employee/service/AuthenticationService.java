package com.api.employee.service;

import com.api.employee.entity.Role;
import com.api.employee.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {

    @Autowired
    RoleRepository roleRepository;

    //save password into db
    public void saveRole(Role role){
        log.info("Invoked AuthenticationService to save role...");
        roleRepository.save(role);
    }

}
