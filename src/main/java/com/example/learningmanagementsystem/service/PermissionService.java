package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionService extends IGenericService<Permission, UUID> {
    List<Permission> getByRoleId(Integer roleId);
}

