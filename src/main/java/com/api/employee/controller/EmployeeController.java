package com.api.employee.controller;

import com.api.employee.entity.Employee;
import com.api.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        System.out.println("Getting employee by Id .....");
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        System.out.println("Creating an employee .....");
        return employeeService.createEmployee(employee);
    }



}
