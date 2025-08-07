package com.example.learningmanagementsystem.service.impl;


import com.example.learningmanagementsystem.model.Organization;
import com.example.learningmanagementsystem.repository.OrganizationRepository;
import com.example.learningmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.learningmanagementsystem.service.OrganizationService;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void TInsert(Organization organization) {
        if (organization.getName() == null || organization.getName().isBlank()) {
            throw new IllegalArgumentException("Organization name cannot be empty");
        }
        organizationRepository.save(organization);
    }

    @Override
    @Transactional
    public void TDelete(Organization organization) {
        UUID id = organization.getId();
        boolean hasUsers = userRepository.findAll().stream()
                .anyMatch(u -> u.getOrganization().getId().equals(id));
        if (hasUsers) {
            throw new IllegalStateException("Cannot delete; users exist in organization");
        }
        organizationRepository.delete(organization);
    }

    @Override
    @Transactional
    public void TUpdate(Organization organization) {
        if (!organizationRepository.existsById(organization.getId())) {
            throw new IllegalArgumentException("Organization not found");
        }
        organizationRepository.save(organization);
    }

    @Override
    public Organization TGetByID(int id) {
        throw new UnsupportedOperationException("Use UUID for Organization IDs.");
    }

    @Override
    public List<Organization> TGetList() {
        return organizationRepository.findAll();
    }

    public List<Organization> getByBrandId(UUID brandId) {
        return organizationRepository.findByBrandId(brandId);
    }
}

