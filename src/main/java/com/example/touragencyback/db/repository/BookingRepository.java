package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}