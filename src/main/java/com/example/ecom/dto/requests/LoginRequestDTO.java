package com.example.ecom.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LoginRequestDTO {
    @NotBlank(message = "Email nao pode ser vazio")
    @Email(message = "Precisa ser um email formatado '@example.org'")
    private String email;

    @NotBlank(message = "Senha nao pode ser vazia")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$", message = "Senha precisa conter 1 letra MAISCULA, 1 letra MINUSCULA, 1 Caracter especial '@!#&*?%', 1 NUMERO, MINIMO de 8 CARACTERES")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

