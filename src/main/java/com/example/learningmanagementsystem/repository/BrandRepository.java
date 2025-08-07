package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    List<Brand> findByNameContainingIgnoreCase(String name);
    Optional<Brand> findByCode(String code);

}

