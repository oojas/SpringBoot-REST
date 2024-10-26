package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.Modals.School;
import com.restfulapi.spring_rest.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;
    @PostMapping(value = "/enter/schoolName")
    public String enterSchoolName(@RequestBody School schoolName){
        schoolRepository.save(schoolName);
        String response="The school name with name "+schoolName.getName()+" has been stored";
        return response;
    }

    @GetMapping(value = "/getSchools")
    public List<School> getSchools(){
        List<School> schoolList=schoolRepository.findAll();
        return schoolList;
    }
}
