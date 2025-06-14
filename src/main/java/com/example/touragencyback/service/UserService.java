package com.example.touragencyback.service;

import com.example.touragencyback.dto.request.UserRequestDTO;
import com.example.touragencyback.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);
    List<UserResponseDTO> getAll();
    UserResponseDTO getById(Long id);
    void delete(Long id);
}
