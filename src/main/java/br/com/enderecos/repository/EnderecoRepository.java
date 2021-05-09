package br.com.enderecos.repository;

import br.com.enderecos.model.EnderecoModel;
import br.com.enderecos.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    List<EnderecoModel> findAllByUsuario(UsuarioModel usuarioModel);
}