package br.com.fiap.fynov.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.fynov.service.MetaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import br.com.fiap.fynov.model.Meta;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
    public Meta create(@RequestBody Meta meta) {
        return metaService.create(meta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Meta update(@PathVariable Long id, @RequestBody Meta meta) {
        return metaService.update(id, meta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        metaService.delete(id);
    }
}
