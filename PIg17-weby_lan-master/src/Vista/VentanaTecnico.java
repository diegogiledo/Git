package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Control.ControladorTecnico;
import Modelo.Constantes;

public class VentanaTecnico extends VentanaGenerica {

	private static final long serialVersionUID = 1L; // suprime warnings
	private ControladorTecnico controlador;

	private JPanel contentPane;
	private JTable table;
	private JEditorPane editorPane;
	private JTextField text_Busqueda;
	private ModeloTabla model;
	private JLabel lbl_Usuario;
	private JLabel lbl_FotoUser;
	private JButton btn_Logout;

	public JButton getBtn_Logout() {
		return btn_Logout;
	}

	public void setBtn_Logout(JButton btn_Logout) {
		this.btn_Logout = btn_Logout;
	}

	public JLabel getLbl_Usuario() {
		return lbl_Usuario;
	}

	public void setLbl_Usuario(JLabel lbl_Usuario) {
		this.lbl_Usuario = lbl_Usuario;
	}

	public ModeloTabla getModel() {
		return model;
	}

	public void setModel(ModeloTabla model) {
		this.model = model;
	}

	public JTextField getText_Busqueda() {
		return text_Busqueda;
	}

	public void setText_Busqueda(JTextField text_Busqueda) {
		this.text_Busqueda = text_Busqueda;
	}

	public JTable getTable() {
		return table;
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public VentanaTecnico(String usuario) {
		super(usuario);

	}

	@Override
	protected void crearVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 791);
		setMinimumSize(new Dimension(902, 791));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		model = new ModeloTabla(new Object[][] {}, new String[] { "ID", "Nombre", "Apellidos", "Email" });

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(model);
		table.repaint();
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setOpaque(false);
		editorPane.setContentType("text/html"); // decimos que el editor usara html
		// en la siguiente linea pongo \ pra distinguir de las comillas
		/*
		 * autogenerado por WB
		 */

		text_Busqueda = new JTextField();
		TextPrompt placeholder_id = new TextPrompt("Busqueda...", text_Busqueda);
		placeholder_id.changeAlpha(0.75f);
		placeholder_id.changeStyle(Font.ITALIC);
		text_Busqueda.setColumns(10);

		lbl_Usuario = new JLabel(Constantes.VACIO);

		lbl_FotoUser = new JLabel(Constantes.VACIO);

		btn_Logout = new JButton(Constantes.VACIO);
		ImageIcon image = new ImageIcon(
				Constantes.RELATIVO + File.separator + Constantes.CARPETAIMG + File.separator + Constantes.LOGOUTFOTO);
		btn_Logout.setIcon(image);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lbl_FotoUser, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
									.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
									.addGap(5))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbl_FotoUser, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(242)
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
		);

		/*
		 * medidas de las columnas
		 */
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.setFont(new Font(Constantes.VACIO, Font.PLAIN, 15));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane); // adjudico a mi Panel el layout
		this.controlador = new ControladorTecnico(this);
		this.controlador.setVentanaControlada(this);
		table.addMouseListener(controlador);
		text_Busqueda.addKeyListener(controlador);
		btn_Logout.addActionListener(controlador);

	}

	public void displayJLabel(JLabel x) {
		this.remove(lbl_FotoUser);
		lbl_FotoUser = x;
		lbl_FotoUser.setBounds(50, 25, x.getWidth(), x.getHeight());
		lbl_FotoUser.setBorder(new LineBorder(new Color(139, 0, 0), 4, true));
		getContentPane().add(lbl_FotoUser);
		this.setVisible(false);
		this.setVisible(true);
	}
}
