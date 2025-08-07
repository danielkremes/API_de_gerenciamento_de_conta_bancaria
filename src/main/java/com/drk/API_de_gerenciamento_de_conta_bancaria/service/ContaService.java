package com.drk.API_de_gerenciamento_de_conta_bancaria.service;

import com.drk.API_de_gerenciamento_de_conta_bancaria.dto.ContaDTO;
import com.drk.API_de_gerenciamento_de_conta_bancaria.entity.Conta;
import com.drk.API_de_gerenciamento_de_conta_bancaria.mapper.ContaMapper;
import com.drk.API_de_gerenciamento_de_conta_bancaria.repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository repository;
    private final ContaMapper contaMapper;

    public ContaDTO criarConta(ContaDTO contaDTO) {
        Conta conta = contaMapper.toDTO(contaDTO);
        repository.save(conta);
        return contaMapper.toEntity(conta);
    }

    public List<ContaDTO> listarContas() {
        repository.findAll();

        return repository.findAll()
                .stream()
                .map(contaMapper::toEntity)
                .toList();
    }

    public ContaDTO listarContaPorID(Long id) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
        return contaMapper.toEntity(conta);
    }

    public ContaDTO depositar(Long id, BigDecimal valor) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta Bancaria não encontrada"));
        conta.setSaldo(conta.getSaldo().add(valor));
        return contaMapper.toEntity(repository.save(conta));
    }

    public ContaDTO sacar(Long id, BigDecimal saque) {
        Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta bancaria não encontrada"));
        if (conta.getSaldo().compareTo(saque) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        conta.setSaldo(conta.getSaldo().subtract(saque));
        return contaMapper.toEntity(repository.save(conta));
    }

    public BigDecimal consultarSaldo(Long id) {
        Conta conta = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Conta não encontrada")
        );

        return conta.getSaldo();
    }

}
