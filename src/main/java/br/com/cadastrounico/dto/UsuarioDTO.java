package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.service.validation.UsuarioInsert;
import net.bytebuddy.implementation.bind.annotation.Empty;

@UsuarioInsert
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    
   @NotEmpty(message="Preenchimento obrigatório")
   @Length(min=5, max=80,message="O Tamanho deve ser entre 5 e 80 caracteres")
    private String nomeCompleto;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="O Tamanho deve ser entre 10 e 120 caracteres")
    private String email;
    
    @Length(min=1, max=1, message="O Tamanho deve conter 1 caractere")
    private String sexo;
   
    private String cpf;
    private String rg;
    private String telefone;
    
    @Length(min=1, max=1,message="O Tamanho deve conter 1 caractere")
    private String status;
    
    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nomeCompleto = usuario.getNomeCompleto();
        dataNascimento = usuario.getDataNascimento();
        email = usuario.getEmail();
        sexo = usuario.getSexo().toUpperCase();
        cpf = usuario.getCpf();
        rg = usuario.getRg();
        telefone = usuario.getTelefone();
        status = usuario.getStatus().toUpperCase();
        
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
