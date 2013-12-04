package br.com.minhascompras.dao.hibernate;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.minhascompras.dao.DAOPessoa;
import br.com.minhascompras.entidades.Pessoa;

@Repository("daoPessoa")
public class HBPessoa extends HBDAO<Pessoa> implements DAOPessoa {

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Pessoa.class;
	}

	public Pessoa getPessoa(String login, String senha) {
		Query query = getSession().createQuery(
				"from Pessoa p where p.login = ? and p.hashSenha = ?");
		query.setString(0, login);
		query.setString(1, DigestUtils.sha256Hex(senha));
		return (Pessoa) query.uniqueResult();
	}

	public Pessoa getPessoa(String login) {
		Query query = getSession().createQuery(
				"from Pessoa p where p.login = ?");
		query.setString(0, login);
		return (Pessoa) query.uniqueResult();
	}
}
