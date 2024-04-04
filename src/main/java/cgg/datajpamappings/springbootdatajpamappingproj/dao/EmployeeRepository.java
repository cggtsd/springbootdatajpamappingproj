package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Employee;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.EmployeePKId;

public interface EmployeeRepository  extends JpaRepository<Employee,EmployeePKId>{
    
}
