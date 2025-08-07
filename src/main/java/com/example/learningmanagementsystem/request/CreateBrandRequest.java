package com.example.learningmanagementsystem.request;


import jakarta.validation.constraints.NotBlank;

public class CreateBrandRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String code;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
