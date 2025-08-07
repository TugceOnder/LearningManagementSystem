package com.example.learningmanagementsystem.model;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Classroom() {}

    public Classroom(UUID id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}

