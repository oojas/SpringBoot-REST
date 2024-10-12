package com.restfulapi.spring_rest.Modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id;
    private String bio;

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public StudentProfile() {
    }
}
