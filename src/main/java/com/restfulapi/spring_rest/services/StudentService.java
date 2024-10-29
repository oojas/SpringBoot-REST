package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.StudentDTO;
import com.restfulapi.spring_rest.DTO.StudentResponseDTO;
import com.restfulapi.spring_rest.Modals.Student;
import com.restfulapi.spring_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentResponseDTO> storeStudents(List<StudentDTO> studentDTOList) {
        List<Student> student = studentRepository.saveAll(studentMapper.toStudent(studentDTOList));
        return studentMapper.toStudentResponse(student);
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentMapper.toStudentResponse(studentList);
    }

    public ResponseEntity<Student> getStudentById(int id) {
        return studentRepository.findById(id).map(student -> ResponseEntity.ok(student)).orElseGet(() -> ResponseEntity.badRequest().body(new Student()));
    }

    public ResponseEntity<String> deleteStudentById(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("The student details with the id " + id + " have been deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The id does not exist in the database");
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findAllByFirstNameContaining(firstName);
    }
}
