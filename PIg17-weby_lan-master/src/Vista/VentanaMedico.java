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

import Control.ControladorMedico;
import Modelo.Constantes;

public class VentanaMedico extends VentanaGenerica {

	private static final long serialVersionUID = 1L;

	private ControladorMedico controlador;
	private JPanel contentPane;
	private JTable table;
	private JTextField text_Busqueda;
	private JButton btn_Agregar;
	private JButton btn_Modificar;
	private JLabel lbl_Fotouser;
	private JEditorPane editorPane;
	private JLabel lbl_Mensaje;
	private String idMedico;
	private ModeloTabla modelo;
	private JLabel lbl_Usuario;
	private JButton btn_Logout;

	public VentanaMedico(String usuario) {
		super(usuario);
	}

	public JButton getBtn_Logout() {
		return btn_Logout;
	}

	public void setBtn_Logout(JButton btn_Logout) {
		this.btn_Logout = btn_Logout;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getText_Busqueda() {
		return text_Busqueda;
	}

	public void setText_Busqueda(JTextField text_Busqueda) {
		this.text_Busqueda = text_Busqueda;
	}

	public JButton getBtn_Agregar() {
		return btn_Agregar;
	}

	public void setBtn_Agregar(JButton btn_Agregar) {
		this.btn_Agregar = btn_Agregar;
	}

	public JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public void setBtn_Modificar(JButton btn_Modificar) {
		this.btn_Modificar = btn_Modificar;
	}

	public JLabel getLbl_Fotouser() {
		return lbl_Fotouser;
	}

	public void setLbl_Fotouser(JLabel lbl_Fotouser) {
		this.lbl_Fotouser = lbl_Fotouser;
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public JLabel getLbl_Mensaje() {
		return lbl_Mensaje;
	}

	public void setLbl_Mensaje(JLabel lbl_Mensaje) {
		this.lbl_Mensaje = lbl_Mensaje;
	}

	public ModeloTabla getModelo() {
		return modelo;
	}

	public void setModelo(ModeloTabla modelo) {
		this.modelo = modelo;
	}

	public JLabel getLbl_Usuario() {
		return lbl_Usuario;
	}

	public void setLbl_Usuario(JLabel lbl_Usuario) {
		this.lbl_Usuario = lbl_Usuario;
	}

	@Override
	protected void crearVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 850);
		setMinimumSize(new Dimension(1010, 850));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		/*
		 * inicializamos los componentes de nuestra ventana
		 */

		modelo = new ModeloTabla(new Object[][] {}, new String[] { "ID", "Rol", "Nombre", "Apellidos" });
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(modelo);

		text_Busqueda = new JTextField();
		TextPrompt placeholder_busqueda = new TextPrompt("Busqueda...", text_Busqueda);
		placeholder_busqueda.changeAlpha(0.75f);
		placeholder_busqueda.changeStyle(Font.ITALIC);
		text_Busqueda.setColumns(10);

		lbl_Mensaje = new JLabel(Constantes.VACIO);
		lbl_Mensaje.setForeground(Color.RED);

		btn_Agregar = new JButton("Agregar"); // creamos los distintos botones
		btn_Agregar.setOpaque(true);
		btn_Agregar.setBorderPainted(false);
		btn_Agregar.setForeground(Color.WHITE);
		btn_Agregar.setBackground(new Color(139, 0, 0));

		btn_Modificar = new JButton("Modificar");
		btn_Modificar.setOpaque(true);
		btn_Modificar.setBorderPainted(false);
		btn_Modificar.setForeground(Color.WHITE);
		btn_Modificar.setBackground(new Color(139, 0, 0));

		// imagen de usuario

		lbl_Fotouser = new JLabel(Constantes.VACIO);

		editorPane = new JEditorPane();
		editorPane.setOpaque(false);
		editorPane.setEditable(false);

		lbl_Usuario = new JLabel(Constantes.VACIO);

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
							.addGap(89)
							.addComponent(lbl_Fotouser, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Mensaje, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btn_Agregar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btn_Modificar, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
									.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)))
							.addGap(12)))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(936, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lbl_Usuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(lbl_Fotouser)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Modificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btn_Agregar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lbl_Mensaje, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		/*
		 * medidas de las columnas
		 */
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setFont(new Font(Constantes.VACIO, Font.PLAIN, 15));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

		this.controlador = new ControladorMedico(this);
		this.controlador.setVentanaControlada(this);

		/*
		 * dotamos al boton de accion para rellenar las cajas con la respectiva informacion
		 */
		btn_Agregar.addActionListener(controlador);
		/*
		 * adjudicamos al boton de modificar las siguientes tareas
		 */
		btn_Modificar.addActionListener(controlador);
		table.addMouseListener(controlador);
		text_Busqueda.addKeyListener(controlador);
		btn_Logout.addActionListener(controlador);
		/*
		 * 
		 * <font face="Arial"><ul><li>Nombre</li><li>Apellido</li><li>Provincia</li><li>Localidad</li><li>Calle</li></ul></font
		 * 
		 * "<html><font face =\"arial\"><ul><li>" JEditorPane solo se puede escribir en formato RTF o HTML
		 */
		editorPane.setContentType("text/html"); // decimos que el editor usara html
		// con estado me refiero a casado o no(no se si es del todo relevante pero lo pensare

	}

	public void displayJLabel(JLabel x) {
		this.remove(lbl_Fotouser);
		lbl_Fotouser = x;
		lbl_Fotouser.setBounds(50, 25, x.getWidth(), x.getHeight());
		lbl_Fotouser.setBorder(new LineBorder(new Color(139, 0, 0), 4, true));
		getContentPane().add(lbl_Fotouser);
		this.setVisible(false);
		this.setVisible(true);
	}

}
