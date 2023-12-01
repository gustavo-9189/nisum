package com.nisum.demo.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class UserResponse {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private List<PhoneResponse> phones;

    private LocalDateTime created;

    private LocalDateTime modified;

    private LocalDateTime lastLogin;

    private String token;

    private Boolean isactive;
}
