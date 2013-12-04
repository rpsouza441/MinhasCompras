package br.com.minhascompras.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.minhascompras.annotation.RequiredField;

public class Validator {

	private List<String> emptyFields;

	public Validator() {
		emptyFields = new ArrayList<String>();
	}

	@SuppressWarnings("rawtypes")
	public boolean isEmpty(Object obj) {
		clean();
		boolean empty = false;
		Class entityClass = obj.getClass();
		Field[] fields = entityClass.getDeclaredFields();
		for (Field currentField : fields) {

			if (currentField.getAnnotation(RequiredField.class) != null) {
				try {

					Object fieldValue = getField(obj, currentField.getName());
											//Verificar se vai funcionar
					if (fieldValue == null || ((String) fieldValue).trim().equals("")) {

						empty = true;
						emptyFields.add(currentField.getName());
					}
				} catch (Exception e) {
					// do nothing yet
				}

			}
		}

		return empty;
	}

	public boolean isEmpty(String value) {
		clean();
		boolean empty = false;
		if (value == null || value.equals("")) {
			empty = true;
			emptyFields.add("Busca");
		}
		return empty;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object getField(Object obj, String fieldName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		Class entityClass = obj.getClass();

		Method method = entityClass.getMethod("get"	+ fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1));
		
		return method.invoke(obj);
	}

	public void clean() {
		emptyFields.clear();
	}

	public List<String> getEmptyFields() {
		return emptyFields;
	}
}
