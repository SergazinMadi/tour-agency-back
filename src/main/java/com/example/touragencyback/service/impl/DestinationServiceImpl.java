package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.Country;
import com.example.touragencyback.db.entity.Destination;
import com.example.touragencyback.db.repository.CountryRepository;
import com.example.touragencyback.db.repository.DestinationRepository;
import com.example.touragencyback.dto.request.DestinationRequestDTO;
import com.example.touragencyback.dto.response.DestinationResponseDTO;
import com.example.touragencyback.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    private final CountryRepository countryRepository;

    @Override
    public DestinationResponseDTO create(DestinationRequestDTO dto) {
        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Destination destination = new Destination();
        destination.setCountry(country);
        destination.setName(dto.getName());
        destination.setDescription(dto.getDescription());

        Destination saved = destinationRepository.save(destination);
        return toResponseDTO(saved);
    }

    @Override
    public DestinationResponseDTO update(Long id, DestinationRequestDTO dto){
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found"));
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        destination.setName(dto.getName());
        destination.setDescription(dto.getDescription());
        destination.setCountry(country);

        Destination updated = destinationRepository.save(destination);
        return toResponseDTO(updated);

    }

    @Override
    public DestinationResponseDTO getById(Long id){
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found"));
        return toResponseDTO(destination);
    }
    @Override
    public List<DestinationResponseDTO> getAll(){
        return destinationRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        if(!destinationRepository.existsById(id)){
            throw new RuntimeException("Destination not found");
        }
        destinationRepository.deleteById(id);
    }

    public DestinationResponseDTO toResponseDTO(Destination destination){
        return new DestinationResponseDTO(
                destination.getId(),
                destination.getName(),
                destination.getDescription(),
                destination.getCountry().getId(),
                destination.getCountry().getName()
        );
    }
}
