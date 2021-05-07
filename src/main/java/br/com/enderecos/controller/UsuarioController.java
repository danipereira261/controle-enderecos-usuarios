package br.com.enderecos.controller;

import br.com.enderecos.dto.UsuarioRequest;
import br.com.enderecos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity cadastrar(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        usuarioService.process(usuarioRequest);
        return new ResponseEntity<>("Dados registrados com sucesso", HttpStatus.OK);
    }
}