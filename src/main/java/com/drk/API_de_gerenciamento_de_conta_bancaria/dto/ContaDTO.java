package com.drk.API_de_gerenciamento_de_conta_bancaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaDTO {
    private String titular;
    private BigDecimal saldo;
}
