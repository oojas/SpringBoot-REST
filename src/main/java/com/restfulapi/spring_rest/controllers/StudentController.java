package com.restfulapi.spring_rest.controllers;

import com.restfulapi.spring_rest.Modals.Order;
import com.restfulapi.spring_rest.Modals.Student;
import com.restfulapi.spring_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping(value = "/storeMessage")
    public Student storeMessage(@RequestBody Student studentDetails) {
       ; // this will save the student entity in the db.
        // Post will make sure that the details are inserted. studentRepository.save() will pesist the values in the DB
        return  studentRepository.save(studentDetails);
    }
    @PostMapping(value = "/storeAll")
    public String storeAllStudents(@RequestBody List<Student> studentList){
        for(Student studentcargo:studentList){
            studentRepository.save(studentcargo);
        }
        return "All the student details are successfully saved";
    }
    @GetMapping(value = "/getStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping(value = "/getStudent/{student-id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable("student-id") int id
    ){
        return studentRepository.findById(id).map(student -> ResponseEntity.ok(student)).orElseGet(()->ResponseEntity.badRequest().body(new Student()));
        // this can also be written as return studentRepository.findById(id).orElse(new Student()). We have written this way to pass additional parameters like status code
    }
}