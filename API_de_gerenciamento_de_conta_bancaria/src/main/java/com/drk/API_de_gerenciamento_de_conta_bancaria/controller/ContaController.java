package com.drk.API_de_gerenciamento_de_conta_bancaria.controller;

import com.drk.API_de_gerenciamento_de_conta_bancaria.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

}
