package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService extends IGenericService<Course, UUID> {
    List<Course> getCoursesByName(String name);
}
