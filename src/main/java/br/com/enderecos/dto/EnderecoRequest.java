package br.com.enderecos.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    @NotNull(message = "Cpf obrigatório")
    @NotEmpty(message = "Cpf não pode ser vazio")
    @CPF(message = "CPF precisa ser válido")
    @ApiModelProperty(value = "", required = true, example = "35107781896")
    private String cpfCliente;

    @NotNull(message = "Cep é obrigatório")
    @NotEmpty(message = "Cep não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "01209010")
    private String cep;

    @NotNull(message = "Logradouro é obrigatório")
    @NotEmpty(message = "Logradouro não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Praça Julio Mesquita")
    private String logradouro;

    @NotEmpty(message = "Número não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "97")
    private String numero;

    @ApiModelProperty(value = "", required = true, example = "Apto 704 Torre 2")
    private String complemento;

    @NotNull(message = "Bairro é obrigatório")
    @NotEmpty(message = "Bairro não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Santa Efigenia")
    private String bairro;

    @NotNull(message = "Cidade é obrigatório")
    @NotEmpty(message = "Cidade não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "São Paulo")
    private String cidade;

    @NotNull(message = "Estado é obrigatório")
    @NotEmpty(message = "Estado não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "São Paulo")
    private String estado;
}
