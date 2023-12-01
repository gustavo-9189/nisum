package com.nisum.demo.security;

import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository
                .findOneByEmailAndIsactive(email, true)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario o Password incorrectos"));

        user.setLastLogin(LocalDateTime.now());
        this.userRepository.save(user);

        return new UserDetailsImpl(user);
    }
}
