package Modelo;

public class Tecnico extends Usuario {
	public static final String TECNICO = Constantes.ROL_TEC;
	private String provincia;

	public Tecnico(String dni) {
		super(dni);
	}

	public Tecnico(String nombreUsuario, String contrasena, String nombre, String apellido, String dni, String email,
			String provincia, String sexo) {
		super(nombreUsuario, contrasena, TECNICO, nombre, apellido, dni, email, sexo);
		this.provincia = provincia;
	}

	public Tecnico(String nombreUsuario, String nombre, String apellido, String dni, String email, String provincia,
			String sexo) {
		super(nombreUsuario, Constantes.VACIO, TECNICO, nombre, apellido, dni, email, sexo);
		this.provincia = provincia;
	}

	
	

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
