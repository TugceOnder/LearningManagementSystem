package com.example.learningmanagementsystem.controller;
import com.example.learningmanagementsystem.model.ProfileType;
import com.example.learningmanagementsystem.service.ProfileTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Organization Controller", description = "Organization CRUD işlemleri")
@RestController
@RequestMapping("/api/profiletypes")
public class ProfileTypeController {

    private final ProfileTypeService profileTypeService ;

    public ProfileTypeController(ProfileTypeService profileTypeService) {
        this.profileTypeService = profileTypeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProfileType> createBrand(@RequestBody ProfileType profileType) {
        profileTypeService.TInsert(profileType);
        return ResponseEntity.ok(profileType);
    }

    // READ - GET ALL
    @GetMapping
    public ResponseEntity<List<ProfileType>> getAllBrands() {
        return ResponseEntity.ok(profileTypeService.TGetList());
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfileType> getBrandById(@PathVariable int id) {
        ProfileType profileType = profileTypeService.TGetByID(id);
        return ResponseEntity.ok(profileType);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProfileType> updateBrand(@PathVariable int id, @RequestBody ProfileType profileType) {
        profileType.setId(id);
        profileTypeService.TUpdate(profileType);
        return ResponseEntity.ok(profileType);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id) {
        ProfileType profileType = profileTypeService.TGetByID(id);
        profileTypeService.TDelete(profileType);
        return ResponseEntity.noContent().build();
    }
}
