package br.com.minhascompras.dao;

import java.util.Collection;

import br.com.minhascompras.entidades.Produto;

public interface DAOProduto extends DAOBase<Produto> {

	public Collection<Produto> getProdutosPorPrecoMaisBaratos();



}
