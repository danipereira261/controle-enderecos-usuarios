package br.com.enderecos.service;

import br.com.enderecos.dto.UsuarioRequest;
import br.com.enderecos.model.UsuarioModel;
import br.com.enderecos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void process(UsuarioRequest usuarioRequest) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioRequest.getNome());
        usuarioModel.setEmail(usuarioRequest.getEmail().toLowerCase());
        usuarioModel.setCpf(usuarioRequest.getCpf());
        usuarioModel.setDataNascimento(usuarioRequest.getDataNascimento());
        usuarioRepository.save(usuarioModel);
    }
}
