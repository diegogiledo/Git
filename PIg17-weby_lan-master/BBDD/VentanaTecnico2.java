package Vista;

import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.JFreeChart;

import Control.GenerarGrafica;
import Modelo.AgregarArchivo;
import Modelo.Fichero;

public class VentanaTecnico2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaTecnico2() {
		abrirVentana();
	}

	private JPanel contentPane;
	private static JTextField txt_File;
	private JButton btn_Subir;

	/**
	 * Create the frame.
	 */
	public void abrirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txt_File = new JTextField();
		txt_File.setColumns(10);

		JButton btn_Archivo = new JButton("Archivo");
		btn_Archivo.addActionListener(new ActionListener() {
			String path = "";

			public void actionPerformed(ActionEvent arg0) {
				AgregarArchivo aa = new AgregarArchivo();

				try {
					path = aa.abrir();
				} catch (Exception e) {
					e.printStackTrace();
				}
				txt_File.setText(path);
				Fichero fichero = new Fichero();
				Electro electro = fichero.cargarElectro(path);
				GenerarGrafica generar = new GenerarGrafica(electro);
				JFreeChart chart = generar.createChartPanel();
			}
		});

		btn_Subir = new JButton("Subir");

		JEditorPane dtrpnComentario = new JEditorPane();
		dtrpnComentario.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//@formatter:off
  TextPrompt placeholder_apellido = new TextPrompt("                   Comentario",dtrpnComentario);
  //@formatter:on
		placeholder_apellido.changeAlpha(0.75f);
		placeholder_apellido.changeStyle(Font.ITALIC);

		JButton btn_Cancelar = new JButton("Cancelar");
		// dtrpnComentario.setText("Comentario:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(txt_File, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE).addGap(34)
						.addComponent(btn_Archivo, GroupLayout.PREFERRED_SIZE, 213, Short.MAX_VALUE).addGap(42))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(624, Short.MAX_VALUE)
								.addComponent(btn_Subir, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 104,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(dtrpnComentario, GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)).addGap(12)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(48)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(txt_File,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btn_Archivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(387).addComponent(dtrpnComentario, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_Subir, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
				.addGap(12)));
		contentPane.setLayout(gl_contentPane);
	}
}
