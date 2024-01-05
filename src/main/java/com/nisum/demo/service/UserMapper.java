package com.nisum.demo.service;

import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.User;
import java.util.List;

public interface UserMapper {

    User userRequestToUser(UserRequest userRequest, String token);

    UserResponse userToUserResponse(User user);

    User userUpdate(UserRequest userRequest, User user);

    List<UserResponse> usersToUserResponses(List<User> users);
}
