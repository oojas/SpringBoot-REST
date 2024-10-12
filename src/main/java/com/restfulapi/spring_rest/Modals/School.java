package com.restfulapi.spring_rest.Modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }
}
