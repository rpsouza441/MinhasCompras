package br.com.minhascompras.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOFabricante;
import br.com.minhascompras.entidades.Fabricante;

@Repository("daoFabricante")
public class HBFabricante extends HBDAO<Fabricante> implements DAOFabricante {

	
	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {

		return Fabricante.class;
	}

}
