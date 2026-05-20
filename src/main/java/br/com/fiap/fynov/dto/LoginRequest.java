package br.com.fiap.fynov.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "O email nao pode ser vazio")
    @Email(message = "Informe um endereco de email valido")
    String email,

    @NotBlank(message = "A senha nao pode ser vazia")
    String senha
) {}
