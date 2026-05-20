package br.com.fiap.fynov.repository;

import br.com.fiap.fynov.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
