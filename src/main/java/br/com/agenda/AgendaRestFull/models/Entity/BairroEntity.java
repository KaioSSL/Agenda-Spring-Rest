package br.com.agenda.AgendaRestFull.models.Entity;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "AG_BAIRRO")
@JsonIdentityInfo(scope = BairroEntity.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BairroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 90, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "bairro")
	private List<EnderecoEntity> enderecos;
	
	@ManyToOne
	private CidadeEntity cidade;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<EnderecoEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void addEndereco(EnderecoEntity endereco) {
		this.enderecos.add(endereco);
	}
	
	public void removeEndereco(EnderecoEntity endereco) {
		this.enderecos.remove(endereco);
	}

	public CidadeEntity getCidade() {
		return cidade;
	}

	public void setCidade(CidadeEntity cidade) {
		this.cidade = cidade;
	}

	public BairroEntity(String nome, String descricao, List<EnderecoEntity> enderecos, CidadeEntity cidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.enderecos = enderecos;
		this.cidade = cidade;
	}

	public BairroEntity(String nome, String descricao, CidadeEntity cidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.cidade = cidade;
	}

	public BairroEntity() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, descricao, enderecos, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BairroEntity other = (BairroEntity) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(enderecos, other.enderecos) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
}
