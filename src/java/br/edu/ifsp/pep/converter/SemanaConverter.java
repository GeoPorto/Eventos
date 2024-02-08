package br.edu.ifsp.pep.converter;

import br.edu.ifsp.dao.SemanaDAO;
import br.edu.ifsp.model.Semana;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("semanaConverter")
public class SemanaConverter implements Converter<Semana> {

    @Override
public Semana getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null || value.isEmpty()) {
        return null;
    }

    SemanaDAO semanaDAO = CDI.current().select(SemanaDAO.class).get();
    
    return semanaDAO.buscarPorId(Semana.class, Long.parseLong(value));
    
}


    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Semana semana) {
        if (semana == null) {
            return null;
        }
        return semana.getId().toString();
    }

}
