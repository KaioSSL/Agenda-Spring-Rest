package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class GrupoDTO {

	@Positive
	private Integer id;
	@Size(max = 45)
	private String descricao;
	@Size(max = 20)
	private String nome;

	private Date data_cadastro = new Date();

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

}
