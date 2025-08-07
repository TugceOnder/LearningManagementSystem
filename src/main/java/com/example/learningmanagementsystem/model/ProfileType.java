package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profile_types")
public class ProfileType {

    @Id
    private Integer id;  // 0,1,2 sabit id'ler

    @Column(nullable = false)
    private String name;

    public ProfileType() {}

    public ProfileType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

