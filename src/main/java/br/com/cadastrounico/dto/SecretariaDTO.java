package br.com.cadastrounico.dto;

import br.com.cadastrounico.model.Secretaria;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class SecretariaDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Integer id;
    
    @NotEmpty(message="O preenchimento é obrigatório")
    @Length(min=5, max=80,message="O tamanho deve está entre 5 e 80 caracteres")
    private String nome;
    private String endereco;
    private String telefone;
    
    @Length(min=1, max=1,message="O Tamanho deve ser de 1 caractere")
    private String statusSec;
    private String observacao;
    
    public SecretariaDTO() {
    }

    public SecretariaDTO(Secretaria secretaria){
        id = secretaria.getId();
        nome = secretaria.getNome();
        endereco = secretaria.getEndereco();
        telefone = secretaria.getTelefone();
        statusSec = secretaria.getStatusSec().toUpperCase();
        observacao = secretaria.getObservacao();
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
