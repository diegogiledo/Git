package model;

public class Usuario {

	public String nombre;
	public String apellido;
	/**
	 * @param nombre
	 * @param apellido
	 */
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return nombre+" "+apellido;
	}
	
	
	
	
}
