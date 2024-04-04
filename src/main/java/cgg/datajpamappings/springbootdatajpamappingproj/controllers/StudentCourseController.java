package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.CourseRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dao.PhoneRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dao.StudentRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Course;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Phone;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Student;

@RestController
public class StudentCourseController {
    
    private StudentRepository studentRepository;

    private CourseRepository courseRepository;
    private PhoneRepository phoneRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository,
            PhoneRepository phoneRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.phoneRepository = phoneRepository;
    }
    
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
             return this.studentRepository.save(student);
    }
    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course){
             return this.courseRepository.save(course);
    }
    @PostMapping("/phone")
    public Phone createPhone(@RequestBody Phone ph){
             return this.phoneRepository.save(ph);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public Course enrollStudentToCourse(@PathVariable long courseId,@PathVariable long studentId){
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();

        course.enrolledStudent(student);

        return courseRepository.save(course);

    }
    @PutMapping("/{phoneId}/student/{studentId}")
    public Phone assignPhoneToStudent(@PathVariable long phoneId,@PathVariable long studentId){
        Student student = studentRepository.findById(studentId).get();
        Phone phone = phoneRepository.findById(phoneId).get();

        phone.assignPhoneToStudent(student);

        return phoneRepository.save(phone);

    }

    @GetMapping("/find/{name}")
    public List<Student> getStudentByNameContaing(@PathVariable String name){
          return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{value}")
    public List<Course> getCourseByFee(@PathVariable double value){
        return courseRepository.findByFeeLessThan(value);
    }

    @GetMapping("/")
    public List<Course> getAllStudentsCourses(){
        
      // List<StudentCourseDTO> students= this.studentRepository.getStudentsWithCourses();
      List<Course> c= this.courseRepository.getStudentsWithCourses();
    //   System.out.println(students.toString());
      return c;

    }
}
