package com.nisum.demo.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String password,
        List<PhoneResponse> phones,
        String createdBy,
        LocalDateTime created,
        String modifiedBy,
        LocalDateTime modified,
        LocalDateTime lastLogin,
        String token,
        Boolean isActive) {
}
