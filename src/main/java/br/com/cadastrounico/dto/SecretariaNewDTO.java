package br.com.cadastrounico.dto;

import java.io.Serializable;

public class SecretariaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    private String statusSec;
    private String observacao;

    public SecretariaNewDTO(Integer id, String nome, String endereco, String telefone, String statusSec,
                            String observacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.statusSec = statusSec;
        this.observacao = observacao;
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
}
