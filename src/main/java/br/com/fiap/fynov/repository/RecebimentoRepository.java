package br.com.fiap.fynov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fynov.model.Recebimento;

public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {}
