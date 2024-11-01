package com.restfulapi.spring_rest.repository;

import com.restfulapi.spring_rest.Modals.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(
            value = "SELECT * from author where first_ame=:firstName",
            nativeQuery = true
    )
    List<Object[]> findByFirstName(@Param("firstName") String firstName);

    List<Author> findAllByAgeGreaterThan(int age);
}
