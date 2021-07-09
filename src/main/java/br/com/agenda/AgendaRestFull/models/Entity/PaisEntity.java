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

@Entity
@Table(name = "AG_PAIS")

public class PaisEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 90, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "pais")
	private List<EstadoEntity> estados;

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

	public List<EstadoEntity> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoEntity> estados) {
		this.estados = estados;
	}
	
	public void addEstado(EstadoEntity estado) {
		this.estados.add(estado);
	}
	public void removeEstado(EstadoEntity estado) {
		this.estados.remove(estado);
	}

	public PaisEntity(String nome, String descricao, List<EstadoEntity> estados) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.estados = estados;
	}
	public PaisEntity(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public PaisEntity() {
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
		PaisEntity other = (PaisEntity) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estados, other.estados)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
}
