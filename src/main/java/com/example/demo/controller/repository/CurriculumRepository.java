package com.example.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.model.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
