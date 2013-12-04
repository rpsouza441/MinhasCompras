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

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity
@Table(name = "mercado")
public class Mercado implements java.io.Serializable {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private long id;

	@NotEmpty
	@RequiredField
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;

	@Embedded
	private Endereco endereco = new Endereco();

	@OneToMany(mappedBy = "id.mercado", fetch = FetchType.LAZY)
	private Collection<MercadoProduto> mercadoProduto;

	public Mercado() {
		super();
	}

	public Mercado(long id, String nome, Endereco endereco,
			Collection<MercadoProduto> mercadoProduto) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.mercadoProduto = mercadoProduto;
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

	public Collection<MercadoProduto> getMercadoProduto() {
		return mercadoProduto;
	}

	public void setMercadoProduto(Collection<MercadoProduto> mercadoProduto) {
		this.mercadoProduto = mercadoProduto;
	}

}
