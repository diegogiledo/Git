package Control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Conexion;
import Modelo.Fichero;
import Vista.VentanaAdmin;
import Vista.VentanaCompararEcg;
import Vista.VentanaLogin;
import Vista.VentanaMedico;
import Vista.VentanaTecnico;

public class ControladorLogin implements ActionListener, KeyListener {
	private VentanaLogin ventanaControlada;

	public void setVentanaControlada(VentanaLogin ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		aceptarVentana();
		// aceptarVentanita();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			aceptarVentana();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void aceptarVentana() {
		String usuario = ventanaControlada.cajaUsuario.getText();
		
		char caracteres[] = ventanaControlada.cajaContrasena.getPassword();

		// conectamos con la BBDD
		Conexion c = new Conexion();
		String auxPass = String.valueOf(caracteres);
		Boolean usuarioCorrecto = c.comprobarUsuario(usuario, auxPass);
		String rol = c.usuarioCorrecto(usuario);

		if (usuarioCorrecto == true) {

			if (rol != null) {
				// Abre ventana según el tercer parámetro del txt
				switch (rol) {
				case "medico":
					ventanaControlada.frame.dispose();
					VentanaMedico frameMedico = new VentanaMedico(usuario);
					frameMedico.setVisible(true);
					break;
				case "tecnico":
					// Abre ventana Paciente
					ventanaControlada.frame.dispose();
					VentanaTecnico frameTecnico = new VentanaTecnico(usuario);
					frameTecnico.setVisible(true);

					break;
				case "admin":
					// Abre ventana Administrador
					ventanaControlada.frame.dispose();
					VentanaAdmin frameAdmin = new VentanaAdmin(usuario);
					frameAdmin.setVisible(true);
					break;
				default:
					// En el caso de que no sea ninguno de los dos usuarios.
					Object frame1 = null; // crea un objeto ventana
					JOptionPane.showMessageDialog((Component) frame1, "Tipo de usuario desconocido.", "Error",
							JOptionPane.ERROR_MESSAGE); // sale una ventana de
														// diálogo para alertar
														// de error tipo usuario
				}
			} else { // si el resultado de la comparación es falso
				Object frame = null; // crea un objeto ventana
				JOptionPane.showMessageDialog((Component) frame, "El usuario y/o la contraseña es incorrecta.", "Error",
						JOptionPane.ERROR_MESSAGE); // sale una ventana de
													// diálogo para alertar
													// error por
													// usuario/contraseña mal
			}

		} else {
			
		}

	}
}
