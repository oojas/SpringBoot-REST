package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.StudentDTO;
import com.restfulapi.spring_rest.DTO.StudentResponseDTO;
import com.restfulapi.spring_rest.Modals.School;
import com.restfulapi.spring_rest.Modals.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMapper {
    public List<Student> toStudent(List<StudentDTO> studentDTO) {
        List<Student> student = new ArrayList<>();
        for (StudentDTO dto : studentDTO) {
            Student st = new Student();
            st.setFirstName(dto.firstName());
            st.setLastName(dto.lastName());
            st.setEmail(dto.email());
            School sc = new School();
            sc.setId(dto.schoolId());
            st.setSchool(sc);
            student.add(st);
        }
        return student;
    }

    public List<StudentResponseDTO> toStudentResponse(List<Student> student) {
        List<StudentResponseDTO> studentList = new ArrayList<>();
        for (Student st : student) {
            studentList.add(new StudentResponseDTO(st.getFirstName(), st.getLastName(), st.getEmail()));
        }
        return studentList;
    }
}
