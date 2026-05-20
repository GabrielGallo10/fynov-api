package br.com.fiap.fynov.controller;

import br.com.fiap.fynov.model.Recebimento;
import br.com.fiap.fynov.service.RecebimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recebimentos")
public class RecebimentoController {

    @Autowired
    private RecebimentoService recebimentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Recebimento> findAll() {
        return recebimentoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recebimento findById(@PathVariable Long id) {
        return recebimentoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recebimento create(@Valid @RequestBody Recebimento recebimento) {
        return recebimentoService.create(recebimento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recebimento update(@PathVariable Long id, @Valid @RequestBody Recebimento recebimento) {
        return recebimentoService.update(id, recebimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recebimentoService.delete(id);
    }
}
