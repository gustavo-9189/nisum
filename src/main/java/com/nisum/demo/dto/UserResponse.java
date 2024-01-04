package com.nisum.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.nisum.demo.helpers.Constants.FORMAT_DATE_TIME;

public record UserResponse(
        UUID id,
        String name,
        String email,
        String password,
        List<PhoneResponse> phones,
        String createdBy,
        @JsonFormat(pattern = FORMAT_DATE_TIME)
        LocalDateTime created,
        String modifiedBy,
        @JsonFormat(pattern = FORMAT_DATE_TIME)
        LocalDateTime modified,
        @JsonFormat(pattern = FORMAT_DATE_TIME)
        LocalDateTime lastLogin,
        String token,
        Boolean isActive) {
}
