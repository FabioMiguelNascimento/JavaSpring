package com.example.ecom.controller;

import com.example.ecom.dto.requests.UserCreateDTO;
import com.example.ecom.dto.responses.UserResponseDTO;
import com.example.ecom.model.User;
import com.example.ecom.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> Create(@RequestBody UserCreateDTO userData) {
        User userCreated = userService.create(userData.getName(), userData.getEmail(), userData.getPassword());

        UserResponseDTO userResponseDTO = new UserResponseDTO(userCreated);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
}
