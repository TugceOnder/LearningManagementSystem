package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Classroom;

import java.util.List;
import java.util.UUID;

public interface ClassroomService extends IGenericService<Classroom, UUID> {
    List<Classroom> getByOrganizationId(UUID orgId);
}
