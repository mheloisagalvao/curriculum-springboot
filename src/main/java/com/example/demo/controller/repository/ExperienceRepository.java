package com.example.demo.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
