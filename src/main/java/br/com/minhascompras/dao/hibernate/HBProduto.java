package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOProduto;
import br.com.minhascompras.entidades.Produto;

@Repository("daoProduto")
public class HBProduto extends HBDAO<Produto> implements DAOProduto {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {
		return Produto.class;
	}

}
