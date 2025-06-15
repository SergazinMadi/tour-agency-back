package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.Review;
import com.example.touragencyback.db.repository.ReviewRepository;
import com.example.touragencyback.db.repository.TourPackageRepository;
import com.example.touragencyback.db.repository.UserRepository;
import com.example.touragencyback.dto.request.ReviewRequestDTO;
import com.example.touragencyback.dto.response.ReviewResponseDTO;
import com.example.touragencyback.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final TourPackageRepository tourPackageRepository;

    private ReviewResponseDTO mapToDTO(Review review){
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt());
        dto.setUserId(review.getUser().getId());
        dto.setTourPackageId(review.getTourPackage().getId());
        return dto;
    }

    @Override
    public ReviewResponseDTO create(ReviewRequestDTO dto){
        Review review = new Review();
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setCreatedAt(LocalDateTime.now());

        review.setUser(userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"))
        );

        review.setTourPackage(tourPackageRepository.findById(dto.getTourPackageId())
                .orElseThrow(() -> new RuntimeException("TourPackage not found"))
        );

        return mapToDTO(reviewRepository.save(review));
    }

    @Override
    public ReviewResponseDTO getById(Long id) {
        return mapToDTO(reviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Review not found")));
    }

    @Override
    public List<ReviewResponseDTO> getAll(){
        return reviewRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDTO update(Long id, ReviewRequestDTO dto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());

        return mapToDTO(reviewRepository.save(review));
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewResponseDTO> getByUserId(Long userId) {
        return reviewRepository.findAllByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<ReviewResponseDTO> getByTourPackageId(Long tourPackageId) {
        return reviewRepository.findAllByTourPackageId(tourPackageId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
