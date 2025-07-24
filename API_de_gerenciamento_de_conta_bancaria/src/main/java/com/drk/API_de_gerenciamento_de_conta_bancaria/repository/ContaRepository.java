package com.drk.API_de_gerenciamento_de_conta_bancaria.repository;

import com.drk.API_de_gerenciamento_de_conta_bancaria.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}