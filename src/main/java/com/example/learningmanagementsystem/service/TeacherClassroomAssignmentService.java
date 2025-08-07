package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.TeacherClassroomAssignment;

import java.util.List;
import java.util.UUID;

public interface TeacherClassroomAssignmentService extends IGenericService<TeacherClassroomAssignment, UUID> {
    List<TeacherClassroomAssignment> getByTeacherId(UUID teacherId);
}

