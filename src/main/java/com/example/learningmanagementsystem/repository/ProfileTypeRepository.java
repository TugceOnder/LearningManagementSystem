package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileTypeRepository extends JpaRepository<ProfileType, Integer> {}

