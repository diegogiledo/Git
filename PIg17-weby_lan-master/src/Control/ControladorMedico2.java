package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Modelo.Constantes;
import Modelo.Paciente;
import Vista.VentanaCompararEcg;
import Vista.VentanaMedico;
import Vista.VentanaMedico2;

public class ControladorMedico2 implements ActionListener, KeyListener, MouseListener, PropertyChangeListener {
	private VentanaMedico2 ventanaControlada;

	public ControladorMedico2(VentanaMedico2 ventanaMedico2) {
		this.ventanaControlada = ventanaMedico2;
	}

	public void setVentanaControlada(VentanaMedico2 ventanaControlada) {
		this.ventanaControlada = ventanaControlada;
	}

	// Función que indica las acciones que realizan los objetos de la ventana
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ventanaControlada.getBtn_Atras())) {
			abrirVentanaMedico();
		} else if (e.getSource().equals(ventanaControlada.getBtn_Visualizar())) {
			List<String> lstEcg = new ArrayList<String>();
			JComboBox<String> comb1 = ventanaControlada.getComboBox1();
			String ecg1 = (String) comb1.getSelectedItem();
			lstEcg.add(ecg1);

			if (ventanaControlada.getCbx_Comparar().isSelected()) {
				JComboBox<String> comb2 = ventanaControlada.getComboBox2();
				String ecg2 = (String) comb2.getSelectedItem();
				lstEcg.add(ecg2);
			}

			VentanaCompararEcg cecg = new VentanaCompararEcg(lstEcg);
			cecg.setVisible(true);
		}
	}

	private void abrirVentanaMedico() {
		ventanaControlada.dispose();
		VentanaMedico vm = new VentanaMedico(ventanaControlada.getNombreUsuario());
		vm.setVisible(true);

	}

	// private void cargarComentario(String ecg) throws IOException {
	// Fichero fichero = new Fichero();
	// Electro electro = fichero.cargarElectroMed(ecg);
	// String comentario = electro.getComentario();
	// JTextField contenedor = ventanaControlada.getTextField();
	// contenedor.setText(comentario);
	// }

	private void generarCombo(JComboBox<String> combo) {
		Date fechaSeleccionada = ventanaControlada.getCalendar().getDate();
		SimpleDateFormat formato = new SimpleDateFormat(Constantes.TIPOFECHA1);
		String fechaFin = formato.format(fechaSeleccionada);
		List<String> lstDiasPintados = ventanaControlada.getLstDiasPintados();
		List<String> lstContenidos = new ArrayList<String>();
		if (lstDiasPintados.contains(fechaFin)) {
			Paciente paciente = ventanaControlada.getPaciente();
			List<String> lstEcgs = paciente.getElectros();

			for (String electro : lstEcgs) {
				if (electro.contains(fechaFin)) {
					lstContenidos.add(electro);
				}
			}
		}

		if (!lstContenidos.isEmpty()) {
			String[] arrayElectros = new String[lstContenidos.size()];
			int i = 0;
			for (String elecAux : lstContenidos) {
				arrayElectros[i] = elecAux;
				i++;
			}

			combo.setModel(new DefaultComboBoxModel<String>(arrayElectros));
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
		JCheckBox check = ventanaControlada.getCbx_Comparar();
		if (e.getSource().equals(check)) {
			JComboBox<String> comb1 = ventanaControlada.getComboBox1();
			JComboBox<String> comb2 = ventanaControlada.getComboBox2();
			if (check.isSelected()) {
				comb1.setEnabled(false);
				comb2.setEnabled(true);
			} else {
				comb1.setEnabled(true);
				comb2.setEnabled(false);
			}
		}
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
	public void propertyChange(PropertyChangeEvent evt) {
		// System.out.println(evt.getPropertyName());
		if (evt.getPropertyName().equals("calendar")) {
			JCheckBox check = ventanaControlada.getCbx_Comparar();
			if (check.isSelected()) {
				generarCombo(ventanaControlada.getComboBox2());
			} else {
				generarCombo(ventanaControlada.getComboBox1());
			}

		}
	}

}
