package br.com.minhascompras.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.minhascompras.dao.DAOFabricante;
import br.com.minhascompras.entidades.Fabricante;

@FacesConverter(forClass=br.com.minhascompras.entidades.Fabricante.class)
public class FabricanteConverter implements Converter {

	@Autowired
	private DAOFabricante daoFabricante;

	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null || string.isEmpty())
			return null;
		long id = Long.valueOf(string);

		Fabricante fabricante = daoFabricante.get(id);
		return fabricante;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		Fabricante fabricante = (Fabricante) object;
		if (fabricante == null || fabricante.getId() == 0)
			return null;

		return String.valueOf(fabricante.getId());
	}

}
