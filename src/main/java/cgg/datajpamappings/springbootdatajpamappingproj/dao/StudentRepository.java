package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);

    @Query("select s,c from Student s join s.courses c")
    List<Student> getStudentsWithCourses();

}
