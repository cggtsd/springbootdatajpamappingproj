package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
     
   List<Course> findByFeeLessThan(double value);
   // @Query("select c from Course c join fetch c.students s")
    @Query("select c from Course c where (select count(s) from Student s where c member of s.courses)>1")
    List<Course> getStudentsWithCourses();
}
