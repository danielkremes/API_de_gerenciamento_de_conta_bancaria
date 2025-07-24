package com.drk.API_de_gerenciamento_de_conta_bancaria.service;

import com.drk.API_de_gerenciamento_de_conta_bancaria.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepository repository;
}
