package com.example.touragencyback.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime paymentDate;
    private String transactionId;
    private String status;
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
