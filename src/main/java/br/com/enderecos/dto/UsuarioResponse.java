package br.com.enderecos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private List<Endereco> endereco;
}
