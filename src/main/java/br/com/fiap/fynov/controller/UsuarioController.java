package br.com.fiap.fynov.controller;

import br.com.fiap.fynov.dto.AtualizarUsuarioRequest;
import br.com.fiap.fynov.model.Usuario;
import br.com.fiap.fynov.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.fynov.repository.UsuarioRepository.UsuarioResumo;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResumo getPerfil() {
        return usuarioService.getPerfil();
    }

    @PutMapping("/perfil")
    @ResponseStatus(HttpStatus.OK)
    public Usuario update(@Valid @RequestBody AtualizarUsuarioRequest request) {
        return usuarioService.update(request);
    }
}
