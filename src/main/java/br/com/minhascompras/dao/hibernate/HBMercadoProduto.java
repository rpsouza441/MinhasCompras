package br.com.minhascompras.dao.hibernate;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOMercadoProduto;
import br.com.minhascompras.entidades.MercadoProduto;
import br.com.minhascompras.entidades.Tipo;

@Repository("daoMercadoProduto")
public class HBMercadoProduto extends HBDAO<MercadoProduto> implements
		DAOMercadoProduto {
	@SuppressWarnings("unchecked")
	public Collection<MercadoProduto> getProdutosPorPrecoMaisBaratos() {
		String hql="FROM mercado_produto mp "
				+ "left join fetch mp.id.produto "
				+ "left join fetch mp.id.mercado "
				+ "ORDER BY mp.preco ASC";
		Query busca = getSession().createQuery(hql);
		return busca.list();
	}

	@SuppressWarnings("unchecked")
	public Collection<MercadoProduto> getProdutosPorTipo(Tipo tipo) {
		//String jpql = "select mp from MercadoProduto mp join mp.Produto.Tipo t where t.nome like :nomeTipo ORDER BY mp.preco";
		String hql="FROM mercado_produto mp "
				+ "left join fetch mp.id.produto "
				+ "left join fetch mp.id.mercado "
				+ "WHERE mp.id.produto.tipo.nome=:nomeTipo";
		Query busca = getSession().createQuery(hql);
		busca.setParameter("nomeTipo", tipo.getNome());

		return busca.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {

		return MercadoProduto.class;
	}

}
