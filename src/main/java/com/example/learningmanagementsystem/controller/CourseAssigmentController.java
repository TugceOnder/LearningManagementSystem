package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.CourseAssignment;
import com.example.learningmanagementsystem.service.CourseAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CourseAssigment Controller", description = "CourseAssigment  CRUD işlemleri")
@RequestMapping("/api/courseassigment")
public class CourseAssigmentController {
    private final CourseAssignmentService courseAssignmentService ;

    public CourseAssigmentController(CourseAssignmentService courseAssignmentService) {
        this.courseAssignmentService = courseAssignmentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<CourseAssignment> createBrand(@RequestBody CourseAssignment courseAssignment) {
        courseAssignmentService.TInsert(courseAssignment);
        return ResponseEntity.ok(courseAssignment);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<CourseAssignment>> getAllBrands() {
        return ResponseEntity.ok(courseAssignmentService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseAssignment> getBrandById(@PathVariable int id) {
        CourseAssignment courseAssignment = courseAssignmentService.TGetByID(id);
        return ResponseEntity.ok(courseAssignment);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CourseAssignment> updateBrand(@PathVariable UUID id, @RequestBody CourseAssignment courseAssignment) {
        courseAssignment.setId(id);
        courseAssignmentService.TUpdate(courseAssignment);
        return ResponseEntity.ok(courseAssignment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        CourseAssignment courseAssignment = courseAssignmentService.TGetByID(id);
        courseAssignmentService.TDelete(courseAssignment);
        return ResponseEntity.noContent().build();
    }
}
