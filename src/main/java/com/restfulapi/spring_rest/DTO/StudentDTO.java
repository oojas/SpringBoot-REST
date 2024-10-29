package com.restfulapi.spring_rest.DTO;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer schoolId // for the school id.
) {
}
