package br.com.enderecos.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {


    @NotEmpty(message = "Logradouro não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Praça Julio Mesquita")
    private String logradouro;

    @NotEmpty(message = "Número não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "97")
    private String numero;

    @ApiModelProperty(value = "", required = true, example = "Apto 704 Torre 2")
    private String complemento;

    @NotEmpty(message = "Bairro não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Santa Efigenia")
    private String bairro;

    @NotEmpty(message = "Cidade não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "São Paulo")
    private String cidade;

    @NotEmpty(message = "Estado não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "São Paulo")
    private String estado;

    @NotEmpty(message = "Cep não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "01209010")
    private String cep;


    @NotEmpty(message = "Cpf não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "35107781896")
    private String cpfCliente;

}
