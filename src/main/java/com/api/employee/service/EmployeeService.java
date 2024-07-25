package com.api.employee.service;

import com.api.employee.dto.EmployeeDTO;
import com.api.employee.entity.Employee;
import com.api.employee.exception.EmployeeAlreadyExistsException;
import com.api.employee.exception.EmployeeNotFoundException;
import com.api.employee.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService  {

    @Autowired
    EmployeeRepository employeeRepository;

    //create
    public EmployeeDTO saveEmployee(Employee employee){
        //return DTO instead of Entity here
//        return employeeRepository.save(employee);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee.getId(),employee.getName(),employee.getPassword());
    }

    //if an employee already exists, then abort. Else insert.
    public EmployeeDTO updateEmployee(@Valid @RequestBody Employee incomingEmployee) {
        Employee existingEmployee = employeeRepository.findById(incomingEmployee.getId()).orElse(null);
        if(existingEmployee != null) {
            throw new EmployeeAlreadyExistsException("Employee already exists. Wont insert .....");
        }
        Employee employee = employeeRepository.save(incomingEmployee);
        return new EmployeeDTO(employee.getId(),employee.getName(),employee.getPassword());
    }

    //read
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeDTO findEmployeeById(Integer id) {
        //return employeeRepository.findById(id);
        //return DTO instead of Entity here
        //use custom exception here
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with the given id!!"));
        //get id and name from optional , set into dto record and return
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId() , employee.getName(),employee.getPassword());
        return employeeDTO;
    }

    //delete
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
