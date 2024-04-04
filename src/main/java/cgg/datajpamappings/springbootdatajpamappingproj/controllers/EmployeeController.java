package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.EmployeeRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee saveEmp(@RequestBody Employee employee){
        return this.employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }
}
