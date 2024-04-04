package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EMPLOYEE_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @EmbeddedId
    private EmployeePKId employeePKId;
    private String name;
    private String email;
    private String phone;
    
}
