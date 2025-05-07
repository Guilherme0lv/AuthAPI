package com.example.aula_security.domain.user;

public record RegisterDTO(String username, String password, UsuarioRole role) {
}