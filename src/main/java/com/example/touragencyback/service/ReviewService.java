package com.example.touragencyback.service;

import com.example.touragencyback.dto.request.ReviewRequestDTO;
import com.example.touragencyback.dto.response.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {
    ReviewResponseDTO create(ReviewRequestDTO dto);
    ReviewResponseDTO getById(Long id);
    List<ReviewResponseDTO> getAll();
    ReviewResponseDTO update(Long id, ReviewRequestDTO dto);
    void delete(Long id);

    List<ReviewResponseDTO> getByTourPackageId(Long tourPackageId);
    List<ReviewResponseDTO> getByUserId(Long userId);
}
