package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    List<Organization> findByBrandId(UUID brandId); // Brand altındaki org'ları getir
}

