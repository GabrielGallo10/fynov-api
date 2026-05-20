package br.com.fiap.fynov.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.repository.GastoRepository;
import java.util.Optional;

@Service
public class GastoService {
    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> findAll() {
        List<Gasto> gastos = gastoRepository.findAll();
        if (gastos.isEmpty()) {
            throw new RuntimeException("Não há gastos cadastrados");
        }
        return gastos;
    }

    public Gasto findById(Long id) {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        if (gasto.isPresent()) {
            return gasto.get();
        }
        throw new RuntimeException("Gasto não encontrado");
    }

    public Gasto create(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public Gasto update(Long id, Gasto gasto) {
        Optional<Gasto> gastoAtual = gastoRepository.findById(id);
        if (gastoAtual.isPresent()) {
            return gastoRepository.save(gasto);
        }
        throw new RuntimeException("Gasto não encontrado para atualização");
    }
    
    public void delete(Long id) {
        Optional<Gasto> gasto = gastoRepository.findById(id);
        if (gasto.isPresent()) {
            gastoRepository.deleteById(id);
        }
        throw new RuntimeException("Gasto não encontrado para exclusão");
    }
}
