package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Organization;
import com.example.learningmanagementsystem.model.Permission;
import com.example.learningmanagementsystem.service.OrganizationService;
import com.example.learningmanagementsystem.service.PermissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Permission Controller", description = "permission  CRUD işlemleri")
@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    private  PermissionService permissionService ;


    // CREATE
    @PostMapping
    public ResponseEntity<Permission> createBrand(@RequestBody Permission permission) {
        permissionService.TInsert(permission);
        return ResponseEntity.ok(permission);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<Permission>> getAllBrands() {
        return ResponseEntity.ok(permissionService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getBrandById(@PathVariable int id) {
        Permission permission = permissionService.TGetByID(id);
        return ResponseEntity.ok(permission);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updateBrand(@PathVariable UUID id, @RequestBody Permission permission) {
        permission.setId(id);
        permissionService.TUpdate(permission);
        return ResponseEntity.ok(permission);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        Permission permission = permissionService.TGetByID(id);
        permissionService.TDelete(permission);
        return ResponseEntity.noContent().build();
    }

    }
