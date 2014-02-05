package br.com.minhascompras.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOItemOrcamento;
import br.com.minhascompras.dao.DAOMercadoProduto;
import br.com.minhascompras.dao.DAOOrcamento;
import br.com.minhascompras.dao.DAOProduto;
import br.com.minhascompras.dao.DAOTipo;
import br.com.minhascompras.entidades.ItemOrcamento;
import br.com.minhascompras.entidades.MercadoProduto;
import br.com.minhascompras.entidades.Orcamento;
import br.com.minhascompras.entidades.Tipo;

@SuppressWarnings("serial")
@Controller
@Scope("view")
public class OrcamentoBean implements java.io.Serializable {

	@Autowired
	private DAOProduto daoProduto;
	@Autowired
	private DAOOrcamento daoOrcamento;
	@Autowired
	private DAOItemOrcamento daoItemOrcamento;
	@Autowired
	private DAOTipo daoTipo;
	@Autowired
	private DAOMercadoProduto daoMercadoProduto;

	private Collection<Tipo> listaTipo;
	private Collection<MercadoProduto> listaMercadoProduto;
	private Collection<ItemOrcamento> listaItemOrcamento;

	private Orcamento orcamento;
	private MercadoProduto mpEscolhido;
	private ItemOrcamento itemOrcamento;

	public ItemOrcamento getItemOrcamento() {
		return itemOrcamento;
	}

	public void setItemOrcamento(ItemOrcamento itemOrcamento) {
		this.itemOrcamento = itemOrcamento;
	}

	public MercadoProduto getMpEscolhido() {
		return mpEscolhido;
	}

	public void setMpEscolhido(MercadoProduto mpEscolhido) {
		this.mpEscolhido = mpEscolhido;
	}

	public DAOProduto getDaoProduto() {
		return daoProduto;
	}

	public DAOOrcamento getDaoOrcamento() {
		return daoOrcamento;
	}

	public DAOItemOrcamento getDaoItemOrcamento() {
		return daoItemOrcamento;
	}

	public DAOTipo getDaoTipo() {
		return daoTipo;
	}

	public DAOMercadoProduto getDaoMercadoProduto() {
		return daoMercadoProduto;
	}

	public String adicionaIOrcamento() {
		itemOrcamento = new ItemOrcamento();

		itemOrcamento.setProduto(mpEscolhido.getId().getProduto());
		if (itemOrcamento.getQuantidade() == 0) {
			itemOrcamento.setQuantidade(1);
		}

		listaItemOrcamento.add(itemOrcamento);

		return "listaPrincipal";
	}

	public Collection<Tipo> getListaTipo() {
		if (listaTipo == null) {
			loadTipos();
		}
		return listaTipo;
	}

	public Collection<MercadoProduto> getListaMercadoProduto() {
		if (listaMercadoProduto == null) {
			loadMercadoProdutos();
		}

		return listaMercadoProduto;
	}

	public Orcamento getOrcamento() {
		if (orcamento == null) {
			orcamento = new Orcamento();
		}
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	private void loadTipos() {
		listaTipo = daoTipo.list(0, 100);

	}

	private void loadMercadoProdutos() {
		listaMercadoProduto = daoMercadoProduto.list(0, 100);
	}

	public void resetOrcamento() {
		orcamento = new Orcamento();
	}

}
