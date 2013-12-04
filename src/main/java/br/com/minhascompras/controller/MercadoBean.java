package br.com.minhascompras.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOMercado;
import br.com.minhascompras.entidades.Mercado;

@SuppressWarnings("serial")
@Controller
@Scope("request")
public class MercadoBean implements java.io.Serializable {
//comprovar se o try catch de mensagens funciona sem o development
	@Autowired
	private DAOMercado daoMercado;

	private Mercado mercado;
	private Collection<Mercado> listaMercado;

	public String createMercado() {
			String retorno= null;
			
			if(daoMercado.persistir(mercado)){
				retorno="sucess";
			}else {
				
			}
			return retorno;
	}

	public DAOMercado getDaoMercado() {
		return daoMercado;
	}

	public Mercado getMercado() {
		if (mercado == null) {
			mercado = new Mercado();
		}

		return mercado;
	}

	public void setMercado(Mercado Mercado) {
		this.mercado = Mercado;
	}

	public List<Mercado> getAllMercados() {
		if (listaMercado == null) {
			loadMercados();
		}

		return (List<Mercado>) listaMercado;
	}

	private void loadMercados() {
		listaMercado = daoMercado.list(0, 100);
	}

	public void resetMercado() {
		mercado = new Mercado();
	}

}
