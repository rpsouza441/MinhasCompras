package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOItemOrcamento;
import br.com.minhascompras.entidades.ItemOrcamento;

@Repository("daoItemOrcamento")
public class HBItemOcamento extends HBDAO<ItemOrcamento> implements DAOItemOrcamento {

	
	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {

		return ItemOrcamento.class;
	}

}
