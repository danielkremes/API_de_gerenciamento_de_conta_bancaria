package com.drk.API_de_gerenciamento_de_conta_bancaria.controller;

import com.drk.API_de_gerenciamento_de_conta_bancaria.entity.Conta;
import com.drk.API_de_gerenciamento_de_conta_bancaria.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
        return service.criarConta(conta);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> buscarContas() {
        return service.listarContas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContasPorID(@PathVariable Long id) {
        return service.listarContaPorID(id);
    }

}
