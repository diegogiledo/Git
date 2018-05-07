package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
	public final static String PACIENTE = "Paciente";
	private String fechaNacimiento;
	private int altura;
	private int kg;
	private int gramos;
	private int edad;
	private String comentario;
	private String comunidad;
	private String provincia;
	private String municipio;
	private String calle;
	private String estado;
	private String cp;
	private String telefono;
	private List<String> electros;

	public Paciente(String dni, String nombre, String apellido, String email, String sexo, String fechaNacimiento,
			int altura, int kg, int gramos, String comentario, String comunidad, String provincia, String municipio,
			String calle, String estado, String cp, String telefono, List<String> electros) {
		super(null, null, null, nombre, apellido, dni, email, sexo);
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.kg = kg;
		this.gramos = gramos;
		this.edad = edad();
		this.comentario = comentario;
		this.comunidad = comunidad;
		this.provincia = provincia;
		this.municipio = municipio;
		this.calle = calle;
		this.estado = estado;
		this.cp = cp;
		this.telefono = telefono;
		this.electros = electros;
	}

	public Paciente(String nombreUsuario, String contrasena, String tipoUsuario, String nombre, String apellido,
			String dni, String email, String sexo) {
		super(nombreUsuario, contrasena, tipoUsuario, nombre, apellido, dni, email, sexo);
		this.electros = new ArrayList<String>();
	}

	public Paciente(String dni) {
		super(dni);
		this.electros = new ArrayList<String>();
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public int getGramos() {
		return gramos;
	}

	public void setGramos(int gramos) {
		this.gramos = gramos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<String> getElectros() {
		return electros;
	}

	public void setElectros(List<String> electros) {
		this.electros = electros;
	}

	public int edad() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);// Fecha de nacimiento
		LocalDate ahora = LocalDate.now();// Fecha actual

		Period periodo = Period.between(fechaNac, ahora);// Diferencia entre fecha nacimiento y fecha actual
		return periodo.getYears();
	}

}
