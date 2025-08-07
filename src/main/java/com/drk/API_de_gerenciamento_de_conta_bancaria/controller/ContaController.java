package com.drk.API_de_gerenciamento_de_conta_bancaria.controller;

import com.drk.API_de_gerenciamento_de_conta_bancaria.dto.ContaDTO;
import com.drk.API_de_gerenciamento_de_conta_bancaria.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @PostMapping
    public ResponseEntity<?> criarConta(@RequestBody ContaDTO conta) {
        try {
            service.criarConta(conta);
            return ResponseEntity.status(HttpStatus.CREATED).body(conta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try again" + e);
        }
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> buscarContas() {
        return ResponseEntity.ok(service.listarContas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscarContasPorID(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarContaPorID(id));
    }

    @PostMapping("/{id}/depositar")
    public ResponseEntity<ContaDTO> depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(service.depositar(id, valor));
    }

    @PostMapping("/{id}/sacar")
    public ResponseEntity<ContaDTO> sacar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(service.sacar(id, valor));
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarSaldo(id));
    }
}
