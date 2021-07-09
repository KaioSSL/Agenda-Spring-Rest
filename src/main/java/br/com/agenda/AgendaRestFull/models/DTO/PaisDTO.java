package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(scope = PaisDTO.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PaisDTO {
	@Positive
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	@JsonIgnore
	private List<EstadoDTO> estados;
	
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
	public List<EstadoDTO> getEstados() {
		return estados;
	}
	public void setEstados(List<EstadoDTO> estados) {
		this.estados = estados;
	}
	public PaisDTO(Integer id, String nome, String descricao, List<EstadoDTO> estados) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estados = estados;
	}
	public PaisDTO(String nome, String descricao, List<EstadoDTO> estados) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.estados = estados;
	}
	public PaisDTO() {
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
		PaisDTO other = (PaisDTO) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estados, other.estados)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
}
