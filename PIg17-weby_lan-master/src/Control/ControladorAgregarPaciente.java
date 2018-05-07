package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Modelo.Constantes;
import Modelo.Paciente;
import Vista.VentanaAgregarPaciente;

public class ControladorAgregarPaciente implements ActionListener {
	private VentanaAgregarPaciente ventanaControlada;

	public ControladorAgregarPaciente(VentanaAgregarPaciente ventanaAgregarPaciente) {
		this.ventanaControlada = ventanaAgregarPaciente;
	}

	public void setVentanaControlada(VentanaAgregarPaciente ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * Acciones que se llevarán a cabo en la ventana.
		 */
		if (e.getSource().equals(ventanaControlada.getBtn_Agregar())) {
			Paciente paciente = comprobarParametros();
			if (paciente != null) {
				String accion = e.getActionCommand().toLowerCase();
				String nombre = ventanaControlada.getTxt_Nombre().getText();
				String apellido = ventanaControlada.getTxt_Apellido().getText();
				String nombreCompleto = nombre + Constantes.ESPACIOB + apellido;
				String id = ventanaControlada.getTxt_DNI().getText();
				String cadenaAccion = "¿Está seguro de que desea " + accion + " al  paciente con nombre "
						+ nombreCompleto + " e ID " + id + " ?";

				Object[] options = { e.getActionCommand(), "Cancelar" };
				int respuesta = JOptionPane.showOptionDialog(null, cadenaAccion, "¿Seguro?", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[1]);
				// 1 aceptar,0 cancelar (Posicion options)
				if (respuesta == JOptionPane.YES_OPTION) {

					ControladorMedico controladorMed = ventanaControlada.getControladorMed();
					controladorMed.agregar(paciente);

					ventanaControlada.dispose();
				}
			}
		} else if (e.getSource().equals(ventanaControlada.getBtn_Cancelar())) {
			ventanaControlada.dispose();
		}
	}

//@formatter:off
	private Paciente comprobarParametros() {
		Paciente paciente = null;
		JLabel lbl_Mensaje = ventanaControlada.getLbl_Mensaje();
		try {
			lbl_Mensaje.setText(Constantes.VACIO);
			//Nombre
			JTextField text_nombre = ventanaControlada.getTxt_Nombre();
			String nombre = text_nombre.getText();
			//Apellido
			JTextField text_apellido = ventanaControlada.getTxt_Apellido();
			String apellidos = text_apellido.getText();
			//DNI
			JTextField text_DNI = ventanaControlada.getTxt_DNI();
			String dni = text_DNI.getText();
			//DateChooser
			JDateChooser dateChooser = ventanaControlada.getDateChooser();
			Date fecha = dateChooser.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fechaNacimiento = sdf.format(fecha);
			//Sexo
			JComboBox<String> combSexo = ventanaControlada.getCb_Sexo();
			String sexo = (String) combSexo.getSelectedItem();
			//Altura
			JComboBox<String> combAltura = ventanaControlada.getCb_Altura();
			int altura = Integer.parseInt((String) combAltura.getSelectedItem());
			//Kg
			JComboBox<String> combKg = ventanaControlada.getCb_Kg();
			int kg = Integer.parseInt((String)combKg.getSelectedItem());
			//Gramos
			JComboBox<String> combGramos = ventanaControlada.getCb_Gramos();
			int gramos = Integer.parseInt((String) combGramos.getSelectedItem());
			//Comunidad
			JTextField text_comunidad = ventanaControlada.getTxt_Comunidad();
			String comunidad = text_comunidad.getText();
			//Provincia
			JTextField text_provincia = ventanaControlada.getTxt_Provincias();
			String provincia = text_provincia.getText();
			//Municipio
			JTextField text_municipio = ventanaControlada.getTxt_Municipio();
			String municipio = text_municipio.getText();
			//Direccion
			JTextField text_direccion = ventanaControlada.getTxt_Direccion();
			String direccion = text_direccion.getText();
			//CP
			JTextField text_cp = ventanaControlada.getTxt_CP();
			String cp = text_cp.getText();
			//Telefono
			JTextField text_telefono = ventanaControlada.getTxt_Tel();
			String telefono = text_telefono.getText();
			//Email
			JTextField text_email = ventanaControlada.getTxt_Email();
			String email = text_email.getText();
			boolean idCorrecto = ComprobarDni.DNICorrecto(text_DNI.getText());
			boolean actionOk = true;
			if (nombre.equals(Constantes.VACIO) || apellidos.equals(Constantes.VACIO) || dni.equals(Constantes.VACIO)
					|| sexo == null || comunidad.equals(Constantes.VACIO)|| provincia.equals(Constantes.VACIO)
					|| municipio.equals(Constantes.VACIO)|| direccion.equals(Constantes.VACIO)|| cp.equals(Constantes.VACIO)
					|| telefono.equals(Constantes.VACIO) || email.equals(Constantes.VACIO)) {
				lbl_Mensaje.setText("Rellena porfavor los campos restantes!");
				actionOk = false;
			}
			if (!idCorrecto || text_DNI.getText().length() != 9) {
				lbl_Mensaje.setText("Dni Incorrecto!");
				actionOk = false;
			}
			
			if(actionOk) {
				paciente = new Paciente(dni, nombre, apellidos, email, sexo, fechaNacimiento, altura, kg, gramos, Constantes.VACIO, comunidad, provincia, municipio, direccion, Constantes.VACIO, cp, telefono, new ArrayList<String>());
			}
		}catch(Exception e) {
			System.err.println("Error al rellenar los datos de usuario");
			lbl_Mensaje.setText("Rellena porfavor los campos restantes!");
		}

		return paciente;
	}
//@formatter:on

}
