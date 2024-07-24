package com.api.employee.service;

import com.api.employee.entity.Employee;
import com.api.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService  {

    @Autowired
    EmployeeRepository employeeRepository;

    //create
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //read
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    //update


    //delete

}
