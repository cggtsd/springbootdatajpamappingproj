package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="STUDENT_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(cascade = CascadeType.ALL)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JoinTable(name="student_course",
    joinColumns = {@JoinColumn(name="s_fk",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="c_fk",referencedColumnName = "id")})
    private Set<Course> courses;

}
