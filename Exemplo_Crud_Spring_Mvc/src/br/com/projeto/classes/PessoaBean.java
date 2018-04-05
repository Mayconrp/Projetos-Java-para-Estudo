package br.com.projeto.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 5684774867755233893L;

	private String id;

	private String nome;

	private String endereco;

	private List<TelefonePessoaBean> telefonePessoas = new ArrayList<TelefonePessoaBean>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<TelefonePessoaBean> getTelefonePessoas() {
		return telefonePessoas;
	}

	public void setTelefonePessoas(List<TelefonePessoaBean> telefonePessoas) {
		this.telefonePessoas = telefonePessoas;
	}

}
