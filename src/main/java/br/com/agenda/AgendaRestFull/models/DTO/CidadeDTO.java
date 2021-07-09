package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.List;
import java.util.Objects;

public class CidadeDTO {
	private Integer id;
	private String nome;
	private String descricao;
	private List<BairroDTO> bairros;
	private EstadoDTO estado;
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
	public List<BairroDTO> getBairros() {
		return bairros;
	}
	public void addBairro(BairroDTO bairro) {
		this.bairros.add(bairro);
	}
	public void removeBairro(BairroDTO bairro) {
		this.bairros.remove(bairro);
	}
	public void setBairros(List<BairroDTO> bairros) {
		this.bairros = bairros;
	}
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public CidadeDTO(Integer id, String nome, String descricao, EstadoDTO estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}
	public CidadeDTO() {
		super();
	}
	public CidadeDTO(String nome, String descricao, List<BairroDTO> bairros, EstadoDTO estado) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.bairros = bairros;
		this.estado = estado;
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
		CidadeDTO other = (CidadeDTO) obj;
		return Objects.equals(bairros, other.bairros) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
	
	
}
