package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.model.Education;
import com.example.demo.controller.repository.EducationRepository;

import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;

    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }

}
