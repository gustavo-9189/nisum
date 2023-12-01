package com.nisum.demo.service;

import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.BindingResult;

public interface UserService {

    UserResponse create(String token, UserRequest userRequest, BindingResult bindingResult);

    UserResponse update(UUID uuid, UserRequest userRequest);

    List<UserResponse> getAll();

    UserResponse delete(UUID uuid);
}
