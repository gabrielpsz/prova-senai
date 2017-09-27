package visao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Sala;
import controle.ReservaControle;

@FacesConverter(value = "SalaConverter", forClass=Sala.class)
public class SalaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Sala sala = null;
		if (value != null) {
			try {
				ReservaControle reservaControle = new ReservaControle();
				sala = reservaControle.buscarSalaPorId(Long.parseLong(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sala;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value.getClass().equals(Sala.class)) {
			return String.valueOf(((Sala) value).getIdSala());
		}
		return null;
	}

}
