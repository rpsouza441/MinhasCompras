package br.com.minhascompras.dao;

import java.util.List;

public interface DAOBase<T> {
	
	public List<T> list(int offset, int max);
	
	public boolean persistir(T objeto);
	
	public void excluir(T objeto);
	
	public T get(Long id);
	
}
