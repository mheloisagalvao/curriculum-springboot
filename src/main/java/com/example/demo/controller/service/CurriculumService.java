package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.model.Curriculum;
import com.example.demo.controller.repository.CurriculumRepository;

import java.util.Optional;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public Optional<Curriculum> getCurriculumById(Long id) {
        return curriculumRepository.findById(id);
    }

    public Curriculum saveCurriculum(Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }

}
