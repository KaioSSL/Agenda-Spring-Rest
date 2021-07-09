package br.com.agenda.AgendaRestFull.models.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "AG_ENDERECO")
@JsonIdentityInfo(scope = EnderecoEntity.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EnderecoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30, nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private Integer n_logradouro;
	
	@Column(nullable = false)
	private Integer cep;
	
	@Column(length = 90, nullable = false)
	private String referencia;
	
	@Column(length = 180, nullable = false)
	private String complemento;
	
	@ManyToOne
	private BairroEntity bairro;

	@ManyToOne
	private ContatoEntity contato;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getN_logradouro() {
		return n_logradouro;
	}

	public void setN_logradouro(Integer n_logradouro) {
		this.n_logradouro = n_logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public BairroEntity getBairro() {
		return bairro;
	}

	public void setBairro(BairroEntity bairro) {
		this.bairro = bairro;
	}

	
	public ContatoEntity getContato() {
		return contato;
	}

	public void setContato(ContatoEntity contato) {
		this.contato = contato;
	}

	public EnderecoEntity(String logradouro, Integer n_logradouro, Integer cep, String referencia, String complemento,
			BairroEntity bairro, ContatoEntity contato) {
		this.logradouro = logradouro;
		this.n_logradouro = n_logradouro;
		this.cep = cep;
		this.referencia = referencia;
		this.complemento = complemento;
		this.bairro = bairro;
		this.contato = contato;
	}

	public EnderecoEntity() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, id, logradouro, n_logradouro, referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoEntity other = (EnderecoEntity) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(n_logradouro, other.n_logradouro)
				&& Objects.equals(referencia, other.referencia);
	}
	
}
