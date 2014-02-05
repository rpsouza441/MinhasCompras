package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOOrcamento;
import br.com.minhascompras.entidades.Orcamento;

@Repository("daoOcamento")
public class HBOrcamento extends HBDAO<Orcamento> implements DAOOrcamento {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {

		return Orcamento.class;
	}

}
