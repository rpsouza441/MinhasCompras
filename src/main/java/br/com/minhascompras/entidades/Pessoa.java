package br.com.minhascompras.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.minhascompras.annotation.RequiredField;

@Entity
@Table(name = "pessoa")
public class Pessoa implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 128)
	private long id;

	@NotEmpty
	@Column(name = "nome", nullable = false, length = 128)
	@RequiredField
	private String nome;

	@Embedded
	private Endereco endereco = new Endereco();

	@Size(min = 6, max = 12, message = "login muito curto ou muito longo")
	@Column(name = "login", nullable = false, unique = true, length = 64)
	@RequiredField
	private String login;

	private transient String senha;

	@Column(name = "hashSenha", nullable = false, length = 128)
	@RequiredField
	private String hashSenha;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private Collection<Orcamento> listaOrcamento;

	public Pessoa(long id, String nome, Endereco endereco, String login,
			String senha, String hashSenha, Collection<Orcamento> listaOrcamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
		this.hashSenha = hashSenha;
		this.listaOrcamento = listaOrcamento;
	}

	public Collection<Orcamento> getListaOrcamento() {
		return listaOrcamento;
	}

	public void setListaOrcamento(Collection<Orcamento> listaOrcamento) {
		this.listaOrcamento = listaOrcamento;
	}

	public Pessoa() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		setHashSenha(org.apache.commons.codec.digest.DigestUtils
				.sha256Hex(senha));
		this.senha = senha;
	}

}
