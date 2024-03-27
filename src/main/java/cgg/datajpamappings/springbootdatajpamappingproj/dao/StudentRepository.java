package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cgg.datajpamappings.springbootdatajpamappingproj.dto.StudentCourseDTO;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);

    @Query("select new cgg.datajpamappings.springbootdatajpamappingproj.dto.StudentCourseDTO(upper(s.name),upper(c.title) )from Student s join s.courses c")
    List<StudentCourseDTO> getStudentsWithCourses();
 
}
