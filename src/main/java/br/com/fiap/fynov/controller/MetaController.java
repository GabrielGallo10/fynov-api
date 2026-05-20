package br.com.fiap.fynov.controller;

import br.com.fiap.fynov.model.Meta;
import br.com.fiap.fynov.service.MetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Meta> findAll() {
        return metaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Meta findById(@PathVariable Long id) {
        return metaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meta create(@Valid @RequestBody Meta meta) {
        return metaService.create(meta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Meta update(@PathVariable Long id, @Valid @RequestBody Meta meta) {
        return metaService.update(id, meta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        metaService.delete(id);
    }
}
