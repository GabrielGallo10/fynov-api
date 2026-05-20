package br.com.fiap.fynov.controller;

import br.com.fiap.fynov.config.JwtUtil;
import br.com.fiap.fynov.dto.AuthResponse;
import br.com.fiap.fynov.dto.LoginRequest;
import br.com.fiap.fynov.dto.RegisterRequest;
import br.com.fiap.fynov.model.Usuario;
import br.com.fiap.fynov.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/cadastro")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        Usuario usuario = usuarioService.register(request);
        String token = jwtUtil.generateToken(usuario.getEmUsuario(), usuario.getId());
        return ResponseEntity.status(201).body(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );
        Usuario usuario = usuarioService.findByEmail(request.email());
        String token = jwtUtil.generateToken(usuario.getEmUsuario(), usuario.getId());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
