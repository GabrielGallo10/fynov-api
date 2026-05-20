package br.com.fiap.fynov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.fiap.fynov.model.Recebimento;
import br.com.fiap.fynov.repository.RecebimentoRepository;
import java.util.Optional;

@Service
public class RecebimentoService {
    @Autowired
    private RecebimentoRepository recebimentoRepository;

    public List<Recebimento> findAll() {
        List<Recebimento> recebimentos = recebimentoRepository.findAll();

        if (recebimentos.isEmpty()) {
            throw new RuntimeException("Não há recebimentos cadastrados");
        }
        return recebimentos;
    }

    public Recebimento findById(Long id) {
        Optional<Recebimento> recebimento = recebimentoRepository.findById(id);
        if (recebimento.isPresent()) {
            return recebimento.get();
        }
        throw new RuntimeException("Recebimento não encontrado");
    }

    public Recebimento create(Recebimento recebimento) {
        return recebimentoRepository.save(recebimento);
    }

    public Recebimento update(Long id, Recebimento recebimento) {
        Optional<Recebimento> recebimentoAtual = recebimentoRepository.findById(id);
        if (recebimentoAtual.isPresent()) {
            return recebimentoRepository.save(recebimento);
        }
        throw new RuntimeException("Recebimento não encontrado para atualização");
    }

    public void delete(Long id) {
        Optional<Recebimento> recebimento = recebimentoRepository.findById(id);
        if (recebimento.isPresent()) {
            recebimentoRepository.deleteById(id);
        }
        throw new RuntimeException("Recebimento não encontrado para exclusão");
    }
}
