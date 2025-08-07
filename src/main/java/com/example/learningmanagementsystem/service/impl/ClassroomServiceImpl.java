package com.example.learningmanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import com.example.learningmanagementsystem.model.Classroom;
import org.springframework.stereotype.Service;
import com.example.learningmanagementsystem.repository.ClassroomRepository;
import com.example.learningmanagementsystem.service.ClassroomService;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    @Transactional
    public void TInsert(Classroom classroom) {
        if (classroom.getName() == null || classroom.getName().isBlank()) {
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        classroomRepository.save(classroom);
    }

    @Override
    @Transactional
    public void TDelete(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    @Override
    @Transactional
    public void TUpdate(Classroom classroom) {
        if (!classroomRepository.existsById(classroom.getId())) {
            throw new IllegalArgumentException("Classroom not found");
        }
        classroomRepository.save(classroom);
    }

    @Override
    public Classroom TGetByID(int id) {
        throw new UnsupportedOperationException("Use UUID for Classroom IDs.");
    }

    @Override
    public List<Classroom> TGetList() {
        return classroomRepository.findAll();
    }

    public List<Classroom> getByOrganizationId(UUID orgId) {
        return classroomRepository.findByOrganizationId(orgId);
    }
}
