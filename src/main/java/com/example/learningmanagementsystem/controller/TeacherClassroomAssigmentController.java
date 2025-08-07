package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Organization;
import com.example.learningmanagementsystem.model.TeacherClassroomAssignment;
import com.example.learningmanagementsystem.service.OrganizationService;
import com.example.learningmanagementsystem.service.TeacherClassroomAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TeacherClassroomAssigment Controller", description = "Organization CRUD işlemleri")
@RestController
@RequestMapping("/api/TeacherClassroomAssigment")
public class TeacherClassroomAssigmentController {
    private final TeacherClassroomAssignmentService teacherClassroomAssignmentService ;

    public TeacherClassroomAssigmentController(TeacherClassroomAssignmentService teacherClassroomAssignmentService) {
        this.teacherClassroomAssignmentService = teacherClassroomAssignmentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TeacherClassroomAssignment> createBrand(@RequestBody TeacherClassroomAssignment teacherClassroomAssignment) {
        teacherClassroomAssignmentService.TInsert(teacherClassroomAssignment);
        return ResponseEntity.ok(teacherClassroomAssignment);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<TeacherClassroomAssignment>> getAllBrands() {
        return ResponseEntity.ok(teacherClassroomAssignmentService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TeacherClassroomAssignment> getBrandById(@PathVariable int id) {
        TeacherClassroomAssignment  teacherClassroomAssignment = teacherClassroomAssignmentService.TGetByID(id);
        return ResponseEntity.ok(teacherClassroomAssignment);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TeacherClassroomAssignment> updateBrand(@PathVariable UUID id, @RequestBody TeacherClassroomAssignment teacherClassroomAssignment) {
        teacherClassroomAssignment.setId(id);
        teacherClassroomAssignmentService.TUpdate(teacherClassroomAssignment);
        return ResponseEntity.ok(teacherClassroomAssignment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        TeacherClassroomAssignment teacherClassroomAssignment = teacherClassroomAssignmentService.TGetByID(id);
        teacherClassroomAssignmentService.TDelete(teacherClassroomAssignment);
        return ResponseEntity.noContent().build();
    }
}
