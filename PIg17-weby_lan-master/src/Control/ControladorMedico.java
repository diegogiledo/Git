package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.text.WordUtils;

import Modelo.Conexion;
import Modelo.Constantes;
import Modelo.Fichero;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Usuario;
import Vista.VentanaAgregarPaciente;
import Vista.VentanaLogin;
import Vista.VentanaMedico;
import Vista.VentanaMedico2;

public class ControladorMedico implements ActionListener, KeyListener, MouseListener {
	private VentanaMedico ventanaControlada;
	private List<Paciente> lstPacientes;
	private ImageManipulator manipulator;
	private String genero = null;
	private Paciente pacienteActual;

	public ControladorMedico(VentanaMedico ventanaMedico) {
		this.ventanaControlada = ventanaMedico;
		this.manipulator = new ImageManipulator();
		cargarNombreMedico();
		cargarPacientesMedico();// Accion a realizar al abrir la ventana
	}

	public void setVentanaControlada(VentanaMedico ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	private void cargarNombreMedico() {
		JLabel lbl_Usuario = ventanaControlada.getLbl_Usuario();
		lbl_Usuario.setText("Bienvenido medico: " + WordUtils.capitalize(ventanaControlada.getNombreUsuario()));
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventanaControlada.getBtn_Logout())) {
			VentanaLogin vl = new VentanaLogin();
			ventanaControlada.dispose();
			vl.setVisible(true);
		}
		if (e.getSource().equals(ventanaControlada.getBtn_Agregar())) {
			VentanaAgregarPaciente vap = new VentanaAgregarPaciente(this);
			vap.setVisible(true);
		} else if (e.getSource().equals(ventanaControlada.getBtn_Modificar())) {
			if (pacienteActual != null) {
				VentanaAgregarPaciente vap = new VentanaAgregarPaciente(this);
				try {
					vap.rellenarDatos(pacienteActual);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				vap.setVisible(true);
			} else {
				JLabel error = ventanaControlada.getLbl_Mensaje();
				error.setText(Constantes.ERRORPACIENTE);
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

			TableRowSorter<TableModel> orden = new TableRowSorter<TableModel>(ventanaControlada.getModelo());
			orden.setRowFilter(filtro);
			ventanaControlada.getTable().setRowSorter(orden);

		}

	}

	private Usuario usuarioFila() {
		JTable tabla = ventanaControlada.getTable();
		int index = tabla.convertRowIndexToModel(tabla.getSelectedRow());// recogemos en esta variable la fila seleccionada por el usuario
		String dni = (String) tabla.getModel().getValueAt(index, 0);
		Usuario usuario = new Paciente(dni);
		return usuario;
	}

	private Usuario buscarUsuario(Usuario usuario) {
		Usuario usuarioAux = null;
		int index = lstPacientes.indexOf(usuario);
		if (index >= 0) {
			usuarioAux = lstPacientes.get(index);
		}
		return usuarioAux;
	}

	public void agregar(Paciente paciente) {
		Object[] fila = new Object[4]; // creamos un objeto de tipo array para las distintas cajas
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		fila[0] = paciente.getDni();
		fila[1] = Constantes.PACIENTE;
		fila[2] = paciente.getNombre();
		fila[3] = paciente.getApellido();
		((DefaultTableModel) model).addRow(fila);
	}

	private void cargarPacientesMedico() {
		Conexion c = new Conexion();
		lstPacientes = c.cargarPacientesBDD();
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		for (Paciente paciente : lstPacientes) {
			Object[] fila = new Object[4]; // creamos un objeto de tipo array
											// para las distintas cajas

			fila[0] = paciente.getDni();
			fila[1] = Paciente.PACIENTE;
			fila[2] = paciente.getNombre();
			fila[3] = paciente.getApellido();
			((DefaultTableModel) model).addRow(fila);
		}

	}

	public void ampliarInfo() {
		JEditorPane editorpane = ventanaControlada.getEditorPane();
		JTable tabla = ventanaControlada.getTable();
		if (tabla.getSelectedRow() != -1) {
			String cadena = Constantes.VACIO;
			Usuario usuarioAux = usuarioFila();
			Usuario usuario = buscarUsuario(usuarioAux);
			if (usuario != null) {
				String nombre = usuario.getNombre();
				String apellido = usuario.getApellido();
				String dni = usuario.getDni();
				String email = usuario.getEmail();
				String municipio = Constantes.VACIO;
				String comunidad = Constantes.VACIO;
				String provincia = Constantes.VACIO;
				String kg = Constantes.VACIO;
				String gramos = Constantes.VACIO;
				String calle = Constantes.VACIO;
				String estado = Constantes.VACIO;
				String sexo = Constantes.VACIO;
				String comentario = Constantes.VACIO;
				String fechaNac = Constantes.VACIO;
				String altura = Constantes.VACIO;
				String cp = Constantes.VACIO;
				String telefono = Constantes.VACIO;

				if (usuario instanceof Paciente) {
					Paciente aux = (Paciente) usuario;
					municipio = aux.getMunicipio();
					comunidad = aux.getComunidad();
					provincia = aux.getProvincia();
					kg = Integer.toString(aux.getKg());
					gramos = Integer.toString(aux.getGramos());
					calle = aux.getCalle();
					estado = aux.getEstado();
					sexo = aux.getSexo();
					comentario = aux.getComentario();
					fechaNac = aux.getFechaNacimiento();
					altura = String.valueOf(aux.getAltura());
					cp = aux.getCp();
					telefono = aux.getTelefono();

				}
			//@formatter:off
			 cadena = "<font face=\"Arial\"><ul>"
								+"<li><b>Nombre:</b>" + nombre + "</li>"
								+"<li><b>Apellido:</b> " + apellido+"</li>"
								+"<li><b>Dni:</b> " + dni + "</li>"
								+"<li><b>Telefono:</b> " + telefono + "</li>"
								+"<li><b>Email:</b> <a href=\"mailto:</b>"+ email + "?subject=WebyLan Question\">" + email + "</a></li>"
								+"<li><b>Comunidad:</b> " + comunidad + "</li>"
								+"<li><b>Provincia:</b> " + provincia + "</li>"
								+"<li><b>Municipio:</b> " + municipio + "</li>"
								+"<li><b>CP:</b> " + cp + "</li>"
								+"<li><b>Calle:</b> " + calle + "</li>"
								+"<li><b>Estado:</b> " + estado + "</li>"
								+"<li><b>Sexo:</b> " + sexo + "</li>"
								+"<li><b>Peso:</b> " + kg +Constantes.COMA + gramos + "Kg" + "</li>"
								+"<li><b>Comentario:</b> " + comentario + "</li>"
								+"<li><b>Fecha de Nacimiento:</b> " + fechaNac + "</li>"
								+"<li><b>Altura:</b> " + altura + "cm" + "</li>";
			//@formatter:on
				cadena += "</ul></font>";
			} else {
				cadena = "<p>El usuario no está  en la bd</p>";
			}
			editorpane.setText(cadena);
		}
	}

	public void fotoUsuario() {
		Usuario usuario = usuarioFila();
		Usuario usuarioAux = buscarUsuario(usuario);
		if (usuarioAux != null) {
			String sexo = usuarioAux.getSexo();

			// establecemos la foto del usuario dependiendo de si es hombre o mujer
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

	@Override
	public void mouseClicked(MouseEvent e) {
		Usuario usuario = usuarioFila();
		pacienteActual = (Paciente) buscarUsuario(usuario);
		if (e.getClickCount() == 1) {
			ampliarInfo();
			fotoUsuario();
		} else if (e.getClickCount() == 2) {
			ventanaControlada.dispose();

			VentanaMedico2 frameMedico2 = new VentanaMedico2(ventanaControlada.getNombreUsuario(), pacienteActual);
			frameMedico2.setVisible(true);
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
