package com.example.touragencyback.service;

import com.example.touragencyback.dto.request.CountryRequestDTO;
import com.example.touragencyback.dto.response.CountryResponseDTO;

import java.util.List;

public interface CountryService {
    CountryResponseDTO createCountry(CountryRequestDTO dto);
    CountryResponseDTO getId(Long id);
    List<CountryResponseDTO> getAll();
    CountryResponseDTO update(Long id,CountryRequestDTO dto);
    void delete(Long id);

}
