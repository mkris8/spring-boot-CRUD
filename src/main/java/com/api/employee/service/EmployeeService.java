package com.api.employee.service;

import com.api.employee.entity.Employee;
import com.api.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService  {

    @Autowired
    EmployeeRepository employeeRepository;

    //create

    //read
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    //update


    //delete

}
