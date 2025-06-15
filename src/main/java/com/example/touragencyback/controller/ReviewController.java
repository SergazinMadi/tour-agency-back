package com.example.touragencyback.controller;

import com.example.touragencyback.dto.request.ReviewRequestDTO;
import com.example.touragencyback.dto.response.ReviewResponseDTO;
import com.example.touragencyback.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> create(@RequestBody ReviewRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getAll() {
        return ResponseEntity.ok(reviewService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> update(@PathVariable Long id,@RequestBody ReviewRequestDTO dto) {
        return ResponseEntity.ok(reviewService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-tour/{tourPackageId}")
    public ResponseEntity<List<ReviewResponseDTO>> getByTourPackageId(@PathVariable Long tourPackageId) {
        return ResponseEntity.ok(reviewService.getByTourPackageId(tourPackageId));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<ReviewResponseDTO>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getByUserId(userId));
    }
}
