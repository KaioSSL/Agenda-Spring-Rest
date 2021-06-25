package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Date;
import java.util.List;

import com.sun.istack.NotNull;

import br.com.agenda.AgendaRestFull.models.Entity.Contato;

public class UsuarioDTO {
	@NotNull
	@Pat
	private Integer id;
	private String login;
	private String senha;
	private Date data_cadastro;
	private Integer status;
	private String email;
	private List<Contato> contatos;
	
	//Getters and Setters
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
	public void addContatos(Contato contato){
		this.contatos.add(contato);
	}
	public void removeContato(Contato contato){
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
}
