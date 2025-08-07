package com.example.learningmanagementsystem.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class CreateTeacherClassroomAssignmentRequest {
    @NotNull
    private UUID teacherId;

    @NotNull
    private UUID classroomId;

    public UUID getTeacherId() { return teacherId; }
    public void setTeacherId(UUID teacherId) { this.teacherId = teacherId; }
    public UUID getClassroomId() { return classroomId; }
    public void setClassroomId(UUID classroomId) { this.classroomId = classroomId; }
}
