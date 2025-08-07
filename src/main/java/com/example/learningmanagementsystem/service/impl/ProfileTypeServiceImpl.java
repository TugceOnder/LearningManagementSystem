package com.example.learningmanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import com.example.learningmanagementsystem.model.ProfileType;
import org.springframework.stereotype.Service;
import com.example.learningmanagementsystem.repository.ProfileTypeRepository;
import com.example.learningmanagementsystem.service.ProfileTypeService;

import java.util.List;

@Service
public class ProfileTypeServiceImpl implements ProfileTypeService {

    private final ProfileTypeRepository profileTypeRepository;

    public ProfileTypeServiceImpl(ProfileTypeRepository profileTypeRepository) {
        this.profileTypeRepository = profileTypeRepository;
    }

    @Override
    @Transactional
    public void TInsert(ProfileType pt) {
        if (pt.getName() == null || pt.getName().isBlank()) {
            throw new IllegalArgumentException("ProfileType name cannot be empty");
        }
        profileTypeRepository.save(pt);
    }

    @Override
    @Transactional
    public void TDelete(ProfileType pt) {
        profileTypeRepository.delete(pt);
    }

    @Override
    @Transactional
    public void TUpdate(ProfileType pt) {
        profileTypeRepository.save(pt);
    }

    @Override
    public ProfileType TGetByID(int id) {
        return profileTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProfileType not found: " + id));
    }

    @Override
    public List<ProfileType> TGetList() {
        return profileTypeRepository.findAll();
    }

    public ProfileType getByName(String name) {
        return profileTypeRepository.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ProfileType not found"));
    }
}

