package br.com.cadastrounico.dto;

import java.io.Serializable;

public class SecretariaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_secretaria;
    private String nom_secretaria;
    private String nom_endereco;
    private String cod_telefone;
    private String sta_secretaria;
    private String des_observacao;
    private UsuarioDTO usuario;

    public SecretariaNewDTO(Integer id, String nome, String endereco, String telefone, String statusSec,
                            String observacao, UsuarioDTO usuario) {
        this.id_secretaria = id;
        this.nom_secretaria = nome;
        this.nom_endereco = endereco;
        this.cod_telefone = telefone;
        this.sta_secretaria = statusSec;
        this.des_observacao = observacao;
        this.usuario = usuario;
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
