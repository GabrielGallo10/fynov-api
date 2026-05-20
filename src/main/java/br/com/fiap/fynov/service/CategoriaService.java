package br.com.fiap.fynov.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.fynov.repository.CategoriaRepository;
import br.com.fiap.fynov.model.Categoria;
import java.util.List;
import br.com.fiap.fynov.exception.ResourceNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria nao encontrada com id: " + id));
    }
}
