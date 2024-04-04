package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmployeePKId  implements Serializable{
    
    private int employeeId;
    private int deptId;
}
