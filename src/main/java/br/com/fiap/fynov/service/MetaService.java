package br.com.fiap.fynov.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.com.fiap.fynov.model.Meta;
import br.com.fiap.fynov.repository.MetaRepository;
import java.util.Optional;

@Service
public class MetaService {
    @Autowired
    private MetaRepository metaRepository;

    public List<Meta> findAll() {
        List<Meta> metas = metaRepository.findAll();
        if (metas.isEmpty()) {
            throw new RuntimeException("Não há metas cadastradas");
        }
        return metas;
    }

    public Meta findById(Long id) {
        Optional<Meta> meta = metaRepository.findById(id);
        if (meta.isPresent()) {
            return meta.get();
        }
        throw new RuntimeException("Meta não encontrada");
    }

    public Meta create(Meta meta) {
        return metaRepository.save(meta);
    }

    public Meta update(Long id, Meta meta) {
        Optional<Meta> metaAtual = metaRepository.findById(id);
        if (metaAtual.isPresent()) {
            return metaRepository.save(meta);
        }
        throw new RuntimeException("Meta não encontrada para atualização");
    }
    
    public void delete(Long id) {
        Optional<Meta> meta = metaRepository.findById(id);
        if (meta.isPresent()) {
            metaRepository.deleteById(id);
        }
        throw new RuntimeException("Meta não encontrada para exclusão");
    }
}
