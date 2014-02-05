package br.com.minhascompras.dao;

import java.util.Collection;

import br.com.minhascompras.entidades.MercadoProduto;
import br.com.minhascompras.entidades.Tipo;

public interface DAOMercadoProduto extends DAOBase<MercadoProduto> {
	
	public Collection<MercadoProduto> getProdutosPorPrecoMaisBaratos();
	
	public Collection<MercadoProduto> getProdutosPorTipo(Tipo tipo);
	
}
