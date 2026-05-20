package br.com.fiap.fynov.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.fiap.fynov.service.RecebimentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import br.com.fiap.fynov.model.Recebimento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
    public Recebimento create(@RequestBody Recebimento recebimento) {
        return recebimentoService.create(recebimento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recebimento update(@PathVariable Long id, @RequestBody Recebimento recebimento) {
        return recebimentoService.update(id, recebimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recebimentoService.delete(id);
    }
}
