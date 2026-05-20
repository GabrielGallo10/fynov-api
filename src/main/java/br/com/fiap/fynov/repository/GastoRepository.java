package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findAllByIdUsuario(Long idUsuario);
    Optional<Gasto> findByIdAndIdUsuario(Long id, Long idUsuario);
    boolean existsByIdAndIdUsuario(Long id, Long idUsuario);
}
