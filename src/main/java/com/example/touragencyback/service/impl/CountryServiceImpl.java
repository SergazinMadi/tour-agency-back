package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.Country;
import com.example.touragencyback.db.repository.CountryRepository;
import com.example.touragencyback.dto.request.CountryRequestDTO;
import com.example.touragencyback.dto.response.CountryResponseDTO;
import com.example.touragencyback.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public CountryResponseDTO createCountry(CountryRequestDTO dto){
        Country country = new Country();
        country.setName(dto.getName());

        Country saved = countryRepository.save(country);
        return toResponseDTO(saved);
    }
    @Override
    public CountryResponseDTO getId(Long id){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return toResponseDTO(country);
    }
    @Override
    public List<CountryResponseDTO> getAll(){
        return countryRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
    @Override
    public CountryResponseDTO update(Long id,CountryRequestDTO dto){
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(dto.getName());
        Country updated = countryRepository.save(country);
        return toResponseDTO(updated);
    }
    @Override
    public void delete(Long id){
        if(!countryRepository.existsById(id)){
            throw new RuntimeException("Country not found");
        }
        countryRepository.deleteById(id);
    }

    public CountryResponseDTO toResponseDTO(Country country){
        return new CountryResponseDTO(
                country.getId(),
                country.getName()
        );
    }
}
