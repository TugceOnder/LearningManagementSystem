package com.example.learningmanagementsystem.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class CreateCourseAssignmentRequest {
    @NotNull
    private UUID courseId;

    @NotNull
    private UUID classroomId;

    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }
    public UUID getClassroomId() { return classroomId; }
    public void setClassroomId(UUID classroomId) { this.classroomId = classroomId; }
}
