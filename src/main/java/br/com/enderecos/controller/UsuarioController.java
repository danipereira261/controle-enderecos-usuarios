package br.com.enderecos.controller;

import br.com.enderecos.dto.UsuarioRequest;
import br.com.enderecos.dto.UsuarioResponse;
import br.com.enderecos.exception.InvalidParamException;
import br.com.enderecos.exception.UsuarioNaoEncontradoException;
import br.com.enderecos.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> cadastrar(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        usuarioService.process(usuarioRequest);
        return new ResponseEntity<>("Dados registrados com sucesso", HttpStatus.CREATED);
    }

    @GetMapping(value = "/listar-enderecos/{cpf}")
    public ResponseEntity<UsuarioResponse> listarEnderecos(@PathVariable String cpf) throws UsuarioNaoEncontradoException {
       log.info("[USUARIO CONTROLLER - buscarUsuarioPorCpf: {}]",cpf);

       return new ResponseEntity<>(usuarioService.buscaUsuario(cpf), HttpStatus.OK);
    }
}