package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(scope = UsuarioDTO.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsuarioDTO {

	@Positive
	private Integer id;

	@Size(min = 4, max = 10, message = "Favor inserir um login que contenha entre 4 a 10 caracteres")
	private String login;

	@Size(min = 4, max = 10, message = "Favor inserir uma senha que contenha entre 4 a 10 caracteres")
	private String senha;

	private Date data_cadastro = new Date();

	@Max(1)
	@Min(0)
	private Integer status;

	@Email
	private String email;
	
	@JsonIgnore
	private List<ContatoDTO> contatos;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ContatoDTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}

	public void addContatos(ContatoDTO contato) {
		this.contatos.add(contato);
	}

	public void removeContato(ContatoDTO contato) {
		this.contatos.remove(contato);
	}

	public UsuarioDTO(Integer id, String login, String senha, Date data_cadastro, Integer status, String email) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.data_cadastro = data_cadastro;
		this.status = status;
		this.email = email;
	}

	public UsuarioDTO(String login, String senha, Date data_cadastro, Integer status, String email) {
		super();
		this.login = login;
		this.senha = senha;
		this.data_cadastro = data_cadastro;
		this.status = status;
		this.email = email;
	}

	public UsuarioDTO() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(contatos, data_cadastro, email, id, login, senha, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(contatos, other.contatos) && Objects.equals(data_cadastro, other.data_cadastro)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(senha, other.senha)
				&& Objects.equals(status, other.status);
	}
	
	
}
