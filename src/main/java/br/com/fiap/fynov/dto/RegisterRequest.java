package br.com.fiap.fynov.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
    @NotBlank(message = "O nome nao pode ser vazio")
    String nome,

    @NotBlank(message = "O email nao pode ser vazio")
    @Email(message = "Informe um endereco de email valido")
    String email,

    @NotBlank(message = "A senha nao pode ser vazia")
    @Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
    String senha
) {}
