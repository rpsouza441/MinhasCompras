package br.com.minhascompras.dao;

import br.com.minhascompras.entidades.Pessoa;

public interface DAOPessoa extends DAOBase<Pessoa> {

	public Pessoa getPessoa(String login, String senha);

	public Pessoa getPessoa(String login);

}
