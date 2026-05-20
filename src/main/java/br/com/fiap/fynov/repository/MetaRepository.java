package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MetaRepository extends JpaRepository<Meta, Long> {
    List<Meta> findAllByIdUsuario(Long idUsuario);
    List<Meta> findTop3ByIdUsuarioOrderByDtLimiteMetaAsc(Long idUsuario);
    List<Meta> findTop3ByIdUsuarioAndStMetaNotInOrderByDtLimiteMetaAsc(Long idUsuario, Collection<String> statuses);
    Optional<Meta> findByIdAndIdUsuario(Long id, Long idUsuario);
    boolean existsByIdAndIdUsuario(Long id, Long idUsuario);
    void deleteAllByIdUsuario(Long idUsuario);
}
