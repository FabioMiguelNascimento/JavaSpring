package com.example.ecom.dto.responses;

import com.example.ecom.model.User;

public class UserResponseDTO {

    private String name;
    private String email;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
