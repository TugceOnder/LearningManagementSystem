package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Classroom;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.learningmanagementsystem.service.ClassroomService;

import java.util.List;
import java.util.UUID;

@Tag(name = "Classroom Controller", description = "Classroom CRUD işlemleri")
@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Classroom> createBrand(@RequestBody Classroom classroom) {
        classroomService.TInsert(classroom);
        return ResponseEntity.ok(classroom);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<Classroom>> getAllBrands() {
        return ResponseEntity.ok(classroomService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getBrandById(@PathVariable int id) {
        Classroom classroom = classroomService.TGetByID(id);
        return ResponseEntity.ok(classroom);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateBrand(@PathVariable UUID id, @RequestBody Classroom classroom) {
        classroom.setId(id);
        classroomService.TUpdate(classroom);
        return ResponseEntity.ok(classroom);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        Classroom classroom = classroomService.TGetByID(id);
        classroomService.TDelete(classroom);
        return ResponseEntity.noContent().build();
    }

}
