package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.SchoolDTO;
import com.restfulapi.spring_rest.Modals.School;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDTO schoolDTO) {
        School sc = new School();
        sc.setName(schoolDTO.name());
        return sc;
    }

    public List<SchoolDTO> toSchoolDTO(List<School> schoolList) {
        List<SchoolDTO> sc = new ArrayList<>();
        for (School scl : schoolList) {
            sc.add(new SchoolDTO(scl.getName()));
        }
        return sc;
    }
}
