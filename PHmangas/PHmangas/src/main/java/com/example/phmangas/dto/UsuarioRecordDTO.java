package com.example.phmangas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRecordDTO(@NotBlank String nome, @NotBlank String email, @NotNull byte idade) {
}
