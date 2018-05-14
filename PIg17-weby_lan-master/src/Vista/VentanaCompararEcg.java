package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import Control.GenerarGrafica;
import Modelo.Electro;
import Modelo.Fichero;

public class VentanaCompararEcg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private List<String> ecg;

	public VentanaCompararEcg(List<String> ecgs) {
		this.ecg = ecgs;
		crearVentana();
		try {
			if (!ecgs.isEmpty()) {
				cargarGrafica(panel, ecg.get(0));
			}

			if (ecgs.size() > 1) {
				cargarGrafica(panel_2, ecg.get(1));
				panel_2.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Creamos la ventana
	 */
	public void crearVentana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1004, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setVisible(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(70))
		);
		panel.setLayout(new BorderLayout(0, 0));
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Esperando 2º ECG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		panel_2.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}

	private void cargarGrafica(JPanel panel, String ecg) throws IOException {
		Fichero fichero = new Fichero();
		Electro electro = fichero.cargarElectroMed(ecg);
		GenerarGrafica generar = new GenerarGrafica(electro);
		panel.removeAll();
		JFreeChart chart = generar.crearGrafica(ecg);
		ChartPanel chartpanel = new ChartPanel(chart);
		panel.add(chartpanel);
		panel.validate();
	}
}
