package br.com.cadastrounico.service.exception;

public class ObjectNotFoundExeption extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExeption(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundExeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
