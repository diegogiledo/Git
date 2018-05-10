package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.text.WordUtils;

import Modelo.Conexion;
import Modelo.Constantes;
import Modelo.Fichero;
import Modelo.Medico;
import Modelo.Tecnico;
import Modelo.Usuario;
import Vista.VentanaAdmin;
import Vista.VentanaLogin;

public class ControladorAdmin implements ActionListener, KeyListener, MouseListener {
	private VentanaAdmin ventanaControlada;
	private ImageManipulator manipulator;
	private String genero = null;
	private List<Tecnico> lstTecnico;
	private List<Medico> lstMedico;

	public ControladorAdmin(VentanaAdmin ventanaAdmin) {
		this.ventanaControlada = ventanaAdmin;
		this.manipulator = new ImageManipulator();
		cargarTecnicos();// Accion a realizar al abrir la ventana
		cargarMedicos();
		cargarNombreAdministrador();
	}

	private void cargarNombreAdministrador() {
		JLabel lbl_Usuario = ventanaControlada.getLbl_Usuario();
		lbl_Usuario.setText("Bienvenido administrador: " + WordUtils.capitalize(ventanaControlada.getNombreUsuario()));
	}

	public void setVentanaControlada(VentanaAdmin ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		/**
		 * Acciones que se llevarán a cabo en la ventana.
		 */
		boolean actionOk = comprobarParametros(e);
		if (e.getSource().equals(ventanaControlada.getBtn_Logout())) {
			VentanaLogin vl = new VentanaLogin();
			ventanaControlada.dispose();
			vl.setVisible(true);
		}
		if (actionOk) {
			boolean agreMod = false;

			if (e.getSource().equals(ventanaControlada.getBtn_Agregar())) {
				agreMod = true;
				agregar();
			} else {
				JTable tabla = ventanaControlada.getTable();
				int seleccion = tabla.getSelectedRow();

				if (seleccion >= 0) {
					int respuesta = confirmar(e);
					if (respuesta == JOptionPane.YES_OPTION) {
						if (e.getSource().equals(ventanaControlada.getBtn_Modificar())) {
							agreMod = true;
							modificar();
						} else if (e.getSource().equals(ventanaControlada.getBtn_Eliminar())) {
							eliminar();
						}
					}
				} else {
					ventanaControlada.getLbl_Mensaje().setText("¡Escoja para eliminar!");
				}
			}

			// 1 aceptar,0 cancelar (Posicion options)
			if (agreMod) {
				limpiarCampos();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(ventanaControlada.getText_Busqueda())) {
			RowFilter<Object, Object> filtro = new RowFilter<Object, Object>() {
				public boolean include(Entry entry) {
					String id = ((String) entry.getValue(0)).toLowerCase();
					String rol = ((String) entry.getValue(1)).toLowerCase();
					String nombre = ((String) entry.getValue(2)).toLowerCase();
					String apellido = ((String) entry.getValue(3)).toLowerCase();
					String filtro = ventanaControlada.getText_Busqueda().getText().toLowerCase();
					return id.contains(filtro) || rol.contains(filtro) || nombre.contains(filtro)
							|| apellido.contains(filtro);
				}
			};

			TableRowSorter<TableModel> orden = new TableRowSorter<TableModel>(ventanaControlada.getModel());
			orden.setRowFilter(filtro);
			ventanaControlada.getTable().setRowSorter(orden);

		}

	}

	private void agregar() {
		Object[] fila = new Object[4]; // creamos un objeto de tipo array para
										// las distintas cajas
		JLabel lbl_Mensaje = ventanaControlada.getLbl_Mensaje();
		lbl_Mensaje.setText(Constantes.VACIO);
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		JTextField text_ID = ventanaControlada.getText_ID();
		fila[0] = text_ID.getText();
		fila[1] = ventanaControlada.getComboBox().getSelectedItem();
		fila[2] = ventanaControlada.getText_Nombre().getText();
		fila[3] = ventanaControlada.getText_Apellido().getText();

		((DefaultTableModel) model).addRow(fila);

		String id = text_ID.getText();
		String nombre = ventanaControlada.getText_Nombre().getText();
		Object rol = ventanaControlada.getComboBox().getSelectedItem();
		String apellidos = ventanaControlada.getText_Apellido().getText();

		Conexion c = new Conexion();
		c.agregarUsuarioBBDD(id, nombre, rol, apellidos);

	}

	public void ampliarInfo() {
		JEditorPane editorpane = ventanaControlada.getEditorPane();
		JTable tabla = ventanaControlada.getTable();
		if (tabla.getSelectedRow() != -1) {
			Usuario usuarioAux = usuarioFila();
			Usuario usuario = buscarUsuario(usuarioAux);
			if (usuario != null) {
				String provincia = Constantes.VACIO;
				String nombre = usuario.getNombre();
				String apellido = usuario.getApellido();
				String dni = usuario.getDni();
				String email = usuario.getEmail();

				// @formatter:off
				String cadena = "<font face=\"Arial\"><ul>" + "<li><b>Nombre:</b>" + nombre + "</li>"
						+ "<li><b>Apellido:</b>" + apellido + "</li>" + "<li><b>Dni:</b>" + dni + "</li>"
						+ "<li><b>Email</b>: <a href=\"mailto:" + email + "?subject=WebyLan Question\">" + email
						+ "</a></li>";
				// @formatter:on
				if (usuario instanceof Tecnico) {
					provincia = ((Tecnico) usuario).getProvincia();

					cadena += "<li><b>Provincia:</b>" + provincia + "</li>";
				} else {
					Medico medico = (Medico) usuario;
					cadena += "<li><b>Ciudad:</b>" + medico.getCiudad() + "</li>";
					cadena += "<li><b>Hospital:</b>" + medico.getHospital() + "</li>";
					cadena += "<li><b>Teléfono:</b>" + medico.getTelefono() + "</li>";
				}
				cadena += "</ul></font>";
				editorpane.setText(cadena);
			} else {
				editorpane.setText(Constantes.ERR_USUARIO);
			}
		}
	}

	private void modificar() {
		JLabel lbl_Mensaje = ventanaControlada.getLbl_Mensaje();
		lbl_Mensaje.setText(Constantes.VACIO);
		JTable tabla = ventanaControlada.getTable();
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();

		int index = tabla.getSelectedRow();
		int columnaDni = 0;
		int columnaRol = 1;
		String dni = tabla.getModel().getValueAt(index, columnaDni).toString();
		String rolViejo = tabla.getModel().getValueAt(index, columnaRol).toString();

		/*
		 * comprobacion de que los campos no esten vacios
		 */
		if (tabla.getSelectedRow() == -1) {
			if (tabla.getSelectedRowCount() == 0) {
				lbl_Mensaje.setText("Los campos estan vacios!");
			}
		} else {
			model.setValueAt(ventanaControlada.getText_ID().getText(), tabla.getSelectedRow(), 0);
			model.setValueAt(ventanaControlada.getComboBox().getSelectedItem(), tabla.getSelectedRow(), 1);
			model.setValueAt(ventanaControlada.getText_Nombre().getText(), tabla.getSelectedRow(), 2);
			model.setValueAt(ventanaControlada.getText_Apellido().getText(), tabla.getSelectedRow(), 3);

		}

		String id = ventanaControlada.getText_ID().getText();
		String nombre = ventanaControlada.getText_Nombre().getText();
		String apellidos = ventanaControlada.getText_Apellido().getText();
		String rolNuevo = ventanaControlada.getComboBox().getSelectedItem().toString();
		

		//llamamos al metodo que modifica el registro en la bbdd
		Conexion c = new Conexion();
		c.modificarUsuario(dni, id, rolViejo, rolNuevo, nombre, apellidos);

	}

	private void eliminar() {
		JLabel lbl_Mensaje = ventanaControlada.getLbl_Mensaje();
		lbl_Mensaje.setText(Constantes.VACIO);
		JTable tabla = ventanaControlada.getTable();
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();

		// lo borramos de la base de datos
		int i = tabla.getSelectedRow();
		int columnaDni = 0;
		int columnaRol = 1;
		String dni = tabla.getModel().getValueAt(i, columnaDni).toString();
		String rol = tabla.getModel().getValueAt(i, columnaRol).toString();
		Conexion c = new Conexion();
		c.eliminarUsuario(dni, rol);

		// ahora lo borramos de la tabla
		if (i >= 0) {
			model.removeRow(i);
		} else {
			lbl_Mensaje.setText("¡Escoja para eliminar!");
		}

	}

	private Usuario usuarioFila() {
		JTable tabla = ventanaControlada.getTable();
		int index = tabla.convertRowIndexToModel(tabla.getSelectedRow());// recogemos
																			// en
																			// esta
																			// variable
																			// la
																			// fila
																			// seleccionada
																			// por
																			// el
																			// usuario
		String rol = (String) tabla.getModel().getValueAt(index, 1);
		String dni = (String) tabla.getModel().getValueAt(index, 0);
		Usuario usuario;
		if (rol.equals(Constantes.ROL_MED)) {
			usuario = new Medico(dni);
		} else {
			usuario = new Tecnico(dni);
		}

		return usuario;
	}

	private Usuario buscarUsuario(Usuario usuario) {
		Usuario usuarioAux = null;
		if (usuario instanceof Tecnico) {
			int index = lstTecnico.indexOf(usuario);
			if (index >= 0) {
				usuarioAux = lstTecnico.get(index);
			}
		} else {
			int index = lstMedico.indexOf(usuario);
			if (index >= 0) {
				usuarioAux = lstMedico.get(index);
			}
		}

		return usuarioAux;
	}

	// la tabla ha recibido un click o se ha presionado una tecla
	public void fotoUsuario() {
		Usuario usuario = usuarioFila();
		Usuario usuarioAux = buscarUsuario(usuario);
		if (usuarioAux != null) {
			String sexo = usuarioAux.getSexo();

			// establecemos la foto del usuario dependiendo de si es hombre o
			// mujer
			if (sexo != null) {
				if (sexo.equals(Constantes.HOMBRE)) {
					genero = Constantes.FOTO_HOMBRE;
				} else if (sexo.equals(Constantes.MUJER)) {
					genero = Constantes.FOTO_MUJER;
				} else {
					genero = Constantes.FOTO_ABSTRACTO;
				}
			} else {
				genero = Constantes.FOTO_ABSTRACTO;
			}
			display();
		}
	}

	// A Este metodo se le llama cuando vamos a mostrar la imagen del usuario
	private void display() {
		JLabel x = new JLabel();
		x.setSize(150, 150);
		String ruta = "." + File.separator + Constantes.CARPETAIMG + File.separator + genero;
		manipulator.escalarImagen(x, ruta);
		ventanaControlada.displayJLabel(x);

	}

	private void cargarTecnicos() {
		Conexion c = new Conexion();
		lstTecnico = c.cargarTecnicosBDD();
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		for (Tecnico tecnico : lstTecnico) {
			Object[] fila = new Object[4]; // creamos un objeto de tipo array
											// para las distintas cajas

			fila[0] = tecnico.getDni();
			fila[1] = Tecnico.TECNICO;
			fila[2] = tecnico.getNombre();
			fila[3] = tecnico.getApellido();
			((DefaultTableModel) model).addRow(fila);
		}

	}

	private void cargarMedicos() {
		Conexion c = new Conexion();
		lstMedico = c.cargarMedicosBBDD();
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		for (Medico medico : lstMedico) {
			Object[] fila = new Object[4]; // creamos un objeto de tipo array
											// para las distintas cajas

			fila[0] = medico.getDni();
			fila[1] = Medico.MEDICO;
			fila[2] = medico.getNombre();
			fila[3] = medico.getApellido();
			((DefaultTableModel) model).addRow(fila);
		}

	}

	private void limpiarCampos() {
		ventanaControlada.getText_ID().setText(Constantes.VACIO);
		ventanaControlada.getText_Nombre().setText(Constantes.VACIO);
		ventanaControlada.getText_Apellido().setText(Constantes.VACIO);
	}

	private int confirmar(ActionEvent e) {
		String rol = ((String) ventanaControlada.getComboBox().getSelectedItem()).toLowerCase();
		String accion = e.getActionCommand().toLowerCase();
		String nombre = ventanaControlada.getText_Nombre().getText();
		String apellido = ventanaControlada.getText_Apellido().getText();
		String nombreCompleto = nombre + Constantes.ESPACIOB + apellido;
		String id = ventanaControlada.getText_ID().getText();
		String cadenaAccion = "¿Está seguro de que desea " + accion + " el " + rol + " con nombre " + nombreCompleto
				+ " e ID " + id + " ?";
		Object[] options = { e.getActionCommand(), "Cancelar" };
		int respuesta = JOptionPane.showOptionDialog(null, cadenaAccion, "¿Seguro?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[1]);
		return respuesta;

	}

	private boolean comprobarParametros(ActionEvent e) {
		JLabel lbl_Mensaje = ventanaControlada.getLbl_Mensaje();
		lbl_Mensaje.setText(Constantes.VACIO);
		JTextField text_ID = ventanaControlada.getText_ID();
		JTextField text_nombre = ventanaControlada.getText_Nombre();
		JTextField text_apellido = ventanaControlada.getText_Apellido();
		boolean idCorrecto = ComprobarDni.DNICorrecto(text_ID.getText());
		boolean actionOk = true;
		if (!e.getSource().equals(ventanaControlada.getBtn_Eliminar())) {
			String mensajeError = "<html><body>";
			if (text_ID.getText().equals(Constantes.VACIO) || text_nombre.getText().equals(Constantes.VACIO)
					|| text_apellido.getText().equals(Constantes.VACIO)) {
				mensajeError += "Rellena porfavor los campos restantes!<br>";
				actionOk = false;
			}
			if (!idCorrecto || text_ID.getText().length() != 9) {
				mensajeError += "\nDni Incorrecto!";
				actionOk = false;
			}
			mensajeError += "</body></html>";

			if (!mensajeError.isEmpty()) {
				lbl_Mensaje.setText(mensajeError);
			}
		}

		return actionOk;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			this.fotoUsuario();
			this.ampliarInfo();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
