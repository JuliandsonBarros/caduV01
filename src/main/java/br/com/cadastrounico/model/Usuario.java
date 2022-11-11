package br.com.cadastrounico.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cadu_002_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String nom_usuario;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dta_nascimento;
    
    private String nom_email;
    private String nom_sexo;
    private String cod_cpf;
    private String cod_rg;
    private String cod_telefone;
    private String sta_usuario;
    
    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nom_usuario, LocalDate dta_nascimento, String nom_email, String nom_sexo,
			String cod_cpf, String cod_rg, String cod_telefone, String sta_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.nom_usuario = nom_usuario;
		this.dta_nascimento = dta_nascimento;
		this.nom_email = nom_email;
		this.nom_sexo = nom_sexo;
		this.cod_cpf = cod_cpf;
		this.cod_rg = cod_rg;
		this.cod_telefone = cod_telefone;
		this.sta_usuario = sta_usuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public LocalDate getDta_nascimento() {
		return dta_nascimento;
	}

	public void setDta_nascimento(LocalDate dta_nascimento) {
		this.dta_nascimento = dta_nascimento;
	}

	public String getNom_email() {
		return nom_email;
	}

	public void setNom_email(String nom_email) {
		this.nom_email = nom_email;
	}

	public String getNom_sexo() {
		return nom_sexo;
	}

	public void setNom_sexo(String nom_sexo) {
		this.nom_sexo = nom_sexo;
	}

	public String getCod_cpf() {
		return cod_cpf;
	}

	public void setCod_cpf(String cod_cpf) {
		this.cod_cpf = cod_cpf;
	}

	public String getCod_rg() {
		return cod_rg;
	}

	public void setCod_rg(String cod_rg) {
		this.cod_rg = cod_rg;
	}

	public String getCod_telefone() {
		return cod_telefone;
	}

	public void setCod_telefone(String cod_telefone) {
		this.cod_telefone = cod_telefone;
	}

	public String getSta_usuario() {
		return sta_usuario;
	}

	public void setSta_usuario(String sta_usuario) {
		this.sta_usuario = sta_usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario);
	}
}
