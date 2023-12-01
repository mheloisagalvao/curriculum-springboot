package com.example.demo.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.model.Education;
import com.example.demo.controller.service.EducationService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducation(@PathVariable Long id) {
        Optional<Education> education = educationService.getEducationById(id);
        return education.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> allEducations = educationService.getAllEducations();
        return ResponseEntity.ok(allEducations);
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education savedEducation = educationService.saveEducation(education);
        return ResponseEntity.created(URI.create("/api/education/" + savedEducation.getId())).body(savedEducation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        Education updatedEducation = educationService.updateEducation(id, education);
        return ResponseEntity.ok(updatedEducation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
}
