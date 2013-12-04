package br.com.minhascompras.entidades;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity
@Table(name = "produto")
public class Produto implements java.io.Serializable {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 128)
	private long id;

	@NotEmpty
	@RequiredField
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;

	@OneToMany(mappedBy = "id.produto", fetch = FetchType.LAZY)
	private Collection<MercadoProduto> mercadoProduto;

	@ManyToOne
	@RequiredField
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;

	@RequiredField
	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private Collection<ItemOrcamento> listaItemOrcamento;

	public Produto() {
		super();
	}

	public Produto(long id, String nome,
			Collection<MercadoProduto> mercadoProduto, Tipo tipo,
			Fabricante fabricante, Collection<ItemOrcamento> listaItemOrcamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.mercadoProduto = mercadoProduto;
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.listaItemOrcamento = listaItemOrcamento;
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

	public Collection<MercadoProduto> getMercadoProduto() {
		return mercadoProduto;
	}

	public void setMercadoProduto(Collection<MercadoProduto> mercadoProduto) {
		this.mercadoProduto = mercadoProduto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Collection<ItemOrcamento> getListaItemOrcamento() {
		return listaItemOrcamento;
	}

	public void setListaItemOrcamento(
			Collection<ItemOrcamento> listaItemOrcamento) {
		this.listaItemOrcamento = listaItemOrcamento;
	}
	
	
	
	

}
