package br.com.enderecos.repository;

import br.com.enderecos.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UsuarioModel findByCpf(String cpf);
}
