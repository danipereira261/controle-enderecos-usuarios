package br.com.enderecos.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioRequest {
    @NotNull(message = "Nome obrigatório")
    @NotEmpty(message = "Nome não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "Daniele Santana Pereira" )
    private String nome;


    @NotNull(message = "Email obrigatório")
    @NotEmpty(message = "Email não pode ser vazio")
    @Email(message = "Email precisa ser válido")
    @ApiModelProperty(value = "", required = true, example = "dpereira261@gmail.com" )
    private String email;


    @NotNull(message = "Cpf obrigatório")
    @NotEmpty(message = "Cpf não pode ser vazio")
    @CPF(message = "CPF precisa ser válido")
    @ApiModelProperty(value = "", required = true, example = "35107781896" )
    private String cpf;

    @NotNull(message = "Data Nascimento obrigatório")
    @NotEmpty(message = "Data Nascimento não pode ser vazio")
    @ApiModelProperty(value = "", required = true, example = "26/01/1988" )
    private String dataNascimento;

    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotNull(message = "Nome obrigatório") @NotEmpty(message = "Nome não pode ser vazio") String nome, @NotNull(message = "Email obrigatório") @NotEmpty(message = "Email não pode ser vazio") @Email(message = "Email precisa ser válido") String email, @NotNull(message = "Cpf obrigatório") @NotEmpty(message = "Cpf não pode ser vazio") @CPF(message = "CPF precisa ser válido") String cpf, @NotNull(message = "Data Nascimento obrigatório") @NotEmpty(message = "Data Nascimento não pode ser vazio") String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
