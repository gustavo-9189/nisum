package com.nisum.demo.service;

import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import com.nisum.demo.security.UserDetailsImpl;
import java.time.LocalDateTime;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository
                .findOneByEmailAndIsActive(email, true)
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect username or password"));

        user.setLastLogin(LocalDateTime.now());
        this.userRepository.save(user);

        return new UserDetailsImpl(user);
    }
}
