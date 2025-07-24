package com.drk.API_de_gerenciamento_de_conta_bancaria.service;

import com.drk.API_de_gerenciamento_de_conta_bancaria.entity.Conta;
import com.drk.API_de_gerenciamento_de_conta_bancaria.repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository repository;

    public ResponseEntity<Conta> criarConta(Conta conta) {
        return ResponseEntity.ok(repository.save(conta));
    }

    public ResponseEntity<List<Conta>> listarContas() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Conta> listarContaPorID(Long id) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
        return ResponseEntity.ok(conta);
    }

    public ResponseEntity<Conta> depositar(Long id, BigDecimal valor) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
        conta.setSaldo(conta.getSaldo().add(valor));
        return ResponseEntity.ok(repository.save(conta));
    }

    public ResponseEntity<Conta> sacar(Long id, BigDecimal saque) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta bancaria não encontrada"));
        if (conta.getSaldo().compareTo(saque) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        conta.setSaldo(conta.getSaldo().subtract(saque));

        return ResponseEntity.ok(repository.save(conta));
    }

}
