package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.ProfileType;

public interface ProfileTypeService extends IGenericService<ProfileType, Integer> {
    ProfileType getByName(String name);
}
