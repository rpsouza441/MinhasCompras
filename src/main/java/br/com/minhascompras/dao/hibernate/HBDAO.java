package br.com.minhascompras.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.minhascompras.dao.DAOBase;
import br.com.minhascompras.util.JSFMessageUtil;
import br.com.minhascompras.util.Validator;


@Transactional(propagation=Propagation.SUPPORTS)
public abstract class HBDAO<T> implements DAOBase<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Validator validator;
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sf) {sessionFactory = sf;}
	
	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("rawtypes")
	protected abstract Class getClazz();
	
	
	public boolean persistir(T objeto) {
		boolean retorno = false;
		validator= new Validator();
		if(!validator.isEmpty(objeto)){
			getSession().saveOrUpdate(objeto);
			retorno = true;
		}else {
			List<String> emptyFields = validator.getEmptyFields();
			for (int i = 0; i < emptyFields.size(); i++) {
				displayInfoMessageToUser(emptyFields.get(i));
				System.out.println(emptyFields.get(i));
				
			}
		}
		return retorno;
		
	}
	
	public void excluir(T objeto) {
		getSession().delete(objeto);
	}
	
	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) getSession().get(getClazz(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(int offset, int max) {
		return (List<T>) getSession().createCriteria(getClazz())
						   .setMaxResults(max)
						   .setFirstResult(offset).list();
	}
	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}

	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}

	protected void closeDialog() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
}
