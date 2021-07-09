package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(scope = ContatoDTO.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	@NotNull
	private Date data_cadastro = new Date();

	private String celular;
	
	@Positive
	private Integer marcador;
	
	private String observacao;
	
	private UsuarioDTO usuario;
	
	private GrupoDTO grupo;
	
	@JsonIgnore
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

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data) {
		this.data_cadastro = data;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public ContatoDTO(Integer id, String nome, String sobrenome, String telefone, String email, Date data_cadastro,
			String celular, Integer marcador, String observacao, UsuarioDTO usuario, GrupoDTO grupo,
			List<EnderecoDTO> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data_cadastro = data_cadastro;
		this.celular = celular;
		this.marcador = marcador;
		this.observacao = observacao;
		this.usuario = usuario;
		this.grupo = grupo;
		this.enderecos = enderecos;
	}

	public ContatoDTO(String nome, String sobrenome, String telefone, String email, Date data_cadastro, String celular,
			Integer marcador, String observacao, UsuarioDTO usuario, GrupoDTO grupo, List<EnderecoDTO> enderecos) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data_cadastro = data_cadastro;
		this.celular = celular;
		this.marcador = marcador;
		this.observacao = observacao;
		this.usuario = usuario;
		this.grupo = grupo;
		this.enderecos = enderecos;
	}

	public ContatoDTO(String nome, String sobrenome, String telefone, String email, Date data_cadastro, String celular,
			Integer marcador, String observacao, UsuarioDTO usuario, GrupoDTO grupo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.data_cadastro = data_cadastro;
		this.celular = celular;
		this.marcador = marcador;
		this.observacao = observacao;
		this.usuario = usuario;
		this.grupo = grupo;
	}

	public ContatoDTO() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular, data_cadastro, email, enderecos, grupo, id, marcador, nome, observacao, sobrenome,
				telefone, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoDTO other = (ContatoDTO) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(data_cadastro, other.data_cadastro)
				&& Objects.equals(email, other.email) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(grupo, other.grupo) && Objects.equals(id, other.id)
				&& Objects.equals(marcador, other.marcador) && Objects.equals(nome, other.nome)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(usuario, other.usuario);
	}
	
	
}
