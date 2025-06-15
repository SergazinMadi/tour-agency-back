package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.Role;
import com.example.touragencyback.db.repository.RoleRepository;
import com.example.touragencyback.dto.request.RoleRequestDTO;
import com.example.touragencyback.dto.response.RoleResponseDTO;
import com.example.touragencyback.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    private RoleResponseDTO mapToDTO(Role role){
        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    @Override
    public RoleResponseDTO create(RoleRequestDTO dto){ //1 check exist or not
        if(roleRepository.existsByName(dto.getName())){
            throw new RuntimeException("Role name already exists");
        }
        Role role = new Role();
        role.setName(dto.getName());
        return mapToDTO(roleRepository.save(role));
    }

    @Override
    public List<RoleResponseDTO> getAll(){
        return roleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getById(Long id){
        return mapToDTO(roleRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Role not found")));
    }

    @Override
    public RoleResponseDTO update(Long id, RoleRequestDTO dto){
        Role role = roleRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Role not found"));
        role.setName(dto.getName());
        return mapToDTO(roleRepository.save(role));
    }

    @Override
    public void delete(Long id){
        if(!roleRepository.existsById(id)){
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }

}
