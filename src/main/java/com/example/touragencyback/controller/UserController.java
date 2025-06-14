package com.example.touragencyback.controller;

import com.example.touragencyback.dto.request.UserRequestDTO;
import com.example.touragencyback.dto.response.UserResponseDTO;
import com.example.touragencyback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> creteUser(@RequestBody UserRequestDTO dto){
        return ResponseEntity.status(201).body(userService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
         return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @GetMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
