package com.example.aula_security.domain.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotNull @NotEmpty String username,
        @NotNull @NotEmpty String password,
        @NotNull UsuarioRole role
) {}