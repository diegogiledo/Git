package Modelo;

public class Usuario {

	private String nombreUsuario;
	private String contrasena;
	private String tipoUsuario;
	private String sexo;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;

	public Usuario(String dni) {
		this.dni = dni;
	}

	public Usuario(String nombreUsuario, String contrasena, String tipoUsuario, String nombre, String apellido,
			String dni, String email, String sexo) {

		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.sexo = sexo;
	}

	public Usuario(String dni2, String rolMed, String nombre2, String apellidos, String email2, String ciudad,
			String hospital, int telefono) {
		// TODO Auto-generated constructor stub
	}

	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj instanceof Usuario) {
			Usuario usuario = (Usuario) obj;
			equal = (usuario.dni == null && dni == null) || (dni != null && dni.equalsIgnoreCase(usuario.dni));// Un usuario = otro si tienen mismo dni
			equal |= (nombreUsuario != null && nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario));
		}
		return equal;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
