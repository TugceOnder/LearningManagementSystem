package com.example.learningmanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import com.example.learningmanagementsystem.model.Course;
import org.springframework.stereotype.Service;
import com.example.learningmanagementsystem.repository.CourseRepository;
import com.example.learningmanagementsystem.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void TInsert(Course course) {
        if (course.getName() == null || course.getName().isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void TDelete(Course course) {
        courseRepository.delete(course);
    }

    @Override
    @Transactional
    public void TUpdate(Course course) {
        if (!courseRepository.existsById(course.getId())) {
            throw new IllegalArgumentException("Course not found");
        }
        courseRepository.save(course);
    }

    @Override
    public Course TGetByID(int id) {
        throw new UnsupportedOperationException("Use UUID for Course IDs.");
    }

    @Override
    public List<Course> TGetList() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByName(String name) {
        return courseRepository.findAll().stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .toList();
    }
}
