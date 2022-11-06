package br.com.cadastrounico.controller.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cadastrounico.service.exception.ObjectNotFoundExeption;
	
@ControllerAdvice
public class ControllerExceptionHandler {

	// Usuario/Secretaria invalido
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<ErroPadrao> ObjectNotFoundExeption(ObjectNotFoundExeption e, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	// Validaçoes de campos no DTO
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidacaoErro erro = new ValidacaoErro(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addErro(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ErroPadrao> CPFInvalido(IllegalStateException e, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), "CPF inválido", System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
