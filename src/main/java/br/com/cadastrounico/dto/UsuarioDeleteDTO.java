package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cadastrounico.model.Usuario;

public class UsuarioDeleteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Integer id;
	private String status;

	public UsuarioDeleteDTO() {
	}

	public UsuarioDeleteDTO(Usuario usuario) {
		id = usuario.getId_usuario();
		status = usuario.getSta_usuario().toUpperCase();
	}

}
