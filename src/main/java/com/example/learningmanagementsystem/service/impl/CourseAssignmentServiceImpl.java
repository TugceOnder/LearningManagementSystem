package com.example.learningmanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import com.example.learningmanagementsystem.model.CourseAssignment;
import org.springframework.stereotype.Service;
import com.example.learningmanagementsystem.repository.CourseAssignmentRepository;
import com.example.learningmanagementsystem.service.CourseAssignmentService;

import java.util.List;
import java.util.UUID;

@Service
public class CourseAssignmentServiceImpl implements CourseAssignmentService {

    private final CourseAssignmentRepository courseAssignmentRepository;

    public CourseAssignmentServiceImpl(CourseAssignmentRepository courseAssignmentRepository) {
        this.courseAssignmentRepository = courseAssignmentRepository;
    }

    @Override
    @Transactional
    public void TInsert(CourseAssignment ca) {
        courseAssignmentRepository.save(ca);
    }

    @Override
    @Transactional
    public void TDelete(CourseAssignment ca) {
        courseAssignmentRepository.delete(ca);
    }

    @Override
    @Transactional
    public void TUpdate(CourseAssignment ca) {
        courseAssignmentRepository.save(ca);
    }

    @Override
    public CourseAssignment TGetByID(int id) {
        throw new UnsupportedOperationException("Use UUID for CourseAssignment IDs.");
    }

    @Override
    public List<CourseAssignment> TGetList() {
        return courseAssignmentRepository.findAll();
    }

    public List<CourseAssignment> getByClassroomId(UUID classroomId) {
        return courseAssignmentRepository.findAll().stream()
                .filter(ca -> ca.getClassroom().getId().equals(classroomId))
                .toList();
    }
}

