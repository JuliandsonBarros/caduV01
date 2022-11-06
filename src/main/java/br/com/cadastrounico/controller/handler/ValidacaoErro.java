package br.com.cadastrounico.controller.handler;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoErro extends ErroPadrao {

	private static final long serialVersionUID = 1L;
	
	List<CampoMensagem> lista = new ArrayList<>();
	
	public ValidacaoErro(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);	
	}

	public List<CampoMensagem> getError() {
		return lista;
	}

	public void addErro(String campo, String mensagem) {
		lista.add(new CampoMensagem(campo, mensagem));
	}

	
	

	

	
}
