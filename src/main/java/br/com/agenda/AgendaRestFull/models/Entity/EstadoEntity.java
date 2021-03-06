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
@Table(name = "AG_ESTADO")
@JsonIdentityInfo(scope = EstadoEntity.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EstadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 90, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "estado")
	private List<CidadeEntity> cidades;
	
	@ManyToOne
	private PaisEntity pais;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<CidadeEntity> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeEntity> cidades) {
		this.cidades = cidades;
	}
	
	public void addCidade(CidadeEntity cidade) {
		this.cidades.add(cidade);
	}
	public void removeCidade(CidadeEntity cidade) {
		this.cidades.remove(cidade);
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
	}

	public EstadoEntity(String nome, String descricao, String sigla, List<CidadeEntity> cidades, PaisEntity pais) {
		this.nome = nome;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cidades = cidades;
		this.pais = pais;
	}
	public EstadoEntity(String nome, String descricao,String sigla, PaisEntity pais) {
		this.nome = nome;
		this.descricao = descricao;
		this.sigla = sigla;
		this.pais = pais;
	}

	public EstadoEntity() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidades, descricao, id, nome, pais, sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoEntity other = (EstadoEntity) obj;
		return Objects.equals(cidades, other.cidades) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(pais, other.pais)
				&& Objects.equals(sigla, other.sigla);
	}
}
