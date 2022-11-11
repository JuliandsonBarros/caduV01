package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.service.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_usuario;
    
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80,message="O Tamanho deve ser entre 5 e 80 caracteres")
    private String nom_usuario;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dta_nascimento;
    
    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="O Tamanho deve ser entre 10 e 120 caracteres")
    private String nom_email;
    
    @Length(min=1, max=1, message="O Tamanho deve conter 1 caractere")
    private String nom_sexo;
   
    @CPF(message="campo obrigatório")
    private String cod_cpf;
    private String cod_rg;
    private String cod_telefone;
    
    @Length(min=1, max=1,message="O Tamanho deve conter 1 caractere")
    private String sta_usuario;
    
    public UsuarioDTO() {
    }

	public UsuarioDTO(Usuario usuario) {
		id_usuario = usuario.getId_usuario();
		nom_usuario = usuario.getNom_usuario();
		dta_nascimento =usuario.getDta_nascimento();
		nom_email = usuario.getNom_email();
		nom_sexo = usuario.getNom_sexo();
		cod_cpf = usuario.getCod_cpf();
		cod_rg = usuario.getCod_rg();
		cod_telefone = usuario.getCod_telefone();
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
}
