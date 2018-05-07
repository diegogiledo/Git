package Modelo;

import java.util.List;

public class Medico extends Usuario {
	public final static String MEDICO = Constantes.ROL_MED;
	private String hospital;
	private String ciudad;
	private String telefono;
	private List<Paciente> pacientes;

	public Medico(String dni) {
		super(dni);
	}

	public Medico(String nombreUsuario, String nombre, String apellido, String dni, String hospital, String ciudad,
			String telefono, String email, String sexo, List<Paciente> pacientes) {
		super(null, null, null, nombre, apellido, dni, email, sexo);
		this.hospital = hospital;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.pacientes = pacientes;
	}

	public Medico(String nombreUsuario, String contrasena, String tipoUsuario, String nombre, String apellido,
			String dni, String email, String hospital, String ciudad, String telefono, String sexo,
			List<Paciente> pacientes) {
		super(nombreUsuario, contrasena, tipoUsuario, nombre, apellido, dni, email, sexo);
		this.hospital = hospital;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.pacientes = pacientes;
	}

	public Medico(String dni, String rol, String nombre, String apellidos, String email, String ciudad, String hospital,
			int telefono) {
		super(dni, Constantes.ROL_MED, nombre, apellidos, email, ciudad, hospital, telefono);
		// TODO Auto-generated constructor stub
	}

	public Medico(String nombreUsuario, String tipoUsuario, String nombre, String apellido, String dni, String email,
			String hospital, String ciudad, int telefono, String sexo) {
		super(nombreUsuario, "contrasena", tipoUsuario, nombre, apellido, dni, email, sexo);
		this.hospital = hospital;
		this.ciudad = ciudad;
		String tlf = String.valueOf(telefono);
		this.telefono = tlf;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
