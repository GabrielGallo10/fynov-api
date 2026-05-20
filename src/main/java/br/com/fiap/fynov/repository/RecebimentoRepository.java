package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
    List<Recebimento> findAllByIdUsuario(Long idUsuario);
    Optional<Recebimento> findByIdAndIdUsuario(Long id, Long idUsuario);
    boolean existsByIdAndIdUsuario(Long id, Long idUsuario);
    void deleteAllByIdUsuario(Long idUsuario);
}
