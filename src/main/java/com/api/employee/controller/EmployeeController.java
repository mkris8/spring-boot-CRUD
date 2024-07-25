package com.api.employee.controller;

import com.api.employee.dto.EmployeeDTO;
import com.api.employee.entity.Employee;
import com.api.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        log.info("Getting all the employees .....");
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
        log.info("Getting employee by Id .....");
        //return employeeService.findEmployeeById(id);
        //return DTO instead of entity
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/create")
    // validation added with @Valid
    public EmployeeDTO createEmployee(@Valid @RequestBody Employee employee){
        log.info("Creating an employee .....");
        //return DTO instead of Entity here
        //return employeeService.saveEmployee(employee);
        employeeService.saveEmployee(employee);
        return new EmployeeDTO(employee.getId(),employee.getName(), employee.getPassword());
    }

    @PostMapping("/update")
    public EmployeeDTO updateEmployee(@Valid @RequestBody Employee incomingEmployee) {
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(incomingEmployee.getId());
        Employee employee = new Employee();
        employee.setId(employeeDTO.id());
        employee.setName(incomingEmployee.getName());
        employee.setPassword(incomingEmployee.getPassword());
        employeeService.saveEmployee(employee);
        return employeeService.saveEmployee(employee);




    }

    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

}
