package com.example.ecom.controller;

import com.example.ecom.dto.requests.LoginRequestDTO;
import com.example.ecom.dto.responses.LoginResponseDTO;
import com.example.ecom.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginData) {
            LoginResponseDTO authenticatedUser = authService.login(loginData.getEmail(), loginData.getPassword());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(authenticatedUser);
    }
}
