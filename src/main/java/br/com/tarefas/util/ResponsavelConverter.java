package br.com.tarefas.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.faces.convert.FacesConverter;

import br.com.tarefas.dao.ResponsavelDAO;
import br.com.tarefas.models.Responsavel;

@FacesConverter("responsavelConverter")
public class ResponsavelConverter implements Converter {
	
	ResponsavelDAO responsavelDAO = new ResponsavelDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Responsavel associado = responsavelDAO.findById(Long.parseLong(value));
		return associado;
	}

	@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
		Responsavel associado = (Responsavel) value;
		return String.valueOf(associado.getId());
	}
	

}
