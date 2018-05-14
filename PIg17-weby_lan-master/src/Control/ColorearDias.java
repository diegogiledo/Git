package Control;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.IDateEvaluator;

import Modelo.Constantes;

/**
 * @param Lista
 *            Fechas ECG
 * @return void (ColoresCalendario)
 * @implements IDateEvaluator Sobreescribimos los metodos de la clase JCalendar
 */
public class ColorearDias implements IDateEvaluator {
	private List<String> lista = new ArrayList<String>();

	public ColorearDias(List<String> list) {
		lista = list;
	}

	@Override
	public boolean isSpecial(Date date) {

		return false;
	}

	@Override
	public Color getSpecialForegroundColor() {
		return Color.CYAN;
	}

	@Override
	public Color getSpecialBackroundColor() {
		return Color.blue;
	}

	@Override
	public String getSpecialTooltip() {
		return "Clica para visualizar...";
	}

	@Override
	public boolean isInvalid(Date date) {
		return diaInvalido(date);
	}

	@Override
	public Color getInvalidForegroundColor() {
		return Color.black;
	}

	@Override
	public Color getInvalidBackroundColor() {
		return Color.BLACK;
	}

	@Override
	public String getInvalidTooltip() {
		return null;
	}

	private boolean diaInvalido(Date date) {
		boolean flag = true;
		Date fecha = new Date();
		for (int i = 0; i < lista.size(); i++) {

			SimpleDateFormat sp = new SimpleDateFormat(Constantes.TIPOFECHA1);
			try {
				fecha = sp.parse(lista.get(i));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (date.compareTo(fecha) == 0) {
				flag = false;
				return flag;
			}

		}

		return flag;
	}
}