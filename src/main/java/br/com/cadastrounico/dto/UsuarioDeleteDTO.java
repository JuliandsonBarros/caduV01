package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cadastrounico.model.Usuario;

public class UsuarioDeleteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String status;
    
    
	public UsuarioDeleteDTO() {
	}

	public UsuarioDeleteDTO(Usuario usuario) {
	    id = usuario.getId();
        status = usuario.getStatus().toUpperCase();
        
}

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
}
