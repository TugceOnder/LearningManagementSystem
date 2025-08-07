package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.CourseAssignment;

import java.util.List;
import java.util.UUID;

public interface CourseAssignmentService extends IGenericService<CourseAssignment, UUID> {
    List<CourseAssignment> getByClassroomId(UUID classroomId);
}
