package com.example.touragencyback.service;

import com.example.touragencyback.dto.request.RoleRequestDTO;
import com.example.touragencyback.dto.response.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    RoleResponseDTO create(RoleRequestDTO dto);
    List<RoleResponseDTO> getAll();
    RoleResponseDTO getById(Long id);
    RoleResponseDTO update(Long id, RoleRequestDTO dto);
    void delete(Long id);
}
