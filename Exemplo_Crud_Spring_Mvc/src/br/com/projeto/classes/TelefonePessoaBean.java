package br.com.projeto.classes;

import java.io.Serializable;

public class TelefonePessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String numero;

	private String pessoa;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

}
