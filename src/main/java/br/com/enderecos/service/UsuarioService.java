package br.com.enderecos.service;

import br.com.enderecos.dto.Endereco;
import br.com.enderecos.dto.UsuarioRequest;
import br.com.enderecos.dto.UsuarioResponse;
import br.com.enderecos.exception.UsuarioNaoEncontradoException;
import br.com.enderecos.model.EnderecoModel;
import br.com.enderecos.model.UsuarioModel;
import br.com.enderecos.repository.EnderecoRepository;
import br.com.enderecos.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void process(UsuarioRequest usuarioRequest) {

        usuarioRepository.save(UsuarioModel.builder()
                .nome(usuarioRequest.getNome())
                .cpf(usuarioRequest.getCpf())
                .dataNascimento(usuarioRequest.getDataNascimento())
                .email(usuarioRequest.getEmail())
                .build());
    }

    public UsuarioResponse buscaUsuario(String cpf) throws UsuarioNaoEncontradoException {
            log.info("[USUARIO SERVICE - buscaUsuario: {}]", cpf);
            UsuarioModel usuario = usuarioRepository.findByCpf(cpf);

            if (usuario == null) {
                throw new UsuarioNaoEncontradoException();
            }

            log.info("[USUARIO SERVICE - usuarios: {}]", usuario);
            List<EnderecoModel> listaDeEnderecos = enderecoRepository.findAllByUsuario(usuario);
            log.info("[USUARIO SERVICE - listaDeEnderecos: {}]", listaDeEnderecos);

            return UsuarioResponse
                    .builder()
                    .cpf(usuario.getCpf())
                    .dataNascimento(usuario.getDataNascimento())
                    .email(usuario.getEmail())
                    .nome(usuario.getNome())
                    .endereco(Endereco.converterList(listaDeEnderecos))
                    .build();
    }
}