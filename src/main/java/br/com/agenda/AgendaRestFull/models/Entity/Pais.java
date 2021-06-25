package br.com.agenda.AgendaRestFull.models.Entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "AG_PAIS")
@JsonIdentityInfo(scope = Pais.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 90, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public void addEstado(Estado estado) {
		this.estados.add(estado);
	}
	public void removeEstado(Estado estado) {
		this.estados.remove(estado);
	}

	public Pais(String nome, String descricao, List<Estado> estados) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.estados = estados;
	}
	public Pais(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Pais() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, estados, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estados, other.estados)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
}
