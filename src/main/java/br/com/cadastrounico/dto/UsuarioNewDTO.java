package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cadastrounico.service.validation.UsuarioInsert;

public class UsuarioNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeCompleto;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String email;
    private String sexo;
    
    @CPF
    private String cpf;
    private String rg;
    private String senha;
    private String telefone;
    private String status;

    public UsuarioNewDTO(Integer id, String nomeCompleto, LocalDate dataNascimento, String email,String sexo,
    		String cpf, String rg, String senha, String telefone, String status) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo.toUpperCase();
        this.cpf = cpf;
        this.rg = rg;
        this.senha = senha;
        this.telefone = telefone;
        this.status = status.toUpperCase();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getSexo() {
		return sexo;
	}
	
	 public void setSexo(String sexo) {
	        this.sexo = sexo;
	}
}
