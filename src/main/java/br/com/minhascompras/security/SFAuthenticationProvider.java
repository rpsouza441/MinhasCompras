package br.com.minhascompras.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import br.com.minhascompras.dao.DAOPermissaoPessoa;
import br.com.minhascompras.dao.DAOPessoa;
import br.com.minhascompras.entidades.PermissaoPessoa;
import br.com.minhascompras.entidades.Pessoa;
/**
 * Exemplo de authentication provider
 * @author kicolobo
 */

public class SFAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private DAOPessoa daoPessoa;
	
	public DAOPessoa getDaoPessoa(){ return daoPessoa;}
	public void setDaoPessoa(DAOPessoa dao){daoPessoa=dao;}
	
	@Autowired
	private DAOPermissaoPessoa daoPermissaoPessoa;
	
	public DAOPermissaoPessoa getDaoPermissaoPessoa(){ return daoPermissaoPessoa;}
	public void setDaoPermissao(DAOPermissaoPessoa dao){ daoPermissaoPessoa= dao;}
	

	public Authentication authenticate(Authentication auth)	throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		String username = token.getName();
		String senha    = token.getCredentials() != null ? token.getCredentials().toString() : null;
		Pessoa pessoa= getDaoPessoa().getPessoa(username, senha);
		if (pessoa == null) {
			return null;
		}
		List<PermissaoPessoa> permissoes = getDaoPermissaoPessoa().getPermissoesPessoa(pessoa);
		SFAuthentication resultado = new SFAuthentication(pessoa, permissoes);
		resultado.setAuthenticated(pessoa != null);
		return resultado;
	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	

}
