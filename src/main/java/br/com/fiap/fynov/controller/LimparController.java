package br.com.fiap.fynov.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.fynov.service.LimparService;

@RestController
@RequestMapping("/api/limpar")
public class LimparController {

    @Autowired
    private LimparService limparService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void limpar() {
        limparService.limpar();
    }
}
