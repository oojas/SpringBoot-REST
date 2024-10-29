package com.restfulapi.spring_rest.Controllers;

import com.restfulapi.spring_rest.DTO.SchoolDTO;
import com.restfulapi.spring_rest.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    // Our Service class.
    @Autowired
    private SchoolService schoolService;

    @PostMapping(value = "/enter/schoolName")
    public SchoolDTO storeSchoolName(@RequestBody SchoolDTO schoolName) {
        return this.schoolService.storeSchoolName(schoolName);
    }

    @GetMapping(value = "/getSchools")
    public List<SchoolDTO> getSchools() {
        return this.schoolService.getSchools();
    }
}
