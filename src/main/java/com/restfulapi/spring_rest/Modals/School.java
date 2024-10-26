package com.restfulapi.spring_rest.Modals;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference // Since this is the parent of the relationship so managed reference is used to tell the springboot the json is not needed to deserialize.
    private List<Student> student;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }
    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
