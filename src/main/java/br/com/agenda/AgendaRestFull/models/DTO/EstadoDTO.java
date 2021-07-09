package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(scope = UsuarioDTO.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EstadoDTO {
	
	private Integer id;
	private String nome;
	private String sigla;
	private String descricao;
	@JsonIgnore
	private List<CidadeDTO> cidades;
	private PaisDTO pais;
	
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
	public List<CidadeDTO> getCidades() {
		return cidades;
	}
	public void setCidades(List<CidadeDTO> cidades) {
		this.cidades = cidades;
	}
	public PaisDTO getPais() {
		return pais;
	}
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
	public EstadoDTO(Integer id, String nome, String sigla, String descricao, List<CidadeDTO> cidades, PaisDTO pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
		this.cidades = cidades;
		this.pais = pais;
	}
	public EstadoDTO(String nome, String sigla, String descricao, List<CidadeDTO> cidades, PaisDTO pais) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
		this.cidades = cidades;
		this.pais = pais;
	}
	public EstadoDTO(String nome, String sigla, String descricao, PaisDTO pais) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
		this.pais = pais;
	}
	public EstadoDTO() {
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
		EstadoDTO other = (EstadoDTO) obj;
		return Objects.equals(cidades, other.cidades) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(pais, other.pais)
				&& Objects.equals(sigla, other.sigla);
	}
	
	

}
