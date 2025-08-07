package com.example.learningmanagementsystem.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class CreateClassroomRequest {
    @NotBlank
    private String name;

    @NotNull
    private UUID organizationId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public UUID getOrganizationId() { return organizationId; }
    public void setOrganizationId(UUID organizationId) { this.organizationId = organizationId; }
}