package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.CourseRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dao.StudentRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Course;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
    
    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student createStudentWithCourse(@RequestBody Student student){
             return this.studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/find/{name}")
    public List<Student> getStudentByNameContaing(@PathVariable String name){
          return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{value}")
    public List<Course> getCourseByFee(@PathVariable double value){
        return courseRepository.findByFeeLessThan(value);
    }
}
