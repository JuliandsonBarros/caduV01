package br.com.cadastrounico.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cadu_004_permissao")
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1;

	@EmbeddedId
	private  PermissãoPK id = new  PermissãoPK();
	
	@Column(name="sta_permissao")
	private String StatusPermissao;
	
	@Column(name="nom_senha")
	private String nomeSenha;
	
	@Column(name="cod_verificador")
	private String codVerificador;
	
	@Column(name="qtd_tentativas")
	private Integer qtdTentativas;
	
	public Permissao() {
		super();
	}
	
	public Permissao(Perfil perfil, Usuario usuario, String statusPermissao, String nomeSenha, String codVerificador,
			Integer qtdTentativas) {
		super();
		id.setPerfil(perfil);
		id.setUsuario(usuario);
		this.StatusPermissao = statusPermissao;
		this.nomeSenha = nomeSenha;
		this.codVerificador = codVerificador;
		this.qtdTentativas = qtdTentativas;
	}
	
	public Perfil getPerfil() {
		return id.getPerfil();
	}
	
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	public String getStatusPermissao() {
		return StatusPermissao;
	}
	public void setStatusPermissao(String statusPermissao) {
		StatusPermissao = statusPermissao;
	}
	public String getNomeSenha() {
		return nomeSenha;
	}
	public void setNomeSenha(String nomeSenha) {
		this.nomeSenha = nomeSenha;
	}
	public String getCodVerificador() {
		return codVerificador;
	}
	public void setCodVerificador(String codVerificador) {
		this.codVerificador = codVerificador;
	}
	public Integer getQtdTentativas() {
		return qtdTentativas;
	}
	public void setQtdTentativas(Integer qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}
}
