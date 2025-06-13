package com.example.touragencyback.db.repository;

import com.example.touragencyback.db.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}