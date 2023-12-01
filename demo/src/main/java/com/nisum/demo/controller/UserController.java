package com.nisum.demo.controller;

import com.nisum.demo.api.UserApi;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.service.UserService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestHeader("Authorization") String authorization,
            @RequestBody UserRequest userRequest) {
        UserResponse userResponse;
        try {
            userResponse = this.userService.create(authorization, userRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(userResponse);
    }

    @Override
    @PatchMapping("/{uuid}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID uuid, @RequestBody UserRequest userRequest) {
        UserResponse userResponse;
        try {
            userResponse = this.userService.update(uuid, userRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(userResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> users;
        try {
            users = this.userService.getAll();
        } catch (Exception e) {
            return ResponseEntity.noContent()
                    .build();
        }
        return ResponseEntity.ok(users);
    }

}
