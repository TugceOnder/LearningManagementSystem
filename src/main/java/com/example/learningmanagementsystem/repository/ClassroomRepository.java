package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {
    List<Classroom> findByOrganizationId(UUID orgId);
}

