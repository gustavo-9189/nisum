package com.nisum.demo.api;

import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@Tag(name = "User", description = "the User Api")
public interface UserApi {

    @Operation(
            summary = "register a new user",
            description = "create a new user in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")})
    ResponseEntity<UserResponse> create(String authorization, UserRequest userRequest, BindingResult bindingResult);

    @Operation(
            summary = "update a user",
            description = "update a user in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")})
    ResponseEntity<UserResponse> update(UUID uuid, UserRequest userRequest);


    @Operation(
            summary = "get all users",
            description = "get all users of the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")})
    ResponseEntity<List<UserResponse>> getUsers();

    @Operation(
            summary = "logical delete a user",
            description = "logical delete a user in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation")})
    ResponseEntity<UserResponse> delete(UUID uuid);
}
