package com.example.studentmanagementportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentRepository {

    Map<Integer, Student> studentDb = new HashMap<>();

//    public  int totalStudent() {
//        int totalStudent = 0;
//        for(int admnNo: studentDb.keySet()){
//            if(studentDb.get(admnNo).getAge() > 25){
//                totalStudent++;
//            }
//        }
//        return totalStudent;
//    }

    public  Student getStudentByPath(int admnNo) {
        return studentDb.get(admnNo);
    }

    public  String addStudent(Student student) {
        if(studentDb.containsKey(student.getAdmnNo())){
            return "Student already present";
        }
        else{
            studentDb.put(student.getAdmnNo(), student);
            return "Student added successfully";
        }
    }

    public Student getStudent(int admnNo){
        return studentDb.get(admnNo);
    }

    public String deleteStudent(int admnNo) {
        if(!studentDb.containsKey(admnNo))
            return "Please enter valid admission number";
        else{
            studentDb.remove(admnNo);
            return " Student removed Successfully";
        }
    }

    public Student updateCourse(int admnNo, String newCourse) {
        if(!studentDb.containsKey(admnNo))
            throw new RuntimeException("Student doesn't exists");
       else{
           Student student = studentDb.get(admnNo);
           student.setCourse(newCourse);
           return student;
        }
    }
}
