package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Review;
import com.example.touragencyback.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByTourPackageId(Long tourPackageId);
    List<Review> findAllByUserId(Long userId);
}