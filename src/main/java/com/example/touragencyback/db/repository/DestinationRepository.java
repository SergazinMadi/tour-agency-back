package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}