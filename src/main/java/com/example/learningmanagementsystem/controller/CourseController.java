package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Course Controller", description = "Course CRUD işlemleri")
@RestController

@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService ;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Course> createBrand(@RequestBody Course course) {
        courseService.TInsert(course);
        return ResponseEntity.ok(course);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllBrands() {
        return ResponseEntity.ok(courseService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getBrandById(@PathVariable int id) {
        Course course = courseService.TGetByID(id);
        return ResponseEntity.ok(course);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateBrand(@PathVariable UUID id, @RequestBody Course course) {
        course.setId(id);
        courseService.TUpdate(course);
        return ResponseEntity.ok(course);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        Course course = courseService.TGetByID(id);
        courseService.TDelete(course);
        return ResponseEntity.noContent().build();
    }
}
