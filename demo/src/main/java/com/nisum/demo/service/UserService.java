package com.nisum.demo.service;

import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse create(String token, UserRequest userRequest);

    UserResponse update(UUID uuid, UserRequest userRequest);

    List<UserResponse> getAll();
}
