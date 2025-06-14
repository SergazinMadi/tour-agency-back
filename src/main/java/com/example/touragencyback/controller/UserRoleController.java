package com.example.touragencyback.controller;

import com.example.touragencyback.dto.request.UserRoleRequestDTO;
import com.example.touragencyback.dto.response.UserRoleResponseDTO;
import com.example.touragencyback.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRole")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;
    @PostMapping
    public ResponseEntity<UserRoleResponseDTO> assignRole(@RequestBody UserRoleRequestDTO dto){
        return ResponseEntity.ok(userRoleService.assignRole(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserRoleResponseDTO>> getAll(){
        return ResponseEntity.ok(userRoleService.getAll());
    }
}
