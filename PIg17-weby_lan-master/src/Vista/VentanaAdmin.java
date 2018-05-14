package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import Control.ControladorAdmin;
import Modelo.Constantes;

public class VentanaAdmin extends VentanaGenerica {

	private static final long serialVersionUID = 1L;

	private ControladorAdmin controlador;
	private JPanel contentPane;
	private JTable table;
	private JTextField text_ID;
	private JTextField text_Nombre;
	private JTextField text_Apellido;
	private JButton btn_Agregar;
	private JLabel lbl_Usuario;
	private JButton btn_Modificar;
	private JButton btn_Eliminar;
	private JLabel lbl_Fotouser;
	private JEditorPane editorPane;
	private JLabel lbl_Mensaje;
	private JComboBox<String> comboBox;
	private JTextField text_Busqueda;
	private JButton btn_Logout;
	private ModeloTabla model;

	public VentanaAdmin(String usuario) {
		super(usuario);
	}

	public JButton getBtn_Logout() {
		return btn_Logout;
	}

	public void setBtn_Logout(JButton btn_Logout) {
		this.btn_Logout = btn_Logout;
	}

	public ModeloTabla getModel() {
		return model;
	}

	public void setModel(ModeloTabla model) {
		this.model = model;
	}

	public JButton getBtn_Agregar() {
		return btn_Agregar;
	}

	public JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public JLabel getLbl_Usuario() {
		return lbl_Usuario;
	}

	public void setLbl_Usuario(JLabel lbl_Usuario) {
		this.lbl_Usuario = lbl_Usuario;
	}

	public JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	public JTextField getText_ID() {
		return text_ID;
	}

	public JTextField getText_Nombre() {
		return text_Nombre;
	}

	public JTextField getText_Apellido() {
		return text_Apellido;
	}

	public JTextField getText_Busqueda() {
		return text_Busqueda;
	}

	public void setText_Busqueda(JTextField text_Busqueda) {
		this.text_Busqueda = text_Busqueda;
	}

	public JLabel getLbl_Mensaje() {
		return lbl_Mensaje;
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

	@Override
	protected void crearVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 700);
		setMinimumSize(new Dimension(1073, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		/*
		 * inicializamos los componentes de nuestra ventana
		 */

		model = new ModeloTabla(new Object[][] {}, new String[] { "ID", "Rol", "Nombre", "Apellidos" });
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(model);

		text_ID = new JTextField();
		TextPrompt placeholder_id = new TextPrompt("ID", text_ID);
		placeholder_id.changeAlpha(0.75f);
		placeholder_id.changeStyle(Font.ITALIC);
		text_ID.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Medico", "Tecnico" }));

		text_Nombre = new JTextField();
		TextPrompt placeholder_nombre = new TextPrompt("Nombre", text_Nombre);
		placeholder_nombre.changeAlpha(0.75f);
		placeholder_nombre.changeStyle(Font.ITALIC);
		text_Nombre.setColumns(10);

		text_Busqueda = new JTextField();
		TextPrompt placeholder_busqueda = new TextPrompt("Buscar", text_Busqueda);
		placeholder_busqueda.changeAlpha(0.75f);
		placeholder_busqueda.changeStyle(Font.ITALIC);
		text_Busqueda.setColumns(10);

		text_Apellido = new JTextField();
		TextPrompt placeholder_apellido = new TextPrompt("Apellido", text_Apellido);
		placeholder_apellido.changeAlpha(0.75f);
		placeholder_apellido.changeStyle(Font.ITALIC);
		text_Apellido.setColumns(10);

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

		btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setOpaque(true);
		btn_Eliminar.setBorderPainted(false);
		btn_Eliminar.setForeground(Color.WHITE);
		btn_Eliminar.setBackground(new Color(139, 0, 0));

		// imagen de usuario

		lbl_Fotouser = new JLabel();
		editorPane = new JEditorPane();
		editorPane.setOpaque(false);
		editorPane.setEditable(false);

		lbl_Usuario = new JLabel();

		btn_Logout = new JButton(Constantes.VACIO);
		ImageIcon image = new ImageIcon(
				Constantes.RELATIVO + File.separator + Constantes.CARPETAIMG + File.separator + Constantes.LOGOUTFOTO);
		btn_Logout.setIcon(image);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addComponent(btn_Logout,
										GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(38)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(text_ID, GroupLayout.PREFERRED_SIZE, 199,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 172,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(text_Nombre, GroupLayout.PREFERRED_SIZE, 207,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btn_Modificar, GroupLayout.PREFERRED_SIZE, 231,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btn_Agregar, GroupLayout.PREFERRED_SIZE, 245,
																GroupLayout.PREFERRED_SIZE)
														.addGap(81))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lbl_Mensaje, GroupLayout.DEFAULT_SIZE, 116,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btn_Eliminar, GroupLayout.PREFERRED_SIZE, 117,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(text_Apellido, GroupLayout.PREFERRED_SIZE, 177,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(39).addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)))
						.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(282)
								.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
								.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE)
								.addGap(17))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(149)
								.addComponent(lbl_Fotouser, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(590, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(lbl_Fotouser, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(text_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(text_ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(text_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btn_Eliminar)
								.addComponent(btn_Agregar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btn_Modificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(18)
						.addComponent(lbl_Mensaje, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(199)
								.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
								.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
				.addGap(22)));

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

		this.controlador = new ControladorAdmin(this);
		this.controlador.setVentanaControlada(this);

		/*
		 * dotamos al boton de accion para rellenar las cajas con la respectiva informacion
		 */
		btn_Agregar.addActionListener(controlador);
		/*
		 * adjudicamos al boton de modificar las siguientes tareas
		 */
		btn_Modificar.addActionListener(controlador);
		btn_Eliminar.addActionListener(controlador);
		text_Busqueda.addKeyListener(controlador);
		btn_Logout.addActionListener(controlador);

		table.addMouseListener(controlador);
		editorPane.setContentType("text/html"); // decimos que el panel usara contenido html
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

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
}
