package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}