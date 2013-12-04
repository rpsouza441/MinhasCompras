package br.com.minhascompras.entidades;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "orcamento")
public class Orcamento implements java.io.Serializable {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 128)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@OneToMany(mappedBy = "orcamento", fetch = FetchType.LAZY)
	private Collection<ItemOrcamento> listaItemOrcamento;

	public Orcamento() {
		super();
	}

	public Orcamento(long id, Date data, Pessoa pessoa,
			Collection<ItemOrcamento> listaItemOrcamento) {
		super();
		this.id = id;
		this.data = data;
		this.pessoa = pessoa;
		this.listaItemOrcamento = listaItemOrcamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Collection<ItemOrcamento> getListaItemOrcamento() {
		return listaItemOrcamento;
	}

	public void setListaItemOrcamento(
			Collection<ItemOrcamento> listaItemOrcamento) {
		this.listaItemOrcamento = listaItemOrcamento;
	}

}
