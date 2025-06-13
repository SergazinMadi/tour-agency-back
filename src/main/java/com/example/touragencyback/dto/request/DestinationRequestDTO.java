package com.example.touragencyback.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRequestDTO{
    private String name;
    private String description;
    private Long countryId;
}

