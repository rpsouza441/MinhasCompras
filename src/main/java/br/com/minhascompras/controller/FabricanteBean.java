package br.com.minhascompras.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOFabricante;
import br.com.minhascompras.entidades.Fabricante;

@SuppressWarnings("serial")
@Controller
@Scope("request")
public class FabricanteBean implements java.io.Serializable {
//comprovar se o try catch de mensagens funciona sem o development
	@Autowired
	private DAOFabricante daoFabricante;

	private Fabricante fabricante;
	private Collection<Fabricante> listaFabricante;

	public String createFabricante() {
			String retorno= null;
			
			if(daoFabricante.persistir(fabricante)){
				retorno="sucess";
			}else {
				
			}
			return retorno;
	}

	public DAOFabricante getDaoFabricante() {
		return daoFabricante;
	}

	public Fabricante getFabricante() {
		if (fabricante == null) {
			fabricante = new Fabricante();
		}

		return fabricante;
	}

	public void setFabricante(Fabricante Fabricante) {
		this.fabricante = Fabricante;
	}

	public List<Fabricante> getAllFabricantes() {
		if (listaFabricante == null) {
			loadFabricantes();
		}

		return (List<Fabricante>) listaFabricante;
	}

	private void loadFabricantes() {
		listaFabricante = daoFabricante.list(0, 100);
	}

	public void resetFabricante() {
		fabricante = new Fabricante();
	}

}
