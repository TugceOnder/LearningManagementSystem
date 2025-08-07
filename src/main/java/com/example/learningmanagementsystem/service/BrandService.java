package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService extends IGenericService<Brand, UUID> {
    List<Brand> getBrandsByName(String name);
}
