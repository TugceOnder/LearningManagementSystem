package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Organization;
import com.example.learningmanagementsystem.service.OrganizationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Organization Controller", description = "Organization CRUD işlemleri")
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService ;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Organization> createBrand(@RequestBody Organization organization) {
        organizationService.TInsert(organization);
        return ResponseEntity.ok(organization);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<Organization>> getAllBrands() {
        return ResponseEntity.ok(organizationService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getBrandById(@PathVariable int id) {
        Organization organization = organizationService.TGetByID(id);
        return ResponseEntity.ok(organization);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateBrand(@PathVariable UUID id, @RequestBody Organization organization) {
        organization.setId(id);
        organizationService.TUpdate(organization);
        return ResponseEntity.ok(organization);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        Organization organization = organizationService.TGetByID(id);
        organizationService.TDelete(organization);
        return ResponseEntity.noContent().build();
    }
}
