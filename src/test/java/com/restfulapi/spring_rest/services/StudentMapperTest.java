package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.StudentDTO;
import com.restfulapi.spring_rest.DTO.StudentResponseDTO;
import com.restfulapi.spring_rest.Modals.Student;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper studentMapper;
        @BeforeEach
        void setUp(){
            // this method will be called before each test method. This method can be used for opening services or declaring some variables.
            studentMapper=new StudentMapper();
        }
        @AfterEach
        void tearDown(){
            //this method will be called after each test method. This method can be used for closing the resources or dumping values. for example. In before each method you can add some values in the database
            // and in the after each method you can delete those values.
        }
        @BeforeAll
        static void beforeClass(){
            // this method will be called only once at the start of the class

        }
        @AfterAll
        static void afterClass(){
            //this method will be called after every method has been executed in the class. This will be called only once.
        }

        @Test // this annotation has to be added above every test method to tell sprinboot that this is a test method.
        public void checkStudentMapperForConvertingStudentObject(){
            StudentDTO dto=new StudentDTO("Ojas","Gupta","oojasgupta@gmail.com",104);
            List<StudentDTO> dtoList =new ArrayList<>();
            dtoList.add(dto);
           List<Student> student= studentMapper.toStudent(dtoList);
           student.forEach(
                   st->{
                       assertEquals(dto.firstName(),st.getFirstName());
                       assertEquals(dto.lastName(),st.getLastName());
                       assertEquals(dto.email(),st.getEmail());
                       assertNotNull(st.getSchool());
                       assertEquals(dto.schoolId(),st.getSchool().getId());
                   }
           );

        }

        @Test
        public void checkForStudentResponse(){
            Student st=new Student("Ojas","Gupta","oojasgupta@gmail.com");
            List<Student> studentList=new ArrayList<>();
            studentList.add(st);
           List<StudentResponseDTO> list=studentMapper.toStudentResponse(studentList);
            list.forEach(
                    lt->{
                        assertEquals(lt.firstName(),st.getFirstName());
                        assertEquals(lt.lastName(),st.getLastName());
                        assertEquals(lt.email(),st.getEmail());
                    }
            );
        }

        @Test
        public void checkIfStudentDTOIsNull(){
            assertThrows(NullPointerException.class,()->studentMapper.toStudent(null));
        }
}