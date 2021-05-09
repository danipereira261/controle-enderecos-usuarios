package br.com.enderecos.dto;

import br.com.enderecos.model.EnderecoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public static List<Endereco> converterList(List<EnderecoModel> listaDeEnderecos) {

        //verifica se a lista nao é vazia
        if (!listaDeEnderecos.isEmpty()) {
            //caso nao seja,
            //cria a lista q deve ser retornada
            List<Endereco> enderecos = new ArrayList<>();
            //itera na lista do model
            for (EnderecoModel lista : listaDeEnderecos) {
                //adiciona na lista o model convertido no DTO
                enderecos.add(convertDTO(lista));
            }
            return enderecos;
        }
        return null;
    }

    private static Endereco convertDTO(EnderecoModel model) {
        //converter o model no DTO
        return Endereco
                .builder()
                .bairro(model.getBairro())
                .cep(model.getCep())
                .cidade(model.getCidade())
                .complemento(model.getComplemento())
                .logradouro(model.getLogradouro())
                .numero(model.getNumero())
                .estado(model.getEstado())
                .build();
    }
}