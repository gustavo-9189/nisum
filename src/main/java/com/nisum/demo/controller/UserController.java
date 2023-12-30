package com.nisum.demo.controller;

import com.nisum.demo.api.UserApi;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.service.UserService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestHeader("Authorization") String authorization,
            @Valid @RequestBody UserRequest userRequest) {

        UserResponse userResponse = this.userService.create(authorization, userRequest);
        URI path = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userResponse.id())
                .toUri();
        return ResponseEntity
                .created(path)
                .body(userResponse);
    }

    @Override
    @PatchMapping("/{uuid}")
    public ResponseEntity<UserResponse> update(
            @PathVariable UUID uuid,
            @Valid @RequestBody UserRequest userRequest) {

        UserResponse userResponse = this.userService.update(uuid, userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public ResponseEntity<UserResponse> delete(@PathVariable UUID uuid) {
        UserResponse userResponse = this.userService.delete(uuid);
        return ResponseEntity.ok(userResponse);
    }

}
