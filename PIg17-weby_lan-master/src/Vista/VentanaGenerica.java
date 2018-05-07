package Vista;

import javax.swing.JFrame;

public abstract class VentanaGenerica extends JFrame {
	private static final long serialVersionUID = 6157290100170358126L;
	private String nombreUsuario;

	public VentanaGenerica(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.crearVentana();
	}

	protected abstract void crearVentana();

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
