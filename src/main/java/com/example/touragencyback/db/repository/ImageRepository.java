package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}