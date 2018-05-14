package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Control.ControladorTecnico;
import Control.ControladorTecnico2;
import Modelo.Paciente;

public class VentanaTecnico2 extends VentanaGenerica {
	private Paciente paciente;

	public VentanaTecnico2(String usuario) {
		super(usuario);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public VentanaTecnico2(String usuario, Paciente paciente, ControladorTecnico controladorPadre) {
		super(usuario);
		this.paciente = paciente;
		this.controlador.setControladorPadre(controladorPadre);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControladorTecnico2 controlador;
	private JPanel contentPane;
	private JButton btn_Subir;
	private JPanel panel;
	private GroupLayout gl_contentPane;
	private JTextField txt_File;
	private JButton btn_Archivo;
	private JButton btn_Cancelar;
	private JEditorPane dtrpnComentario;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public JEditorPane getDtrpnComentario() {
		return dtrpnComentario;
	}

	public void setDtrpnComentario(JEditorPane dtrpnComentario) {
		this.dtrpnComentario = dtrpnComentario;
	}

	public JButton getBtn_Subir() {
		return btn_Subir;
	}

	public void setBtn_Subir(JButton btn_Subir) {
		this.btn_Subir = btn_Subir;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public GroupLayout getGl_contentPane() {
		return gl_contentPane;
	}

	public void setGl_contentPane(GroupLayout gl_contentPane) {
		this.gl_contentPane = gl_contentPane;
	}

	public JTextField getTxt_File() {
		return txt_File;
	}

	public void setTxt_File(JTextField txt_File) {
		this.txt_File = txt_File;
	}

	public JButton getBtn_Archivo() {
		return btn_Archivo;
	}

	public void setBtn_Archivo(JButton btn_Archivo) {
		this.btn_Archivo = btn_Archivo;
	}

	public JButton getBtn_Cancelar() {
		return btn_Cancelar;
	}

	public void setBtn_Cancelar(JButton btn_Cancelar) {
		this.btn_Cancelar = btn_Cancelar;
	}

	/**
	 * Create the frame.
	 */
	public void crearVentana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 910, 700);
		setMinimumSize(new Dimension(910, 701));
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txt_File = new JTextField();
		txt_File.setEditable(false);
		txt_File.setColumns(10);

		btn_Archivo = new JButton("Archivo");
		
		btn_Subir = new JButton("Subir");
		btn_Subir.setOpaque(true);
		btn_Subir.setBorderPainted(false);
		btn_Subir.setForeground(Color.WHITE);
		btn_Subir.setBackground(new Color(139, 0, 0));
		btn_Subir.setEnabled(false);

		dtrpnComentario = new JEditorPane();
		dtrpnComentario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextPrompt placeholder_apellido = new TextPrompt("Informe médico", dtrpnComentario);
		placeholder_apellido.changeAlpha(0.75f);
		placeholder_apellido.changeStyle(Font.ITALIC);

		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setOpaque(true);
		btn_Cancelar.setBorderPainted(false);
		btn_Cancelar.setForeground(Color.WHITE);
		btn_Cancelar.setBackground(new Color(139, 0, 0));
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		JLabel prev = new JLabel("SELECCIONA UN ECG VÁLIDO PARA VISUALIZAR SU CONTENIDO...");
		prev.setFont(new Font("Tahoma", Font.PLAIN, 26));
		prev.setForeground(Color.white);
		panel.add(prev, BorderLayout.WEST);

		panel.setBackground(Color.LIGHT_GRAY);
		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Subir, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txt_File, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btn_Archivo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addComponent(dtrpnComentario)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE))
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_File, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Archivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dtrpnComentario, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Subir, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(93))
		);
		contentPane.setLayout(gl_contentPane);

		this.controlador = new ControladorTecnico2(this);
		this.controlador.setVentanaControlada(this);

		btn_Archivo.addActionListener(controlador);
		btn_Subir.addActionListener(controlador);
		btn_Cancelar.addActionListener(controlador);
		this.addWindowListener(controlador);
	}

}