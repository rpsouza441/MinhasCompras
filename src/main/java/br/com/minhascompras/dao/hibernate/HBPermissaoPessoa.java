package br.com.minhascompras.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOPermissaoPessoa;
import br.com.minhascompras.entidades.PermissaoPessoa;
import br.com.minhascompras.entidades.Pessoa;

@Repository("daoPermissaoPessoa")
public class HBPermissaoPessoa implements DAOPermissaoPessoa {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<PermissaoPessoa> getPermissoesPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			return new ArrayList<PermissaoPessoa>();
		}
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from PermissaoPessoa pp where pp.pessoa= ?");
		query.setEntity(0, pessoa);
		return query.list();
	}

	
	public void addRole(String role, Pessoa pessoa) {
		if (role != null && pessoa != null) {
			PermissaoPessoa permissao = new PermissaoPessoa();
			permissao.setRole(role);
			permissao.setPessoa(pessoa);
			sessionFactory.getCurrentSession().saveOrUpdate(permissao);
		}

	}

}
