package com.restfulapi.spring_rest.Modals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data // Since we are using lombok in our pom, this helps in reducing the boiler plate code. @Data basically generates all the getters and setters and parameterized constructor for our class.
        // We can also use @Getter, @Setter separately if we want to just generate getters or setters.
@NoArgsConstructor // this generates a normal constructor without parameters because for Entity we need a normal constructor.
@EntityListeners(AuditingEntityListener.class) // this makes auditing of the record possible.
@AllArgsConstructor
public class Author {
     @GeneratedValue(
             strategy = GenerationType.AUTO
     ) // default value is AUTO.
//     @SequenceGenerator(name = "author_sequence",
//     sequenceName = "author_sequence",
//     allocationSize = 1 ) // default value is 50 which means every generated value will be incremented by 50. We are changing it to one.
     @Id // tells that this column is the primary key.
     private Integer id;// we are using Integer instead of int because default value of Integer is null but the default value of int is 0. so if we try to insert a new record it will see that id is 0 and would
     // update the fields of id 0 instead of inserting a new one.
     private String firstName;
     private String lastName;
     @Column(
             unique = true
     )
     private String email;
     private int age;
     @CreatedDate // makes possible to store the create date of the record each time a record is created.
     @Column(
             updatable = false,
             nullable = false

     )
     private LocalDateTime createDt;
     @LastModifiedDate // makes possible to update the date each time the record is updated
     @Column(
             updatable = true
     )
     private LocalDateTime updateDt;
}
