package com.restfulapi.spring_rest.repository;

import com.restfulapi.spring_rest.Modals.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
