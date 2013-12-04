package br.com.minhascompras.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity
@Table(name = "fabricante")
public class Fabricante extends BaseEntity implements java.io.Serializable {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 128)
	private long id;

	@NotEmpty
	@RequiredField
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;

	@NotNull
	@RequiredField
	@Column(name = "nivel_Confianca", nullable = false, length = 128)
	private int nivelConfianca;

	@OneToMany(mappedBy = "fabricante")
	private Collection<Produto> produtos;

	public Fabricante(long id, String nome, int nivelConfianca,
			Collection<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.nivelConfianca = nivelConfianca;
		this.produtos = produtos;
	}

	public Fabricante() {
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

	public int getNivelConfianca() {
		return nivelConfianca;
	}

	public void setNivelConfianca(int nivelConfianca) {
		this.nivelConfianca = nivelConfianca;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
