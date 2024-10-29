package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.DTO.SchoolDTO;
import com.restfulapi.spring_rest.Modals.School;
import com.restfulapi.spring_rest.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;
    @PostMapping(value = "/enter/schoolName")
    public SchoolDTO enterSchoolName(@RequestBody SchoolDTO schoolName){
        schoolRepository.save(toSchool(schoolName));
       return schoolName;
    }

    @GetMapping(value = "/getSchools")
    public List<SchoolDTO> getSchools(){
        List<School> schoolList=schoolRepository.findAll();
        return toSchoolDTO(schoolList);
    }
    private School toSchool(SchoolDTO schoolDTO){
        School sc=new School();
        sc.setName(schoolDTO.name());
        return sc;
    }
    private List<SchoolDTO> toSchoolDTO(List<School> schoolList){
        List<SchoolDTO> sc=new ArrayList<>();
        for(School scl:schoolList){
            sc.add(new SchoolDTO(scl.getName()));
        }
        return sc;
    }
}
