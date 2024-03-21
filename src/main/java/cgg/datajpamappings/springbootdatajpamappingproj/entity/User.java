package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    private int id;
    private String name;
    private String profession;
    private int age;
}
