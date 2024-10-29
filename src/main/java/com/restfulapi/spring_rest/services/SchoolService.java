package com.restfulapi.spring_rest.services;

import com.restfulapi.spring_rest.DTO.SchoolDTO;
import com.restfulapi.spring_rest.Modals.School;
import com.restfulapi.spring_rest.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SchoolMapper schoolMapper;

    public SchoolDTO storeSchoolName(SchoolDTO schoolName) {
        schoolRepository.save(schoolMapper.toSchool(schoolName));
        return schoolName;
    }

    public List<SchoolDTO> getSchools() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolMapper.toSchoolDTO(schoolList);
    }
}
