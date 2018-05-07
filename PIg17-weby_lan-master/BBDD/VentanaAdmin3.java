package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Control.ControladorAdmin;
import Modelo.Constantes;

public class VentanaAdmin3 extends VentanaGenerica {

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
	private ModeloTabla model;

	public VentanaAdmin3(String usuario) {
		super(usuario);
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
		setBounds(100, 100, 900, 700);
		setMinimumSize(new Dimension(900, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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

		btn_Modificar = new JButton("Modificar");

		btn_Eliminar = new JButton("Eliminar");

		// imagen de usuario

		lbl_Fotouser = new JLabel();

		editorPane = new JEditorPane();
		editorPane.setOpaque(false);
		editorPane.setEditable(false);

		lbl_Usuario = new JLabel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(27).addComponent(editorPane,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(49)
								.addComponent(lbl_Usuario, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
								.addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 145,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_Fotouser, GroupLayout.PREFERRED_SIZE, 74,
												GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_Mensaje, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(text_ID, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
										.addGap(18).addComponent(comboBox, 0, 173, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_Nombre, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_Apellido, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
						.addGap(6)).addGroup(
								gl_contentPane.createSequentialGroup().addGap(101)
										.addComponent(btn_Agregar, GroupLayout.PREFERRED_SIZE, 196, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btn_Modificar, GroupLayout.PREFERRED_SIZE, 203, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btn_Eliminar,
												GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
										.addGap(41)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lbl_Fotouser)
												.addPreferredGap(ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
												.addComponent(editorPane, GroupLayout.PREFERRED_SIZE, 224,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(text_ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(text_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(text_Apellido, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btn_Agregar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btn_Modificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btn_Eliminar))
								.addGap(18)
								.addComponent(lbl_Mensaje, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addGap(22))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addComponent(text_Busqueda, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGap(52)))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(lbl_Usuario).addGap(64)))));

		/*
		 * medidas de las columnas
		 */
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
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

		table.addMouseListener(controlador);
		editorPane.setContentType("text/html"); // decimos que el editor usara html
		// editorPane.setText(); // pongo \ pra distinguir de las comillas
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

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
}
