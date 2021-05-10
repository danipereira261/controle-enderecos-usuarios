package br.com.enderecos.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    @NotNull(message = "Cpf obrigatório")
    @NotEmpty(message = "Cpf não pode ser vazio")
    @CPF(message = "CPF precisa ser válido")
    @ApiModelProperty(value = "", required = true, example = "63561410006")
    private String cpf;

    @NotNull(message = "Nome obrigatório")
    @NotEmpty(message = "Nome não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Jose da Silva")
    private String nome;

    @NotNull(message = "Data Nascimento obrigatório")
    @NotEmpty(message = "Data Nascimento não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "29/09/1994")
    private String dataNascimento;

    @NotNull(message = "Email obrigatório")
    @NotEmpty(message = "Email não pode ser vazio")
    @Email(message = "Email precisa ser válido")
    @ApiModelProperty(value = "", required = true, example = "jose@gmail.com")
    private String email;
}