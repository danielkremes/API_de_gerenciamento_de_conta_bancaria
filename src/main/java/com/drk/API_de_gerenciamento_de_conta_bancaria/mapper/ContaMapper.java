package com.drk.API_de_gerenciamento_de_conta_bancaria.mapper;

import com.drk.API_de_gerenciamento_de_conta_bancaria.dto.ContaDTO;
import com.drk.API_de_gerenciamento_de_conta_bancaria.entity.Conta;
import org.springframework.stereotype.Component;

@Component // Boa prática para injeção no service
public class ContaMapper {

    public Conta toDTO(ContaDTO contaDTO) {
        Conta conta = new Conta();
        conta.setTitular(contaDTO.getTitular());
        conta.setSaldo(contaDTO.getSaldo());
        return conta;
    }

    public ContaDTO toEntity(Conta conta) {
        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setTitular(conta.getTitular());
        contaDTO.setSaldo(conta.getSaldo());
        return contaDTO;
    }
}
