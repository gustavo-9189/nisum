package com.nisum.demo.service;

import com.nisum.demo.dto.UserMapper;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserResponse create(String token, UserRequest userRequest) {
        String jwt = token.replace("Bearer ", "");
        User userSave = this.userMapper.userRequestToUser(userRequest);
        userSave.setToken(jwt);
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse update(UUID uuid, UserRequest userRequest) {
        Optional<User> userFind = this.userRepository.findById(uuid);
        if (userFind.isEmpty()) {
            return new UserResponse();
        }
        User userSave = this.userMapper.userUpdate(userRequest, userFind.get());
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        return this.userMapper.usersToUserResponses(users);
    }
}
