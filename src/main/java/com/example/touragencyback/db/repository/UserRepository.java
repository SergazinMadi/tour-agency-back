package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}