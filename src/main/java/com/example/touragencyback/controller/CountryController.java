package com.example.touragencyback.controller;

import com.example.touragencyback.dto.request.CountryRequestDTO;
import com.example.touragencyback.dto.response.CountryResponseDTO;
import com.example.touragencyback.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.LongFunction;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryResponseDTO> create(@RequestBody CountryRequestDTO dto){
        return ResponseEntity.status(201).body(countryService.createCountry(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CountryResponseDTO> getId(@PathVariable Long id){
        return ResponseEntity.ok(countryService.getId(id));
    }
    @GetMapping
    public ResponseEntity<List<CountryResponseDTO>> getAll(){
        return ResponseEntity.ok(countryService.getAll());
    }
    @PostMapping("/{id}")
    public ResponseEntity<CountryResponseDTO> update(@PathVariable Long id, @RequestBody CountryRequestDTO dto){
        return ResponseEntity.ok(countryService.update(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        countryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
