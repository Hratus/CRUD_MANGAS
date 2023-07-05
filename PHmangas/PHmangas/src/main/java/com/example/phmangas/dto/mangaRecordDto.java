package com.example.phmangas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record mangaRecordDto( @NotBlank String name, @NotBlank String autor, @NotBlank String genero, @NotNull  int qtd_cap, @NotNull int ano_lancamento) {
}
