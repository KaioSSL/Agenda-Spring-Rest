package br.com.agenda.AgendaRestFull.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "AG_USU")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 10, nullable = false, unique = true)
	private String login;

	@Column(length = 10, nullable = false)
	private String senha;

	private Date data_cadastro = new Date();

	@Column(nullable = false)
	private Integer status;

	@Column(length = 30, nullable = false)
	private String email;

	@OneToMany(mappedBy = "usuario")
	private List<Contato> contatos;

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

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Usuario(String login, String senha, Integer status, String email, List<Contato> contatos) {
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.email = email;
		this.contatos = contatos;
	}

	public Usuario(String login, String senha, Integer status, String email) {
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.email = email;
	}

	public Usuario() {
	}

}
