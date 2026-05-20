package br.com.fiap.fynov.controller;

import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.service.GastoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Gasto create(@Valid @RequestBody Gasto gasto) {
        return gastoService.create(gasto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gasto update(@PathVariable Long id, @Valid @RequestBody Gasto gasto) {
        return gastoService.update(id, gasto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        gastoService.delete(id);
    }
}
