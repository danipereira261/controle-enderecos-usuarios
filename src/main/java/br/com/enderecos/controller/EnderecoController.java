package br.com.enderecos.controller;


import br.com.enderecos.dto.EnderecoRequest;
import br.com.enderecos.exception.InvalidParamException;
import br.com.enderecos.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/endereco")
@Slf4j
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> cadastrar(@Valid @RequestBody EnderecoRequest enderecoRequest)
            throws InvalidParamException {


        enderecoService.process(enderecoRequest);
        return new ResponseEntity<>("Dados registrados com sucesso", HttpStatus.OK);
    }
}