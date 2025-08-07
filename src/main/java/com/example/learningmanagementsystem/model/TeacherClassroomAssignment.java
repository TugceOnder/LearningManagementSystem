package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "teacher_classroom_assignments")
public class TeacherClassroomAssignment {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private User teacher;  // profileType == Teacher olmalı

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    public TeacherClassroomAssignment() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public TeacherClassroomAssignment(UUID id, User teacher, Classroom classroom) {
        this.id = id;
        this.teacher = teacher;
        this.classroom = classroom;
    }
}
