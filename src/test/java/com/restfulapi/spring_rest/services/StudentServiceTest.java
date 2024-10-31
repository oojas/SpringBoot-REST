package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.StudentDTO;
import com.restfulapi.spring_rest.DTO.StudentResponseDTO;
import com.restfulapi.spring_rest.Modals.Student;
import com.restfulapi.spring_rest.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceTest {
    @InjectMocks // Since mapper and repo are required in studentService and we need to inject them to use student service methods, so we are mkcing the injection here.
    StudentService studentService;
    @Mock // We are using Mock because we dont have the repo connection in the testing so we are mocking the repo.
    StudentRepository repository;
    @Mock
    StudentMapper studentMapper;
    @BeforeEach
    public void initialize(){
        MockitoAnnotations.openMocks(this); // opening all the resources. this means opening mocks for this class.
    }

    @Test
    public void verifySaveStudent(){
        Student student=new Student("Ojas","Gupta","oojasgupta@gmail.com");
        StudentDTO dto=new StudentDTO("Ojas","Gupta","oojasgupta@gmail.com",104);
        StudentResponseDTO stRes=new StudentResponseDTO("Ojas","Gupta","oojasgupta@gmail.com");
        List<StudentDTO> d=new ArrayList<>();
        d.add(dto);
        List<Student> st=new ArrayList<>();
        st.add(student);
        List<StudentResponseDTO> stres=new ArrayList<>();
        stres.add(stRes);
        when(studentMapper.toStudent(d)).thenReturn(st); /*
        when and then are basically used for mocking the behaviour. Like we cannot save the student in the repo because we dont have connection so we are telling the springboot what
        should happen if we call save and so on and so forth.
        */
        when(repository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponse(st)).thenReturn(stres);
         List<StudentResponseDTO> studentRes=studentService.storeStudents(d);
         studentRes.forEach(
                 stuRes->{
                     assertEquals(dto.firstName(),stuRes.firstName());
                     assertEquals(dto.lastName(),stuRes.lastName());
                     assertEquals(dto.email(),stuRes.email());
                 }
         );
    }
}