package br.com.fiap.fynov.service;

import br.com.fiap.fynov.config.SecurityUtils;
import br.com.fiap.fynov.exception.ResourceNotFoundException;
import br.com.fiap.fynov.model.Recebimento;
import br.com.fiap.fynov.repository.RecebimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecebimentoService {

    @Autowired
    private RecebimentoRepository recebimentoRepository;

    public List<Recebimento> findAll() {
        return recebimentoRepository.findAllByIdUsuario(SecurityUtils.getCurrentUserId());
    }

    public Recebimento findById(Long id) {
        return recebimentoRepository.findByIdAndIdUsuario(id, SecurityUtils.getCurrentUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Recebimento nao encontrado com id: " + id));
    }

    @Transactional
    public Recebimento create(Recebimento recebimento) {
        recebimento.setIdUsuario(SecurityUtils.getCurrentUserId());
        return recebimentoRepository.save(recebimento);
    }

    @Transactional
    public Recebimento update(Long id, Recebimento recebimento) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!recebimentoRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Recebimento nao encontrado com id: " + id);
        }
        recebimento.setId(id);
        recebimento.setIdUsuario(userId);
        return recebimentoRepository.save(recebimento);
    }

    @Transactional
    public void delete(Long id) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!recebimentoRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Recebimento nao encontrado com id: " + id);
        }
        recebimentoRepository.deleteById(id);
    }
}
