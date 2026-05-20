package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmUsuario(String emUsuario);
    boolean existsByEmUsuario(String emUsuario);
}
