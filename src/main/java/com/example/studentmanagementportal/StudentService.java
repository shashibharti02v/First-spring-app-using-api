package com.example.studentmanagementportal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    //public int totalStudent() {
//        return StudentRepository.totalStudent();
//    }

    public  String getStudentByPath(int admnNo, String message) {
        Student s =  studentRepository.getStudentByPath(admnNo);
        return s + message;
    }

    public Student getStudent(int admnNo){

        return studentRepository.getStudent(admnNo);
    }

    public String addStudent(Student student){

        return studentRepository.addStudent(student) ;
    }

    public String deleteStudent(int admnNo) {
        return studentRepository.deleteStudent(admnNo);
    }

    public Student updateCourse(int admnNo, String newCourse) {
       return  studentRepository.updateCourse(admnNo, newCourse);
    }
}
