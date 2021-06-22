package br.com.agenda.AgendaRestFull.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AG_CONTATO")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30, nullable = false)
	
	private String nome;
	@Column(length = 30, nullable = false)
	private String sobrenome;
	
	@Column(nullable = false)
	private Integer telefone;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Column( nullable = false)
	private Date data_cadastro;
	
	@Column(nullable = false)
	private Integer celular;
	
	@Column(nullable = false)
	private Integer marcador;
	
	@Column(length = 255, nullable = false)
	private String observacao;
	
	// Ligações
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Grupo grupo;
	
	@OneToMany(mappedBy = "contato")
	private List<Endereco> enderecos;

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

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
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

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> endereco) {
		this.enderecos = endereco;
	}
	
	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}
	
	public void removeEndereco(Endereco endereco) {
		this.removeEndereco(endereco);
	}

	public Contato(String nome, String sobrenome, Integer telefone, String email, Date data_cadastro, Integer celular,
			Integer marcador, String observacao, Usuario usuario, Grupo grupo, List<Endereco> enderecos) {
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

	public Contato() {
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
		Contato other = (Contato) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(data_cadastro, other.data_cadastro)
				&& Objects.equals(email, other.email) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(grupo, other.grupo) && Objects.equals(id, other.id)
				&& Objects.equals(marcador, other.marcador) && Objects.equals(nome, other.nome)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(usuario, other.usuario);
	}
	
	
}
