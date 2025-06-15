package com.example.touragencyback.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponseDTO{
    private Long id;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
    private Long userId;
    private Long tourPackageId;
}
