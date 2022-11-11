package br.com.cadastrounico.dto;

import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.model.Usuario;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class SecretariaDTO implements Serializable {
    private static final long serialVersionUID = 1;

    private Integer id_secretaria;
    
    @NotEmpty(message="O preenchimento é obrigatório")
    @Length(min=5, max=80,message="O tamanho deve está entre 5 e 80 caracteres")
    private String nom_secretaria;
    private String nom_endereco;
    private String cod_telefone;
    
    @Length(min=1, max=1,message="O Tamanho deve ser de 1 caractere")
    private String sta_secretaria;
    private String des_observacao;
    private Usuario usuario;
    
    public SecretariaDTO() {
    }

    public SecretariaDTO(Secretaria secretaria){
    	id_secretaria = secretaria.getId_secretaria();
    	nom_secretaria = secretaria.getNom_secretaria();
    	nom_endereco = secretaria.getNom_endereco();
    	cod_telefone = secretaria.getCod_telefone();
    	sta_secretaria = secretaria.getSta_secretaria().toUpperCase();
    	des_observacao = secretaria.getDes_observacao();
    	usuario	= secretaria.getUsuario();
    }

	public Integer getId_secretaria() {
		return id_secretaria;
	}

	public void setId_secretaria(Integer id_secretaria) {
		this.id_secretaria = id_secretaria;
	}

	public String getNom_secretaria() {
		return nom_secretaria;
	}

	public void setNom_secretaria(String nom_secretaria) {
		this.nom_secretaria = nom_secretaria;
	}

	public String getNom_endereco() {
		return nom_endereco;
	}

	public void setNom_endereco(String nom_endereco) {
		this.nom_endereco = nom_endereco;
	}

	public String getCod_telefone() {
		return cod_telefone;
	}

	public void setCod_telefone(String cod_telefone) {
		this.cod_telefone = cod_telefone;
	}

	public String getSta_secretaria() {
		return sta_secretaria;
	}

	public void setSta_secretaria(String sta_secretaria) {
		this.sta_secretaria = sta_secretaria;
	}

	public String getDes_observacao() {
		return des_observacao;
	}

	public void setDes_observacao(String des_observacao) {
		this.des_observacao = des_observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
