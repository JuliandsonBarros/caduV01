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
    private Integer id_secretaria;
    private String nom_secretaria;
    private String nom_endereco;
    private String cod_telefone;
    private String sta_secretaria;
    private String des_observacao;
    @ManyToOne
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    public Secretaria() {
    }

    public Secretaria(Integer id_secretaria, String nom_secretaria, String nom_endereco, String cod_telefone,
			String sta_secretaria, String des_observacao, Usuario usuario) {
		super();
		this.id_secretaria = id_secretaria;
		this.nom_secretaria = nom_secretaria;
		this.nom_endereco = nom_endereco;
		this.cod_telefone = cod_telefone;
		this.sta_secretaria = sta_secretaria;
		this.des_observacao = des_observacao;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_secretaria);
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
		return Objects.equals(id_secretaria, other.id_secretaria);
	}
}
