package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKey;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="COURSE_TBL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany
    // @JsonBackReference
    // @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    // @JsonBackReference
    @JoinTable(name="student_course",
    joinColumns = {@JoinColumn(name="c_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="s_id",referencedColumnName = "id")})
    // private Set<Student> students=new HashSet<>();
    @MapKey(name="name")
    private Map<String,Student> students;

    public void enrolledStudent(Student student) {
        // students.add(student);
        students.put(student.getName(), student);
    }

}
