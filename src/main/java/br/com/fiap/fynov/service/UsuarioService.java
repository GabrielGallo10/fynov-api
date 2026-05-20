package br.com.fiap.fynov.service;

import br.com.fiap.fynov.config.SecurityUtils;
import br.com.fiap.fynov.dto.AtualizarUsuarioRequest;
import br.com.fiap.fynov.dto.RegisterRequest;
import br.com.fiap.fynov.exception.ConflictException;
import br.com.fiap.fynov.exception.ResourceNotFoundException;
import br.com.fiap.fynov.model.Usuario;
import br.com.fiap.fynov.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.fiap.fynov.repository.UsuarioRepository.UsuarioResumo;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario register(RegisterRequest request) {
        if (repository.existsByEmUsuario(request.email())) {
            throw new ConflictException("Email ja cadastrado");
        }
        Usuario usuario = new Usuario();
        usuario.setNmUsuario(request.nome());
        usuario.setEmUsuario(request.email());
        usuario.setPwUsuario(passwordEncoder.encode(request.senha()));
        return repository.save(usuario);
    }

    public UsuarioResumo getPerfil() {
        Long userId = SecurityUtils.getCurrentUserId();
        UsuarioResumo resumo = repository.findUsuarioResumoById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));
        return resumo;
    }

    @Transactional
    public Usuario update(AtualizarUsuarioRequest request) {
        Long userId = SecurityUtils.getCurrentUserId();
        Usuario usuario = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));

        if (!usuario.getEmUsuario().equals(request.email()) && repository.existsByEmUsuario(request.email())) {
            throw new ConflictException("Email ja cadastrado");
        }

        usuario.setNmUsuario(request.nome());
        usuario.setEmUsuario(request.email());
        return repository.save(usuario);
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmUsuario(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado: " + email));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return findByEmail(email);
    }
}
