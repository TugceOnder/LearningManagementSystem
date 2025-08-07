package com.example.learningmanagementsystem.service.impl;



import com.example.learningmanagementsystem.model.Brand;
import com.example.learningmanagementsystem.repository.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.learningmanagementsystem.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    @Transactional
    public void TInsert(Brand brand) {
        if (brand.getName() == null || brand.getName().isEmpty()) {
            throw new IllegalArgumentException("Brand name cannot be empty");
        }
        brand.setCode(generateBrandCode()); // Otomatik kod üretimi
        brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void TDelete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    @Transactional
    public void TUpdate(Brand brand) {
        if (!brandRepository.existsById(brand.getId())) {
            throw new IllegalArgumentException("Brand not found");
        }
        brandRepository.save(brand);
    }

    @Override
    public Brand TGetByID(int id) {
        String code = "krm" + id; // Convert int id to code (e.g., 1 -> krm1)
        return brandRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found with code: " + code));
    }





    @Override
    public List<Brand> TGetList() {
        return brandRepository.findAll();
    }

    @Override
    public List<Brand> getBrandsByName(String name) {
        return brandRepository.findByNameContainingIgnoreCase(name);
    }

    private String generateBrandCode() {
        long count = brandRepository.count();
        return "krm" + (count + 1); // krm1, krm2 gibi
    }
}