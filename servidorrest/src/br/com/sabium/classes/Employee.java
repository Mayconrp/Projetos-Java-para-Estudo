package br.com.sabium.classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee")
@SequenceGenerator(name = "seq_employee", sequenceName = "seq_employee", initialValue = 1, allocationSize = 1)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_employee")
	private Long id;

	@Column(nullable = false, length = 300, precision = 2)
	private String name;

	private BigDecimal salary = BigDecimal.ZERO;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "emp_proj", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = { @JoinColumn(name = "proj_id") }, uniqueConstraints = @UniqueConstraint(columnNames = {
			"emp_id", "proj_id" }))
	private List<Project> projetos = new ArrayList<Project>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Project> projetos) {
		this.projetos = projetos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
