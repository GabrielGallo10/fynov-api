package br.com.fiap.fynov.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.service.GastoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {
    @Autowired
    private GastoService gastoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Gasto> findAll() {
        return gastoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gasto findById(@PathVariable Long id) {
        return gastoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasto create(@RequestBody Gasto gasto) {
        return gastoService.create(gasto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gasto update(@PathVariable Long id, @RequestBody Gasto gasto) {
        return gastoService.update(id, gasto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        gastoService.delete(id);
    }
}
