package com.drk.API_de_gerenciamento_de_conta_bancaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_banco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "titular", length = 150, unique = true)
    private String titular;

    @Column(name = "saldo")
    private BigDecimal saldo;
}
