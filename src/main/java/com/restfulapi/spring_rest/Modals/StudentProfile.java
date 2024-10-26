package com.restfulapi.spring_rest.Modals;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id;
    private String bio;
    @OneToOne
    @JoinColumn(
     name = "student_id",
     referencedColumnName = "id" // this will tell Springboot that the column to have join with student table is id column.
    )
    private Student student; // this should be exactly same as the string mentioned in onetoone mapping in Student profile.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public StudentProfile() {
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
