package br.com.enderecos.service;

import br.com.enderecos.dto.EnderecoRequest;
import br.com.enderecos.model.EnderecoModel;
import br.com.enderecos.model.UsuarioModel;
import br.com.enderecos.repository.EnderecoRepository;
import br.com.enderecos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void process(EnderecoRequest enderecoRequest) {

        UsuarioModel usuarioModel = usuarioRepository.findByCpf(enderecoRequest.getCpfCliente());

        enderecoRepository.save(EnderecoModel.builder()
                .logradouro(enderecoRequest.getLogradouro())
                .numero(enderecoRequest.getNumero())
                .complemento(enderecoRequest.getComplemento())
                .bairro(enderecoRequest.getBairro())
                .cidade(enderecoRequest.getCidade())
                .estado(enderecoRequest.getEstado())
                .cep(enderecoRequest.getCep())
                .usuario(usuarioModel)
                .build());
    }
}
