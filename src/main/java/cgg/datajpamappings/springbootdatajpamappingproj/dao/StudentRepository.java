package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Course;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);

    // @Query("select new cgg.datajpamappings.springbootdatajpamappingproj.dto.StudentCountDTO(s.age ,count(s)) from Student s group by s.age having s.age>20")
    // @Query("select c from Course c where (select count(s) from Student s where c member of s.courses)>1")
    // @Query("select c from Course c join fetch c.students s")
    @Query("select c from Student s,Course c ")
    List<Course> getStudentsWithCourses();
 
}
