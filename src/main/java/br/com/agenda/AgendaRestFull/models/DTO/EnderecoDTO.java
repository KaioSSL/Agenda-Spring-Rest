package br.com.agenda.AgendaRestFull.models.DTO;

import java.util.Objects;

public class EnderecoDTO {
	private Integer id;
	private String logradouro;
	private Integer n_logradouro;
	private Integer cep;
	private String referencia;
	private String complemento;
	private BairroDTO bairro;
	private ContatoDTO contato;
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
	public BairroDTO getBairro() {
		return bairro;
	}
	public void setBairro(BairroDTO bairro) {
		this.bairro = bairro;
	}
	public ContatoDTO getContato() {
		return contato;
	}
	public void setContato(ContatoDTO contato) {
		this.contato = contato;
	}
	public EnderecoDTO(String logradouro, Integer n_logradouro, Integer cep, String referencia, String complemento,
			BairroDTO bairro, ContatoDTO contato) {
		super();
		this.logradouro = logradouro;
		this.n_logradouro = n_logradouro;
		this.cep = cep;
		this.referencia = referencia;
		this.complemento = complemento;
		this.bairro = bairro;
		this.contato = contato;
	}
	public EnderecoDTO(Integer id, String logradouro, Integer n_logradouro, Integer cep, String referencia,
			String complemento, BairroDTO bairro, ContatoDTO contato) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.n_logradouro = n_logradouro;
		this.cep = cep;
		this.referencia = referencia;
		this.complemento = complemento;
		this.bairro = bairro;
		this.contato = contato;
	}
	public EnderecoDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, contato, id, logradouro, n_logradouro, referencia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(contato, other.contato)
				&& Objects.equals(id, other.id) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(n_logradouro, other.n_logradouro) && Objects.equals(referencia, other.referencia);
	}
	
}
