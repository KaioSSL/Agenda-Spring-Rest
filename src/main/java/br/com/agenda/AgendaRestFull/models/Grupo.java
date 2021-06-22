package br.com.agenda.AgendaRestFull.models;

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

@Entity
@Table(name = "AG_GRUPO")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Date data_cadastro;
	
	@OneToMany(mappedBy = "grupo")
	private List<Contato> contatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return descricao;
	}

	public void setDesc(String desc) {
		this.descricao = desc;
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

	public Grupo(String desc, Date data_cadastro, List<Contato> contatos) {
		this.descricao = desc;
		this.data_cadastro = data_cadastro;
		this.contatos = contatos;
	}

	public Grupo() {
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
		Grupo other = (Grupo) obj;
		return Objects.equals(contatos, other.contatos) && Objects.equals(data_cadastro, other.data_cadastro)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}
	
}
