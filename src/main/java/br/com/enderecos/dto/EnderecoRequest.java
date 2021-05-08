package br.com.enderecos.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

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


    public EnderecoRequest() {
    }

    public EnderecoRequest(@NotEmpty(message = "Logradouro não pode ser vazio") String logradouro, @NotEmpty(message = "Número não pode ser vazio") String numero, String complemento, @NotEmpty(message = "Bairro não pode ser vazio") String bairro, @NotEmpty(message = "Cidade não pode ser vazio") String cidade, @NotEmpty(message = "Estado não pode ser vazio") String estado, @NotEmpty(message = "01209010") String cep, @NotEmpty(message = "Cpf não pode ser vazio") String cpfCliente) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cpfCliente = cpfCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}
