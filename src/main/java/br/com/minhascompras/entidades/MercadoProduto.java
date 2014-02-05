package br.com.minhascompras.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity(name = "mercado_produto")
public class MercadoProduto implements java.io.Serializable {

	@EmbeddedId
	private MercadoProdutoId id;

	@NotNull
	@RequiredField
	@Column(name = "preco", nullable = false, length = 128)
	private double preco;

	public MercadoProdutoId getId() {
		return id;
	}

	public void setId(MercadoProdutoId id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
