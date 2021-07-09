package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(scope = GrupoDTO.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GrupoDTO {

	@Positive
	private Integer id;
	@Size(max = 45)
	private String descricao;
	@Size(max = 20)
	private String nome;

	private Date data_cadastro = new Date();
	
	@JsonIgnore
	private List<ContatoDTO> contatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public List<ContatoDTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}

	public GrupoDTO(Integer id, String descricao, String nome, Date data_cadastro, List<ContatoDTO> contatos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.data_cadastro = data_cadastro;
		this.contatos = contatos;
	}

	public GrupoDTO(String descricao, String nome, Date data_cadastro, List<ContatoDTO> contatos) {
		super();
		this.descricao = descricao;
		this.nome = nome;
		this.data_cadastro = data_cadastro;
		this.contatos = contatos;
	}

	public GrupoDTO() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(contatos, data_cadastro, descricao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDTO other = (GrupoDTO) obj;
		return Objects.equals(contatos, other.contatos) && Objects.equals(data_cadastro, other.data_cadastro)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
	
}
