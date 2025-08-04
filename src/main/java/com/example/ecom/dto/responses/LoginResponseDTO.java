package com.example.ecom.dto.responses;

public class LoginResponseDTO {

    private UserResponseDTO userResponseDTO;
    private String token;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(UserResponseDTO userResponseDTO, String token) {
        this.userResponseDTO = userResponseDTO;
        this.token = token;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public void setUserResponseDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
