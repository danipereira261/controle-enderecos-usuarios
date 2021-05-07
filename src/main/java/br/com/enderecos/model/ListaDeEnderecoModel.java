package br.com.enderecos.model;

import javax.persistence.*;


@Entity
@Table(name = "tb_lista_enderecos_usuarios")
public class ListaDeEnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "endereco_id")
    private Long EnderecoId;

    public ListaDeEnderecoModel() {
    }

    public ListaDeEnderecoModel(Long id, Long usuarioId, Long enderecoId) {
        this.id = id;
        this.usuarioId = usuarioId;
        EnderecoId = enderecoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEnderecoId() {
        return EnderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        EnderecoId = enderecoId;
    }
}
