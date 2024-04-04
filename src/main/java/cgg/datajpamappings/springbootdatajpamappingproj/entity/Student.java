package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
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

    @ManyToMany(mappedBy = "students")
// @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
// @JsonManagedReference
    @JsonIgnore
    // private Set<Course> courses=new HashSet<>();
    private Map<String,Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy="student")
    private List<Phone> phones;



}
