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
        EnderecoModel endereco = new EnderecoModel();
        endereco.setLogradouro(enderecoRequest.getLogradouro());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        endereco.setBairro(enderecoRequest.getBairro());
        endereco.setCidade(enderecoRequest.getCidade());
        endereco.setEstado(enderecoRequest.getEstado());
        endereco.setCep(enderecoRequest.getCep());
        endereco.setUsuario(usuarioModel);

        enderecoRepository.save(endereco);
    }
}
