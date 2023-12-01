package com.example.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
