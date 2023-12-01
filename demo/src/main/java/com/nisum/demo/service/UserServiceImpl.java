package com.nisum.demo.service;

import com.nisum.demo.dto.UserMapper;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
    public UserResponse create(String token, UserRequest userRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        String jwt = token.replace("Bearer ", "");
        User userSave = this.userMapper.userRequestToUser(userRequest);
        userSave.setToken(jwt);
        userSave.setLastLogin(LocalDateTime.now());
        userSave.setPassword(new BCryptPasswordEncoder().encode(userSave.getPassword()));

        Optional<User> userExist = this.userRepository.findOneByEmailAndIsactive(userSave.getEmail(), true);
        if (userExist.isPresent()) {
            throw new RuntimeException("El correo ya ha sido registrado");
        }
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse update(UUID uuid, UserRequest userRequest) {
        Optional<User> userFind = this.userRepository.findById(uuid);
        if (userFind.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
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

    @Override
    @Transactional
    public UserResponse delete(UUID uuid) {
        Optional<User> userFind = this.userRepository.findById(uuid);
        if (userFind.isEmpty()) {
            throw new RuntimeException("El usuario no existe");
        }
        User userSave = userFind.get();
        userSave.setIsactive(false);
        User user = this.userRepository.save(userSave);
        return this.userMapper.userToUserResponse(user);
    }

}
