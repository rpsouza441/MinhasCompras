package br.com.minhascompras.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity
@Table(name = "item_orcamento")
public class ItemOrcamento implements java.io.Serializable {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 128)
	private long id;

	@NotEmpty
	@RequiredField
	@Column(name = "quantidade", nullable = false, length = 128)
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;

	public ItemOrcamento(long id, int quantidade, Produto produto,
			Orcamento orcamento) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.orcamento = orcamento;
	}

	public ItemOrcamento() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
