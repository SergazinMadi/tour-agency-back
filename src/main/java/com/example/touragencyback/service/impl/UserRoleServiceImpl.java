package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.Role;
import com.example.touragencyback.db.entity.User;
import com.example.touragencyback.db.entity.UserRole;
import com.example.touragencyback.db.repository.RoleRepository;
import com.example.touragencyback.db.repository.UserRepository;
import com.example.touragencyback.db.repository.UserRoleRepository;
import com.example.touragencyback.dto.request.UserRoleRequestDTO;
import com.example.touragencyback.dto.response.UserRoleResponseDTO;
import com.example.touragencyback.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl  implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserRoleResponseDTO assignRole(UserRoleRequestDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(()-> new RuntimeException("user not found"));
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(()-> new RuntimeException("role not found"));
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        return testDto(userRole);
    }

    @Override
    public List<UserRoleResponseDTO> getAll(){
        return userRoleRepository.findAll().stream()
                .map(this::testDto)
                .collect(Collectors.toList());
    }
    private UserRoleResponseDTO testDto(UserRole userRole){
        UserRoleResponseDTO dto = new UserRoleResponseDTO();
        dto.setId(userRole.getId());
        dto.setUserId(userRole.getUser().getId());
        dto.setRoleId(userRole.getRole().getId());
        return dto;
    }

}
