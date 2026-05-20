package br.com.fiap.fynov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fynov.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {}
