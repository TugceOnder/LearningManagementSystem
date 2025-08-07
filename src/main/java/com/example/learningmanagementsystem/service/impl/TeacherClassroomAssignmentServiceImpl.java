package com.example.learningmanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import com.example.learningmanagementsystem.model.TeacherClassroomAssignment;
import org.springframework.stereotype.Service;
import com.example.learningmanagementsystem.repository.TeacherClassroomAssignmentRepository;
import com.example.learningmanagementsystem.service.TeacherClassroomAssignmentService;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherClassroomAssignmentServiceImpl implements TeacherClassroomAssignmentService {

    private final TeacherClassroomAssignmentRepository assignmentRepository;

    public TeacherClassroomAssignmentServiceImpl(TeacherClassroomAssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    @Transactional
    public void TInsert(TeacherClassroomAssignment tca) {
        assignmentRepository.save(tca);
    }

    @Override
    @Transactional
    public void TDelete(TeacherClassroomAssignment tca) {
        assignmentRepository.delete(tca);
    }

    @Override
    @Transactional
    public void TUpdate(TeacherClassroomAssignment tca) {
        assignmentRepository.save(tca);
    }

    @Override
    public TeacherClassroomAssignment TGetByID(int id) {
        throw new UnsupportedOperationException("Use UUID for IDs.");
    }

    @Override
    public List<TeacherClassroomAssignment> TGetList() {
        return assignmentRepository.findAll();
    }

    public List<TeacherClassroomAssignment> getByTeacherId(UUID teacherId) {
        return assignmentRepository.findByTeacherId(teacherId);
    }
}
