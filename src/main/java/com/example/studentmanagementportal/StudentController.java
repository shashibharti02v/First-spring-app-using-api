package com.example.studentmanagementportal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, Student> studentDb = new HashMap<>();

    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admnNo){
        return studentDb.get(admnNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentDb.put(student.getAdmnNo(), student);
        return "Student added successfully";
    }

    @GetMapping("/get/{id}/{message}")
    public String getStudentByPath(@PathVariable("id") int admnNo, @PathVariable(value = "message") String message){
       // if(message == null) return "Please Enter Message";
        return studentDb.get(admnNo) + message;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteStudent(@PathVariable("id") int admnNo){
        if(studentDb.containsKey(admnNo)){
            studentDb.remove(admnNo);
            return "Student removed successfully";
        }
        return "Please Enter Valid Admn No";
    }

    @PutMapping("/update_course")
    public Student updateCourse(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse){
        if(!studentDb.containsKey(admnNo)){
            throw new RuntimeException("Student does'nt exist");
        }
        Student student = studentDb.get(admnNo);
        student.setCourse(newCourse);
        return student;
    }

    @GetMapping("/total_student")
    public int totalStudent(){
        int total = 0;
        for(int admnNo: studentDb.keySet()){
            if(studentDb.get(admnNo).getAge() > 25) total++;
        }
        return total;
    }
}
