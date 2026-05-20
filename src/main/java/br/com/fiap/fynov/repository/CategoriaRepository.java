package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByTpCategoriaIn(List<String> tipos);
}
