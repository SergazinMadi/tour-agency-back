package com.example.touragencyback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long countryId;
    private String countryName;
}
