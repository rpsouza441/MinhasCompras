package br.com.minhascompras.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOMercadoProduto;
import br.com.minhascompras.entidades.MercadoProduto;
import br.com.minhascompras.entidades.Tipo;

@Controller
@Scope("request")
public class MercadoProdutoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DAOMercadoProduto daoMercadoProduto;

	private Tipo tipo;

	private MercadoProduto mercadoProduto;

	private Collection<MercadoProduto> listaMP;

	private Tipo tipoEscolhido;

	public Tipo getTipoEscolhido() {
		return tipoEscolhido;
	}

	public void setTipoEscolhido(Tipo tipoEscolhido) {
		this.tipoEscolhido = tipoEscolhido;
	}

	public DAOMercadoProduto getDaoMercadoProduto() {
		return daoMercadoProduto;
	}

	public Collection<MercadoProduto> getListaMP() {
		System.out.println("get listamp");
		if (listaMP == null) {
			loadlistaMP();
		}
		return listaMP;
	}

	public Collection<MercadoProduto> showListaMPByTipo() {
		if (listaMP == null) {
			loadListaMPByTipo();
		} else {
			resetListaMP();
			loadListaMPByTipo();
		}
		return listaMP;
	}

	public Collection<MercadoProduto> showListaMPByPreco() {
		if (listaMP == null) {
			loadListaMPByPreco();
		} else {
			resetListaMP();
			loadListaMPByPreco();
		}
		return listaMP;
	}

	private void loadlistaMP() {
		listaMP = daoMercadoProduto.list(0, 100);
	}

	private void loadListaMPByPreco() {
		listaMP = daoMercadoProduto.getProdutosPorPrecoMaisBaratos();
	}

	private void loadListaMPByTipo() {
		System.out.println("buscou mercadoProduto por tipo");
		if (tipoEscolhido != null) {
			listaMP = daoMercadoProduto.getProdutosPorTipo(tipoEscolhido);
		} else {
			System.out.println("tipo vazio");
		}
	}

	public MercadoProduto getMercadoProduto() {
		if (mercadoProduto == null) {
			mercadoProduto = new MercadoProduto();
		}

		return mercadoProduto;
	}

	public void resetMercadoProduto() {
		mercadoProduto = new MercadoProduto();
	}

	public void resetListaMP() {
		listaMP = null;
	}

	public void setMercadoProduto(MercadoProduto mercadoProduto) {
		this.mercadoProduto = mercadoProduto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
