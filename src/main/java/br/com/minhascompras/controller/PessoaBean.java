package br.com.minhascompras.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.minhascompras.dao.DAOPessoa;
import br.com.minhascompras.entidades.Pessoa;

@SuppressWarnings("serial")
@Controller
@Scope("request")
public class PessoaBean implements java.io.Serializable {
//comprovar se o try catch de mensagens funciona sem o development
	@Autowired
	private DAOPessoa daoPessoa;

	private Pessoa pessoa;
	private Collection<Pessoa> listaPessoa;

	public String createPessoa() {
			String retorno= null;
			
			if(daoPessoa.persistir(pessoa)){
				retorno="sucess";
			}else {
				
			}
			return retorno;
	}

	public DAOPessoa getDaoPessoa() {
		return daoPessoa;
	}

	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
		}

		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getAllPessoas() {
		if (listaPessoa == null) {
			loadPessoas();
		}

		return (List<Pessoa>) listaPessoa;
	}

	private void loadPessoas() {
		listaPessoa = daoPessoa.list(0, 100);
	}

	public void resetPessoa() {
		pessoa = new Pessoa();
	}

}
