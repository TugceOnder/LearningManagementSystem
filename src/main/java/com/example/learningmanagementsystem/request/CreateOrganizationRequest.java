package com.example.learningmanagementsystem.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class CreateOrganizationRequest {
    @NotBlank
    private String name;

    @NotNull
    private UUID brandId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public UUID getBrandId() { return brandId; }
    public void setBrandId(UUID brandId) { this.brandId = brandId; }
}
