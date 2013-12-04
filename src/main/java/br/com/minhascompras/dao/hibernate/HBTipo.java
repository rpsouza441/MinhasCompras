package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOTipo;
import br.com.minhascompras.entidades.Tipo;

@Repository("daoTipo")
public class HBTipo extends HBDAO<Tipo> implements DAOTipo {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {
		return Tipo.class;
	}

}
