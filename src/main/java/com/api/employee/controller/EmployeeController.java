package com.api.employee.controller;

import com.api.employee.entity.Employee;
import com.api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        System.out.println("Getting all the employees .....");
        return employeeService.findAllEmployees();
    }

    @PostMapping("/create")
    public Employee createEmployee(Employee employee){
        System.out.println("Creating an employee .....");
        return employeeService.createEmployee(employee);
    }

}
