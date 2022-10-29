package br.com.cadastrounico.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cadu_001_secretaria")
public class Secretaria implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id_secretaria")
    private Integer id;

    @Column(name="nom_secretaria")
    private String nome;

    @Column(name="nom_endereco")
    private String endereco;

    @Column(name="cod_telefone")
    private String telefone;

    @Column(name="sta_secretaria")
    private String statusSec;

    @Column(name="des_observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    public Secretaria() {
    }

    public Secretaria(Integer id, String nome, String endereco, String telefone, String statusSec, String observacao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.statusSec = statusSec;
        this.observacao = observacao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatusSec() {
        return statusSec;
    }

    public void setStatusSec(String statusSec) {
        this.statusSec = statusSec;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Secretaria other = (Secretaria) obj;
        return Objects.equals(id, other.id);
    }
}
