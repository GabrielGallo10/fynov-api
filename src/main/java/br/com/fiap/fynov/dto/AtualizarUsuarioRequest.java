package br.com.fiap.fynov.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AtualizarUsuarioRequest(
    @NotBlank(message = "O nome nao pode ser vazio")
    String nome,

    @NotBlank(message = "O email nao pode ser vazio")
    @Email(message = "Informe um endereco de email valido")
    String email
) {}
