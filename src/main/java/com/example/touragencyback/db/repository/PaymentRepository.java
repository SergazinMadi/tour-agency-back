package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}