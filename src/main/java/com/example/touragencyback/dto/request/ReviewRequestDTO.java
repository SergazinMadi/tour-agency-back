package com.example.touragencyback.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {
    private Integer rating;
    private String comment;
    private Long userId;
    private Long tourPackageId;
}
