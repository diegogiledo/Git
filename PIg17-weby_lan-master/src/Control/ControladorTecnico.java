package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
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
import Modelo.Paciente;
import Modelo.Tecnico;
import Modelo.Usuario;
import Vista.VentanaLogin;
import Vista.VentanaTecnico;
import Vista.VentanaTecnico2;

public class ControladorTecnico implements ActionListener, KeyListener, MouseListener {
	private List<Paciente> lstPacientes;
	private VentanaTecnico ventanaControlada;
	private ImageManipulator manipulator;
	private String genero = null;
	private boolean ventanaTec2Abierta = false;

	public ControladorTecnico(VentanaTecnico ventanaTecnico) {
		this.manipulator = new ImageManipulator();
		this.ventanaControlada = ventanaTecnico;
		cargarPacientes();// Accion a realizar al abrir la ventana
		cargarNombreTecnico();
	}

	private void cargarNombreTecnico() {
		JLabel lbl_Usuario = ventanaControlada.getLbl_Usuario();
		lbl_Usuario.setText("Bienvenido Técnico: " + WordUtils.capitalize(ventanaControlada.getNombreUsuario()));
	}

	public void setVentanaControlada(VentanaTecnico ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	public boolean isVentanaTec2Abierta() {
		return ventanaTec2Abierta;
	}

	public void setVentanaTec2Abierta(boolean ventanaTec2Abierta) {
		this.ventanaTec2Abierta = ventanaTec2Abierta;
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventanaControlada.getBtn_Logout())) {
			VentanaLogin vl = new VentanaLogin();
			ventanaControlada.dispose();
			vl.setVisible(true);
		}
	}


	public void cargarPacientes(){
		Conexion c = new Conexion();
		lstPacientes = c.cargarPacientesMedBBDD();
		DefaultTableModel model = (DefaultTableModel) ventanaControlada.getTable().getModel();
		for (Paciente paciente : lstPacientes) {
			Object[] fila = new Object[4]; // creamos un objeto de tipo array para las distintas cajas

			fila[0] = paciente.getDni();
			fila[1] = paciente.getNombre();
			fila[2] = paciente.getApellido();
			fila[3] = paciente.getEmail();
			((DefaultTableModel) model).addRow(fila);
		}
		
	}

	public void ampliarInfo() {
		JEditorPane editorpane = ventanaControlada.getEditorPane();
		JTable tabla = ventanaControlada.getTable();
		if (tabla.getSelectedRow() != -1) {
			Usuario usuarioAux = usuarioFila();
			Usuario usuario = buscarUsuario(usuarioAux);
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
			String cadena = "<font face=\"Arial\"><ul>"
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
			editorpane.setText(cadena);
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
		if (e.getClickCount() == 1) {
			this.ampliarInfo();
			this.fotoUsuario();
		} else if (e.getClickCount() == 2 && !ventanaTec2Abierta) {
			ventanaTec2Abierta = true;
			Usuario usuario = usuarioFila();
			Paciente paciente = (Paciente) buscarUsuario(usuario);
			VentanaTecnico2 frameTecnico2 = new VentanaTecnico2(ventanaControlada.getNombreUsuario(), paciente, this);
			frameTecnico2.setVisible(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

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
