package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOMercado;
import br.com.minhascompras.entidades.Mercado;

@Repository("daoMercado")
public class HBMercado extends HBDAO<Mercado> implements DAOMercado {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {

		return Mercado.class;
	}

}
