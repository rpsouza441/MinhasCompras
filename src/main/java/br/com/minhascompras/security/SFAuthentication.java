package br.com.minhascompras.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import br.com.minhascompras.entidades.PermissaoPessoa;
import br.com.minhascompras.entidades.Pessoa;

@SuppressWarnings("serial")
public class SFAuthentication implements Authentication {
	private final Pessoa pessoa;
	private boolean autenticado;

	public SFAuthentication(Pessoa pessoa, List<PermissaoPessoa> permissoes) {
		this.pessoa = pessoa;
		this.permissoes = permissoes;

	}

	public String getName() {

		return pessoa != null ? pessoa.getNome() : null;
	}

	private List<PermissaoPessoa> permissoes;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	public Object getCredentials() {

		return pessoa != null ? pessoa.getHashSenha() : null;
	}

	public Object getDetails() {
		return pessoa;
	}

	public Object getPrincipal() {

		return pessoa != null ? pessoa.getLogin() : null;
	}

	public boolean isAuthenticated() {
		return this.autenticado;
	}

	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		this.autenticado = isAuthenticated();
	}

}
