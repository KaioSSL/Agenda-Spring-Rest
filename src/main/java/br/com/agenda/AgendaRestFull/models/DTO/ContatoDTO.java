package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ContatoDTO {

	@Positive
	private Integer id;

	@Size(max = 30)
	private String nome;

	@Size(max = 30)
	private String sobrenome;

	@Size(max = 13)
	private String telefone;

	@Size(max = 30)
	private String email;

	private Date data;

	private String celular;
	private Integer marcador;
	private String descricao;
	private UsuarioDTO usuario;
	private GrupoDTO grupo;
	private List<EnderecoDTO> enderecos;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getMarcador() {
		return marcador;
	}

	public void setMarcador(Integer marcador) {
		this.marcador = marcador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public GrupoDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public ContatoDTO(Integer id, String nome, String sobrenome, String telefone, String email, Date data,
			String celular, Integer marcador, String descricao, UsuarioDTO usuario, GrupoDTO grupo,
			List<EnderecoDTO> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.celular = celular;
		this.marcador = marcador;
		this.descricao = descricao;
		this.usuario = usuario;
		this.grupo = grupo;
		this.enderecos = enderecos;
	}

	public ContatoDTO(String nome, String sobrenome, String telefone, String email, Date data, String celular,
			Integer marcador, String descricao, UsuarioDTO usuario, GrupoDTO grupo, List<EnderecoDTO> enderecos) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.celular = celular;
		this.marcador = marcador;
		this.descricao = descricao;
		this.usuario = usuario;
		this.grupo = grupo;
		this.enderecos = enderecos;
	}

	public ContatoDTO(String nome, String sobrenome, String telefone, String email, Date data, String celular,
			Integer marcador, String descricao, UsuarioDTO usuario, GrupoDTO grupo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.celular = celular;
		this.marcador = marcador;
		this.descricao = descricao;
		this.usuario = usuario;
		this.grupo = grupo;
	}

	public ContatoDTO() {
		super();
	}

}
