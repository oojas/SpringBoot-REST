package com.restfulapi.spring_rest.DTO;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty // using validation package which tells the springboot that this field cannot be empty. We are using these annotations in the DTO record and not the modal class of student is because
                // the modal class of the student is the entity which basically means that it is the blueprint of the database. For DB validations we are using @Column annotation, But if we need to show
                // validation on the UI then we need validation package and we use @NotEmpty annotation with the fields that cannot be null in the record of StudentDTO because from the request body we are receiving
                // StudentDTO
        String firstName,
        @NotEmpty
        String lastName, // we can use message field for a customized message if we have to
        @NotEmpty
        String email,
        int age,
        Integer schoolId // for the school id.
) {
}
// there are alot of annotations which we can use with validation package. like @Email, Future, NotNull, Null, NotBlank etc