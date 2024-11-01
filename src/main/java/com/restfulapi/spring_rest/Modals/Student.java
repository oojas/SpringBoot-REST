package com.restfulapi.spring_rest.Modals;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity // Entity basically tells Java that this is a database blueprint. It will also create the bean for this class
@Table(name = "Student") // if we use this then the table name will be taken from this otherwise the table name will be the name of the class.
public class Student {
    @Id
    @GeneratedValue // This basically will generate a new value for every record. Similar to Unique_Trans_id or History_seq.
    private int id;
    @Column(name = "firstName") // Using @Column and giving name will be used for naming the column in the DB. This will override the actual variable name for DB only.
    // We can also give other things like size or nullable or insertable or updatable(like create_dt) values for the column in the column annotation.
    private String firstName;

    private String lastName;
    @Column(unique = true
    ) // This will tell the DB that email column should have unique values only.
    private String email;
    private int age;
    public Student(){ // this is declared because in order to create entity we have to have an empty constructor.

    }

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL // this means if I delete one student the student profile will also get deleted.
    )
    private StudentProfile studentProfile;
    @ManyToOne
    @JoinColumn(
            name = "school_id"// this creates a foreign key for mapping between two tables.
            // here we cant use reference column because id of school cannot be equal to id of student. for example : id ;1 school : Nagbani but id:1 student can be anyone so join query will not work.
    )
    @JsonBackReference // this is used in child class of the relationship to prevent infinit recursion
    private School school;
    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
