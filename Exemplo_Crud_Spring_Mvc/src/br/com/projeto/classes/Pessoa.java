package br.com.projeto.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 5684774867755233893L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	@Transient
	private String telefonePessoasTemp;

	@OneToMany(mappedBy="pessoa", orphanRemoval= true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<TelefonePessoa> telefonePessoas = new ArrayList<TelefonePessoa>();
	
	
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name="pessoa_projeto",
	             joinColumns={@JoinColumn(name="pessoa_id")},
	             inverseJoinColumns={@JoinColumn(name="projeto_id")})
	private List<Projeto> projetos = new ArrayList<Projeto>();
	 
	 
	 public void setTelefonePessoasTemp(String telefonePessoasTemp) {
		this.telefonePessoasTemp = telefonePessoasTemp;
	}
	 
	 public String getTelefonePessoasTemp() {
		return telefonePessoasTemp;
	}
	
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setTelefonePessoas(List<TelefonePessoa> telefonePessoas) {
		this.telefonePessoas = telefonePessoas;
	}

	public List<TelefonePessoa> getTelefonePessoas() {
		return telefonePessoas;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
