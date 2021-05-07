package br.com.enderecos.service;

import br.com.enderecos.dto.UsuarioRequest;
import br.com.enderecos.model.EnderecoModel;
import br.com.enderecos.model.UsuarioModel;
import br.com.enderecos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void process(UsuarioRequest usuarioRequest){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome("Daniele Santana Pereira");
        usuarioModel.setEmail("dpereira261@gmail.com");
        usuarioModel.setCpf("351077818-96");
        usuarioModel.setDataNascimento(LocalDate.now());
        List<EnderecoModel> listaDeEndereco = new ArrayList<>();

        EnderecoModel endereco = new EnderecoModel();
        endereco.setLogradouro("Praça Julio Mesquita");
        endereco.setNumero(97L);
        endereco.setComplemento("Apto 704 Torre 2");
        endereco.setBairro("Santa Efigenia");
        endereco.setCidade("São Paulo");
        endereco.setEstado("São Paulo");
        endereco.setCep("01209010");

        listaDeEndereco.add(endereco);
        usuarioModel.setEndereco(listaDeEndereco);
        usuarioRepository.save(usuarioModel);

    }
}
