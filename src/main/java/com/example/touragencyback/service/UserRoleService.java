package com.example.touragencyback.service;

import com.example.touragencyback.dto.request.UserRoleRequestDTO;
import com.example.touragencyback.dto.response.UserRoleResponseDTO;

import java.util.List;

public interface UserRoleService {
    UserRoleResponseDTO assignRole(UserRoleRequestDTO dto);
    List<UserRoleResponseDTO> getAll();
}
