package br.com.enderecos.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "tb_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;

    @OneToMany
    private List<EnderecoModel> endereco;


}
