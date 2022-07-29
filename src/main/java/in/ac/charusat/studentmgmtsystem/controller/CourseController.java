package in.ac.charusat.studentmgmtsystem.controller;


import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/listCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }



    // Get the student information
    @GetMapping("/Course/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseRepository.findById(id).get();
    }



    // Delete the Course
    @DeleteMapping("/Course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }


    // Add new student
    @PostMapping("/Course")
    public List<Course> addCourse(@RequestBody Course Course) {
        courseRepository.save(Course);
        return courseRepository.findAll();
    }


    // Update the student information
    @PutMapping("/Course/{id}")
    public List<Course> updateStudent(@RequestBody Course Course, @PathVariable Integer id) {
        Course courseObj = courseRepository.findById(id).get();
        courseObj.setTitle(Course.getTitle());
        courseObj.setDescription(Course.getDescription());
        courseRepository.save(courseObj);
        return courseRepository.findAll();
    }


}
