package com.example.ecom.service;

import com.example.ecom.dto.responses.LoginResponseDTO;
import com.example.ecom.dto.responses.UserResponseDTO;
import com.example.ecom.model.User;
import com.example.ecom.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(String email, String password) {
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() ->  new UsernameNotFoundException("Usuario nao encontrado"));

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Credenciais invalidas");
        }

        String token = jwtService.generateToken(user.getId());

        UserResponseDTO userResponse = new UserResponseDTO(user);

        return new LoginResponseDTO(userResponse, token);
    }
}
