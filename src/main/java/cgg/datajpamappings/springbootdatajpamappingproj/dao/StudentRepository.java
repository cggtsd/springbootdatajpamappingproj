package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);

}
