package br.com.minhascompras.dao.hibernate;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOProduto;
import br.com.minhascompras.entidades.Produto;

@Repository("daoProduto")
public class HBProduto extends HBDAO<Produto> implements DAOProduto {

	@SuppressWarnings("unchecked")
	
	public Collection<Produto> getProdutosPorPrecoMaisBaratos() {
		Query busca = getSession().createQuery(
				"from Produto p ORDER BY p.preco");
		return busca.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {
		return Produto.class;
	}

}
