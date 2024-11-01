package com.restfulapi.spring_rest.repository;
import java.util.List;
import com.restfulapi.spring_rest.Modals.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

// we dont need to make this class as @Component because Java will understand and by extending JpaRepository the bean will automatically be created.
public interface StudentRepository extends JpaRepository<Student,Integer> {
    // Student is the type of our repositiry and Integer is the unique identifier which in our case is the ID column of our student class.
    List<Student> findAllByFirstNameContaining(String firstName);

    @Query(
           value = "select * from student where age>35 and school_id=:id",
            nativeQuery = true
    )
    List<Student> findAllByAgeAndSchoolId(@PathVariable(value = "id") int id);

}
