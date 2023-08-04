package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admnNo){
        return studentService.getStudent(admnNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/get/{id}/{message}")
    public String getStudentByPath(@PathVariable("id") int admnNo, @PathVariable(value = "message") String message){
       // if(message == null) return "Please Enter Message";
        return studentService.getStudentByPath(admnNo , message);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteStudent(@PathVariable("id") int admnNo){
       return studentService.deleteStudent(admnNo);
    }

    @PutMapping("/update_course")
    public Student updateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
        return studentService.updateCourse(admnNo, newCourse);
    }

//    @GetMapping("/total_student")
//    public int totalStudent(){
//       return StudentService.totalStudent();
//    }
}
