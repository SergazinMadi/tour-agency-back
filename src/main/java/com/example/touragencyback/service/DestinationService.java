package com.example.touragencyback.service;
import com.example.touragencyback.dto.request.DestinationRequestDTO;
import com.example.touragencyback.dto.response.DestinationResponseDTO;

import java.util.List;

public interface DestinationService {
    DestinationResponseDTO create(DestinationRequestDTO dto);
    DestinationResponseDTO getById(Long id);
    List<DestinationResponseDTO> getAll();
    DestinationResponseDTO update(Long id, DestinationRequestDTO dto);
    void delete(Long id);
}
