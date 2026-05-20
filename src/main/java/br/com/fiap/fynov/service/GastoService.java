package br.com.fiap.fynov.service;

import br.com.fiap.fynov.config.SecurityUtils;
import br.com.fiap.fynov.exception.ResourceNotFoundException;
import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> findAll() {
        return gastoRepository.findAllByIdUsuario(SecurityUtils.getCurrentUserId());
    }

    public Gasto findById(Long id) {
        return gastoRepository.findByIdAndIdUsuario(id, SecurityUtils.getCurrentUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Gasto nao encontrado com id: " + id));
    }

    @Transactional
    public Gasto create(Gasto gasto) {
        gasto.setIdUsuario(SecurityUtils.getCurrentUserId());
        return gastoRepository.save(gasto);
    }

    @Transactional
    public Gasto update(Long id, Gasto gasto) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!gastoRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Gasto nao encontrado com id: " + id);
        }
        gasto.setId(id);
        gasto.setIdUsuario(userId);
        return gastoRepository.save(gasto);
    }

    @Transactional
    public void delete(Long id) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!gastoRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Gasto nao encontrado com id: " + id);
        }
        gastoRepository.deleteById(id);
    }
}
