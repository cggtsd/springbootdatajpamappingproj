package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
     
   List<Course> findByFeeLessThan(double value);
}
