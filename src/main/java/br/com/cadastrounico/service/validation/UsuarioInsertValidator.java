package br.com.cadastrounico.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cadastrounico.controller.handler.CampoMensagem;
import br.com.cadastrounico.dto.UsuarioDTO;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.repository.UsuarioRepository;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioDTO, UsuarioDTO> {

	@Autowired
	public UsuarioRepository repo;
	
	 Usuario usuario = new Usuario();

	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		List<CampoMensagem> lista = new ArrayList<>();
		
		
		
		for (CampoMensagem e : lista) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getCampo())
					.addConstraintViolation();
		}
		return lista.isEmpty();
	}

}