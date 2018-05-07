package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import Modelo.AgregarArchivo;
import Modelo.Constantes;
import Modelo.Electro;
import Modelo.Fichero;
import Modelo.Paciente;
import Vista.VentanaTecnico2;

public class ControladorTecnico2 implements ActionListener, KeyListener, MouseListener, WindowListener {
	private VentanaTecnico2 ventanaControlada;
	private ControladorTecnico controladorPadre;

	public ControladorTecnico2(VentanaTecnico2 ventanaTecnico2) {
		this.ventanaControlada = ventanaTecnico2;
	}

	public void setVentanaControlada(VentanaTecnico2 ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	public ControladorTecnico getControladorPadre() {
		return controladorPadre;
	}

	public void setControladorPadre(ControladorTecnico controladorPadre) {
		this.controladorPadre = controladorPadre;
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventanaControlada.getBtn_Archivo())) {
			try {
				cargarGrafica();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(ventanaControlada.getBtn_Cancelar())) {
			ventanaControlada.dispose();
			controladorPadre.setVentanaTec2Abierta(false);
			// System.out.println("Cerrrado con el cancelar");
		} else if (e.getSource().equals(ventanaControlada.getBtn_Subir())) {
			subirEcg();
		}
	}

	public void cargarGrafica() throws IOException {
		AgregarArchivo aa = new AgregarArchivo();
		JTextField txt_File = ventanaControlada.getTxt_File();
		JPanel panel = ventanaControlada.getPanel();
		String path = Constantes.VACIO;
		path = aa.abrir();
		txt_File.setText(path);
		Fichero fichero = new Fichero();
		Electro electro = fichero.cargarElectro(path);
		GenerarGrafica generar = new GenerarGrafica(electro);
		panel.removeAll();
		String[] aux = path.split(File.separator);// nombre del archivo
		int posicion = aux.length - 1;// Posicion del nombre del archivo
		String nombreArchivo = aux[posicion];
		nombreArchivo = nombreArchivo.replaceAll(Constantes.EXTENSIONTXT, Constantes.ESPACIOB);
		JFreeChart chart = generar.crearGrafica(nombreArchivo);
		ChartPanel chartpanel = new ChartPanel(chart);
		panel.add(chartpanel);
		panel.validate();
		ventanaControlada.getBtn_Subir().setEnabled(true);

	}

	public void subirEcg() {
		JTextField txt_File = ventanaControlada.getTxt_File();
		String ruta = txt_File.getText();
		if (!ruta.equals(Constantes.VACIO) && !ruta.equals(Constantes.NOSELECCION)) {
			JEditorPane dtrpnComentario = ventanaControlada.getDtrpnComentario();
			String comentario = dtrpnComentario.getText();
			Paciente paciente = ventanaControlada.getPaciente();
			String nombre = paciente.getNombre();
			String apellidos = paciente.getApellido();
			String nombreCompletoPac = nombre + Constantes.ESPACIOB + apellidos;
			String nombreUsuarioTecnico = ventanaControlada.getNombreUsuario();
			String cadenaAccion = "¿Está seguro de que desea añadir al paciente con nombre " + nombreCompletoPac
					+ " el ecg actual realizado por el tecnico con nombre de usuario " + nombreUsuarioTecnico + " ?";
			Object[] options = { Constantes.ACEPTAR, Constantes.CANCELAR };
			int respuesta = JOptionPane.showOptionDialog(null, cadenaAccion, "¿Seguro?", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[1]);
			if (respuesta == 0) {
				JOptionPane.showMessageDialog(null, "ECG GUARDADO CORRECTAMENTE");
				ventanaControlada.dispose();
				controladorPadre.setVentanaTec2Abierta(false);
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		controladorPadre.setVentanaTec2Abierta(false);
		// System.out.println("Cerrada con la X");
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
