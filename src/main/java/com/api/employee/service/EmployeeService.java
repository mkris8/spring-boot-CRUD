package com.api.employee.service;

import com.api.employee.entity.Employee;
import com.api.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
