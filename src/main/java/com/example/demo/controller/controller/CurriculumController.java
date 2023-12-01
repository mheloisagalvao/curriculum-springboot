package com.example.demo.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.model.Curriculum;
import com.example.demo.controller.service.CurriculumService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getCurriculum(@PathVariable Long id) {
        Optional<Curriculum> curriculum = curriculumService.getCurriculumById(id);
        return curriculum.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAllCurricula() {
        List<Curriculum> allCurricula = curriculumService.getAllCurricula();
        return ResponseEntity.ok(allCurricula);
    }

    @PostMapping
    public ResponseEntity<Curriculum> createCurriculum(@RequestBody Curriculum curriculum) {
        Curriculum savedCurriculum = curriculumService.saveCurriculum(curriculum);
        return ResponseEntity.created(URI.create("/api/curriculum/" + savedCurriculum.getId())).body(savedCurriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> updateCurriculum(@PathVariable Long id, @RequestBody Curriculum curriculum) {
        Curriculum updatedCurriculum = curriculumService.updateCurriculum(id, curriculum);
        return ResponseEntity.ok(updatedCurriculum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable Long id) {
        curriculumService.deleteCurriculum(id);
        return ResponseEntity.noContent().build();
    }
}
