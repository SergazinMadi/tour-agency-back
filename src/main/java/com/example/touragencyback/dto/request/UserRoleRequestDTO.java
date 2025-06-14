package com.example.touragencyback.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleRequestDTO {
    private Long userId;
    private Long roleId;
}
