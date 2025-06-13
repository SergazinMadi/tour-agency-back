package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}