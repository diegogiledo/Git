package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Electro {
	private Double intervalo;
	private Double[] vectorTiempo;
	private Double[] vectorMedicion;
	private String fecha;
	private String comentario;

	public Electro(String[] vectorLectura, Double intervalo, String comentario) {
		this.intervalo = intervalo;
		this.comentario = comentario;
		fecha();
		Double intervaloAux = 0d;
		this.vectorTiempo = new Double[vectorLectura.length];
		this.vectorMedicion = new Double[vectorLectura.length];
		for (int i = 0; i < vectorLectura.length; i++) {
			vectorTiempo[i] = intervaloAux;
			vectorMedicion[i] = Double.parseDouble(vectorLectura[i]);
			intervaloAux += intervalo;
		}
	}

	public Double getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Double intervalo) {
		this.intervalo = intervalo;
	}

	public Double[] getVectorTiempo() {
		return vectorTiempo;
	}

	public void setVectorTiempo(Double[] vectorTiempo) {
		this.vectorTiempo = vectorTiempo;
	}

	public Double[] getVectorLecturas() {
		return vectorMedicion;
	}

	public void setVectorLecturas(Double[] vectorLecturas) {
		this.vectorMedicion = vectorLecturas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	private void fecha() {
		LocalDate ahora = LocalDate.now();// Fecha actual
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		fecha = ahora.format(formateador);
	}
}
