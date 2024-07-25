package com.api.employee.service;

import com.api.employee.dto.EmployeeDTO;
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
    public EmployeeDTO saveEmployee(Employee employee){
        //return DTO instead of Entity here
//        return employeeRepository.save(employee);
        employee = employeeRepository.save(employee);
        return new EmployeeDTO(employee.getId(),employee.getName(),employee.getPassword());
    }

    //read
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public EmployeeDTO findEmployeeById(Integer id) {
        //return employeeRepository.findById(id);
        //return DTO instead of Entity here
        Optional<Employee> employee = employeeRepository.findById(id);
        //get id and name from optional , set into dto record and return
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.get().getId() , employee.get().getName(),employee.get().getPassword());
        return employeeDTO;
    }

    //delete
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
