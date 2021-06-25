package br.com.agenda.AgendaRestFull.models.Entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "AG_CIDADE")
@JsonIdentityInfo(scope = Cidade.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 90, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "cidade")
	private List<Bairro> bairros;
	
	@ManyToOne
	private Estado estado;

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

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public void addBairro(Bairro bairro) {
		this.bairros.add(bairro);
	}
	
	public void removeBairro(Bairro bairro) {
		this.bairros.remove(bairro);
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade(String nome, String descricao, List<Bairro> bairros, Estado estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.bairros = bairros;
		this.estado = estado;
	}
	public Cidade(String nome, String descricao, Estado estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}

	public Cidade() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairros, descricao, estado, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(bairros, other.bairros) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
}
