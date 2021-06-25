package br.com.agenda.AgendaRestFull.models.Entity;

import java.util.Date;
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
@Table(name = "AG_GRUPO")
@JsonIdentityInfo(scope = GrupoEntity.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GrupoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String descricao;

	@Column(length = 20, nullable = false)
	private String nome;

	@Column
	private Date data_cadastro = new Date();

	@OneToMany(mappedBy = "grupo")
	private List<Contato> contatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrupoEntity(String desc, String nome, List<Contato> contatos) {
		this.nome = nome;
		this.descricao = desc;
		this.contatos = contatos;
	}

	public GrupoEntity(String desc, String nome) {
		this.descricao = desc;
		this.nome = nome;
	}

	public GrupoEntity() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(contatos, data_cadastro, descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEntity other = (GrupoEntity) obj;
		return Objects.equals(contatos, other.contatos) && Objects.equals(data_cadastro, other.data_cadastro) && Objects
				.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
