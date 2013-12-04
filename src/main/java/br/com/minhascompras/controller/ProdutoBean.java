package br.com.minhascompras.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOFabricante;
import br.com.minhascompras.dao.DAOProduto;
import br.com.minhascompras.dao.DAOTipo;
import br.com.minhascompras.entidades.Fabricante;
import br.com.minhascompras.entidades.Produto;
import br.com.minhascompras.entidades.Tipo;

@Controller
@Scope("request")
public class ProdutoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// comprovar se o try catch de mensagens funciona sem o development
	@Autowired
	private DAOProduto daoProduto;
	@Autowired
	private DAOTipo daoTipo;
	@Autowired
	private DAOFabricante daoFabricante;

	private Produto produto;
	private Collection<Produto> listaProduto;
	private Collection<Fabricante> listaFabricante;
	private Collection<Tipo> listaTipo;

	public String createProduto() {
		String retorno = null;

		if (produto.getFabricante() != null) {
			System.out.println(produto.getFabricante().getNome());
		}

		if (daoProduto.persistir(produto)) {
			retorno = "sucess";
		} else {

		}
		return retorno;
	}

	public DAOProduto getDaoProduto() {
		return daoProduto;
	}

	public DAOTipo getDaoTipo() {
		return daoTipo;
	}

	public DAOFabricante getDaoFabricante() {
		return daoFabricante;
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}

		return produto;
	}

	public void resetProduto() {
		produto = new Produto();
	}

	public void setProduto(Produto Produto) {
		this.produto = Produto;
	}

	public List<Produto> getProdutos() {
		if (listaProduto == null) {
			loadProdutos();
		}

		return (List<Produto>) listaProduto;
	}

	private void loadProdutos() {
		listaProduto = daoProduto.list(0, 100);
	}

	public List<Tipo> completeTipo(String arg) {
		System.out.println("dentro de completeTipo");
		loadTipos();
		List<Tipo> sugestoes = new ArrayList<Tipo>();
		for (Tipo tipo : listaTipo) {
			if (tipo.getNome().toLowerCase().contains(arg.toLowerCase())) {
				sugestoes.add(tipo);
			}
		}

		return sugestoes;

	}

	public List<Fabricante> completeFabricante(String arg) {
		System.out.println("dentro de completeFabricante");
		loadFabricantes();
		List<Fabricante> sugestoes = new ArrayList<Fabricante>();

		for (Fabricante fabricante : listaFabricante) {
			if (fabricante.getNome().toLowerCase().contains(arg.toLowerCase())) {
				sugestoes.add(fabricante);
			}
		}


		return sugestoes;

	}

	public List<Tipo> getTipos() {
		System.out.println("buscou tipos");
		if (listaTipo == null) {
			loadTipos();
		}
		return (List<Tipo>) listaTipo;
	}

	private void loadTipos() {
		listaTipo = daoTipo.list(0, 100);
	}

	public List<Fabricante> getFabricantes() {
		System.out.println("buscou fabricantes");
		if (listaFabricante == null) {
			loadFabricantes();
		}
		return (List<Fabricante>) listaFabricante;
	}

	private void loadFabricantes() {
		listaFabricante = daoFabricante.list(0, 100);
	}

}
