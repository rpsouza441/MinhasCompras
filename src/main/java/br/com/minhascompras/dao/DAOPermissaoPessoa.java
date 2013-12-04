package br.com.minhascompras.dao;

import java.util.List;

import br.com.minhascompras.entidades.PermissaoPessoa;
import br.com.minhascompras.entidades.Pessoa;

public interface DAOPermissaoPessoa {
	
	public List<PermissaoPessoa> getPermissoesPessoa(Pessoa pessoa);
	
	public void addRole(String role, Pessoa pessoa);

}
