package com.example.touragencyback.service.impl;

import com.example.touragencyback.db.entity.User;
import com.example.touragencyback.db.repository.UserRepository;
import com.example.touragencyback.dto.request.UserRequestDTO;
import com.example.touragencyback.dto.response.UserResponseDTO;
import com.example.touragencyback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserResponseDTO create(UserRequestDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());

        User saved = userRepository.save(user);
        return mapToDto(saved);
    }
    @Override
    public List<UserResponseDTO> getAll(){
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public UserResponseDTO getById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDto(user);
    }
    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    private UserResponseDTO mapToDto(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName() + " " + user.getLastName(),
                user.getPhoneNumber()
        );
    }
}
