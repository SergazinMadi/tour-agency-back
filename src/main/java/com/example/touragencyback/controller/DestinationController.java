package com.example.touragencyback.controller;

import com.example.touragencyback.dto.request.DestinationRequestDTO;
import com.example.touragencyback.dto.response.DestinationResponseDTO;
import com.example.touragencyback.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@RequiredArgsConstructor
public class DestinationController{
    private final DestinationService destinationService;

    @PostMapping
    public ResponseEntity<DestinationResponseDTO> create (@RequestBody DestinationRequestDTO dto){
        return ResponseEntity.status(201).body(destinationService.create(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(destinationService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> getAll(){
        return ResponseEntity.ok(destinationService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> update (@PathVariable Long id, @RequestBody DestinationRequestDTO dto){
        return ResponseEntity.ok(destinationService.update(id,dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        destinationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

