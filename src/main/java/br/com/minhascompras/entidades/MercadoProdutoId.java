package br.com.minhascompras.entidades;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class MercadoProdutoId implements java.io.Serializable{
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Mercado mercado;

	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mercado == null) ? 0 : mercado.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		MercadoProdutoId other = (MercadoProdutoId) obj;
		if (mercado == null) {
			if (other.mercado != null)
				return false;
		} else if (!mercado.equals(other.mercado))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
	

}
