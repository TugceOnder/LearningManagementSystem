package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Organization;

import java.util.List;
import java.util.UUID;

public interface OrganizationService extends IGenericService<Organization, UUID> {
    List<Organization> getByBrandId(UUID brandId);
}