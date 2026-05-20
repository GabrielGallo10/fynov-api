package br.com.fiap.fynov.service;

import br.com.fiap.fynov.config.SecurityUtils;
import br.com.fiap.fynov.exception.ResourceNotFoundException;
import br.com.fiap.fynov.model.Meta;
import br.com.fiap.fynov.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> findAll() {
        return metaRepository.findAllByIdUsuario(SecurityUtils.getCurrentUserId());
    }

    public Meta findById(Long id) {
        return metaRepository.findByIdAndIdUsuario(id, SecurityUtils.getCurrentUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Meta nao encontrada com id: " + id));
    }

    @Transactional
    public Meta create(Meta meta) {
        meta.setIdUsuario(SecurityUtils.getCurrentUserId());
        return metaRepository.save(meta);
    }

    @Transactional
    public Meta update(Long id, Meta meta) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!metaRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Meta nao encontrada com id: " + id);
        }
        meta.setId(id);
        meta.setIdUsuario(userId);
        return metaRepository.save(meta);
    }

    @Transactional
    public void delete(Long id) {
        Long userId = SecurityUtils.getCurrentUserId();
        if (!metaRepository.existsByIdAndIdUsuario(id, userId)) {
            throw new ResourceNotFoundException("Meta nao encontrada com id: " + id);
        }
        metaRepository.deleteById(id);
    }
}
