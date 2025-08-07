package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.model.Brand;
import com.example.learningmanagementsystem.service.BrandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Brand Controller", description = "Marka CRUD işlemleri")
@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        brandService.TInsert(brand);
        return ResponseEntity.ok(brand);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.ok(brandService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int id) {
        Brand brand = brandService.TGetByID(id);
        return ResponseEntity.ok(brand);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable UUID id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.TUpdate(brand);
        return ResponseEntity.ok(brand);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        Brand brand = brandService.TGetByID(id);
        brandService.TDelete(brand);
        return ResponseEntity.noContent().build();
    }
}
