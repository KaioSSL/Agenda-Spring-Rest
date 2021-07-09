package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.List;
import java.util.Objects;

public class BairroDTO {
	private Integer id;
	private String nome;
	private String descricao;
	private List<EnderecoDTO> enderecos;
	private CidadeDTO cidade;
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
	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	public void addEndereco(EnderecoDTO endereco) {
		this.enderecos.add(endereco);
	}
	public void removeEndereco(EnderecoDTO endereco) {
		this.enderecos.remove(endereco);
	}
	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}
	public CidadeDTO getCidade() {
		return cidade;
	}
	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	public BairroDTO(Integer id, String nome, String descricao, List<EnderecoDTO> enderecos, CidadeDTO cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.enderecos = enderecos;
		this.cidade = cidade;
	}
	public BairroDTO(Integer id, String nome, String descricao, CidadeDTO cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
	}
	public BairroDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(cidade, descricao, enderecos, id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BairroDTO other = (BairroDTO) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(enderecos, other.enderecos) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
}
