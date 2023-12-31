package com.nisum.demo.service;

import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private static void registered(User user) {
        throw new IllegalArgumentException(user.getEmail() + " has already been registered");
    }

    private static RuntimeException notExist() {
        throw new IllegalArgumentException("User does not exist");
    }

    @Override
    @Transactional
    public UserResponse create(String token, UserRequest userRequest) {
        this.userRepository
                .findOneByEmailAndIsActive(userRequest.email(), true)
                .ifPresent(UserServiceImpl::registered);

        User userSave = this.userMapper.userRequestToUser(userRequest, token);
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse update(UUID uuid, UserRequest userRequest) {
        Optional<User> userFind = this.userRepository.findById(uuid);
        userFind.orElseThrow(UserServiceImpl::notExist);
        User userSave = this.userMapper.userUpdate(userRequest, userFind.get());
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public List<UserResponse> getAll() {
        List<User> users = this.userRepository.findAllByIsActive(true);
        return this.userMapper.usersToUserResponses(users);
    }

    @Override
    @Transactional
    public UserResponse delete(UUID uuid) {
        Optional<User> userFind = this.userRepository.findById(uuid);
        userFind.orElseThrow(UserServiceImpl::notExist);
        User userSave = userFind.get();
        userSave.setIsActive(false);
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

}
