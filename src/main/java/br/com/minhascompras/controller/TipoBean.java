package br.com.minhascompras.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOTipo;
import br.com.minhascompras.entidades.Tipo;

@SuppressWarnings("serial")
@Controller
@Scope("request")
public class TipoBean implements java.io.Serializable {
//comprovar se o try catch de mensagens funciona sem o development
	@Autowired
	private DAOTipo daoTipo;

	private Tipo tipo;
	private Collection<Tipo> listaTipo;

	public String createTipo() {
			String retorno= null;
			
			if(daoTipo.persistir(tipo)){
				retorno="sucess";
			}else {
				
			}
			return retorno;
	}

	public DAOTipo getDaoTipo() {
		return daoTipo;
	}

	public Tipo getTipo() {
		if (tipo == null) {
			tipo = new Tipo();
		}

		return tipo;
	}

	public void setTipo(Tipo Tipo) {
		this.tipo = Tipo;
	}

	public List<Tipo> getAllTipos() {
		if (listaTipo == null) {
			loadTipos();
		}

		return (List<Tipo>) listaTipo;
	}

	private void loadTipos() {
		listaTipo = daoTipo.list(0, 100);
	}

	public void resetTipo() {
		tipo = new Tipo();
	}

}
