package br.com.agenda.AgendaRestFull.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AG_USU")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String login;
	@Column
	private String senha;
	@Column
	private Date data_cadastro;
	@Column
	private Integer status;
	@Column
	private String email;

	private List<Contato> contatos;

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

	public Usuario(String login, String senha, Date data_cadastro, Integer status, String email,
			List<Contato> contatos) {
		this.login = login;
		this.senha = senha;
		this.data_cadastro = data_cadastro;
		this.status = status;
		this.email = email;
		this.contatos = contatos;
	}

	public Usuario() {
	}

}
