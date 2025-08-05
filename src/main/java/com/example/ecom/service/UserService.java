package com.example.ecom.service;

import com.example.ecom.model.User;
import com.example.ecom.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(String name, String email, String password) {
        User newUser = User
                .builder()
                .name(name)
                .email(email).password(this.passwordEncoder.encode(password))
                .createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now())
                .build();

        return this.userRepository.save(newUser);
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userId = authentication.getName();

        return userRepository.getUserById(userId);
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email nao encontrado" + email));
    }
}
