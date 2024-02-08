package br.edu.ifsp.pep.converter;

import br.edu.ifsp.dao.MinistranteDAO;
import br.edu.ifsp.model.Ministrante;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("ministranteConverter")
public class MinistranteConverter implements Converter<Ministrante> {

    @Override
public Ministrante getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null || value.isEmpty()) {
        return null;
    }

    MinistranteDAO ministranteDAO = CDI.current().select(MinistranteDAO.class).get();
    
    return ministranteDAO.buscarPorId(Ministrante.class, Long.parseLong(value));
    
}


    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Ministrante ministrante) {
        if (ministrante == null) {
            return null;
        }
        return ministrante.getId().toString();
    }

}
