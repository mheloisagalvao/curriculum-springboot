package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.model.Experience;
import com.example.demo.controller.repository.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> getAllExperiences() {
        return null;
    }

    public Experience updateExperience(Long id, Experience experience) {
        return null;
    }

    public void deleteExperience(Long id) {
    }

}
