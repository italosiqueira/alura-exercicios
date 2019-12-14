package br.com.alura.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2793223330879512618L;
	
	private List<String> mensagens;

	public BusinessException() {
		super();
		this.mensagens = new ArrayList<String>();
	}

	public BusinessException(String mensagem) {
		super(mensagem);
		this.mensagens = new ArrayList<String>();
		this.mensagens.add(mensagem);
	}
	
	public void adicionaMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

}
