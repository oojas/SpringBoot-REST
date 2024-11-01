package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.DTO.StudentDTO;
import com.restfulapi.spring_rest.DTO.StudentResponseDTO;
import com.restfulapi.spring_rest.Modals.Student;
import com.restfulapi.spring_rest.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //    @PostMapping(value = "/store")
//    public Student storeMessage(@RequestBody Student studentDetails) {
//       ; // this will save the student entity in the db.
//        // Post will make sure that the details are inserted. studentRepository.save() will pesist the values in the DB
//        return  studentRepository.save(studentDetails);
//    }
    @PostMapping(value = "/storeAll")
    public List<StudentResponseDTO> storeAllStudents(@Valid @RequestBody List<StudentDTO> studentList) { // The valid annotation basically tells the springboot that this object should not be null
        return this.studentService.storeStudents(studentList);
    }

    @GetMapping(value = "/getStudents")
    public List<StudentResponseDTO> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping(value = "/getStudent/{student-id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable("student-id") int id
    ) {
        return this.studentService.getStudentById(id);
        // this can also be written as return studentRepository.findById(id).orElse(new Student()). We have written this way to pass additional parameters like status code
    }

    @DeleteMapping(value = "student/delete/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteById(
            @PathVariable(value = "student-id") int id
    ) {
        return this.studentService.deleteStudentById(id);
    }

    @GetMapping(value = "/search/{first-name}")
    public List<Student> findByFirstName(@PathVariable(value = "first-name") String firstName) {
        return this.studentService.getStudentByFirstName(firstName);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
        Map<String,String> errors=new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach(
                objectError -> {
                    var fieldName=((FieldError)objectError).getField();
                    var fieldMessage=objectError.getDefaultMessage();
                    errors.put(fieldName,fieldMessage);
                }
        );
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/findStudentsByAge/{id}")
    public List<StudentResponseDTO> findByAgeAndSchoolId(@PathVariable(value = "id") int id){
        return studentService.findByAgeAndSchoolId(id);
    }
}
