package br.com.enderecos.repository;

import br.com.enderecos.model.ListaDeEnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeEnderecoRepository extends JpaRepository<ListaDeEnderecoModel, Long> {
}
