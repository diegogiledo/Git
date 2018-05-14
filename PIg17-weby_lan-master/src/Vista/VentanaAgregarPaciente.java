package Vista;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Control.ControladorAgregarPaciente;
import Control.ControladorMedico;
import Modelo.Constantes;
import Modelo.Paciente;

public class VentanaAgregarPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5650768335603890091L;
	private ControladorAgregarPaciente controlador;
	private ControladorMedico controladorMed;
	private JPanel contentPane;
	private JLabel lbl_Nuevo;
	private JTextField txt_Nombre;
	private JTextField txt_Apellido;
	private JTextField txt_DNI;
	private JTextField txt_Direccion;
	private JTextField txt_CP;
	private JTextField txt_Tel;
	private JTextField txt_Email;
	private JDateChooser dateChooser;
	private JComboBox<String> cb_Sexo;
	private JComboBox<String> cb_Altura;
	private JButton btn_Agregar;
	private JButton btn_Cancelar;
	private JLabel lbl_Mensaje;
	private JComboBox<String> cb_Kg;
	private JComboBox<String> cb_Gramos;
	private JTextField txt_Comunidad;
	private JTextField txt_Provincias;
	private JTextField txt_Municipio;
	private String[] sexoCombo = { Constantes.HOMBRE, Constantes.MUJER, Constantes.DESCONOCIDO };
	private String[] alturaCombo = new String[Constantes.ULTIMA_ALTURA - Constantes.PRIMERA_ALTURA + 1];
	private String[] kgCombo = new String[Constantes.ULTIMO_KG - Constantes.PRIMER_KG + 1];
	private String[] gramosCombo = { Constantes.GRAMOS0, Constantes.GRAMOS1, Constantes.GRAMOS2, Constantes.GRAMOS3 };

	public VentanaAgregarPaciente(ControladorMedico controladorMed) {
		this.controladorMed = controladorMed;
		rellenarCombos();
		crearVentana();
	}

	public ControladorMedico getControladorMed() {
		return controladorMed;
	}

	public void setControladorMed(ControladorMedico controladorMed) {
		this.controladorMed = controladorMed;
	}

	public JLabel getLbl_Nuevo() {
		return lbl_Nuevo;
	}

	public void setLbl_Nuevo(JLabel lbl_Nuevo) {
		this.lbl_Nuevo = lbl_Nuevo;
	}

	public JTextField getTxt_Nombre() {
		return txt_Nombre;
	}

	public void setTxt_Nombre(JTextField txt_Nombre) {
		this.txt_Nombre = txt_Nombre;
	}

	public JTextField getTxt_Apellido() {
		return txt_Apellido;
	}

	public void setTxt_Apellido(JTextField txt_Apellido) {
		this.txt_Apellido = txt_Apellido;
	}

	public JTextField getTxt_DNI() {
		return txt_DNI;
	}

	public void setTxt_DNI(JTextField txt_DNI) {
		this.txt_DNI = txt_DNI;
	}

	public JTextField getTxt_Direccion() {
		return txt_Direccion;
	}

	public void setTxt_Direccion(JTextField txt_Direccion) {
		this.txt_Direccion = txt_Direccion;
	}

	public JTextField getTxt_CP() {
		return txt_CP;
	}

	public void setTxt_CP(JTextField txt_CP) {
		this.txt_CP = txt_CP;
	}

	public JTextField getTxt_Tel() {
		return txt_Tel;
	}

	public void setTxt_Tel(JTextField txt_Tel) {
		this.txt_Tel = txt_Tel;
	}

	public JTextField getTxt_Email() {
		return txt_Email;
	}

	public void setTxt_Email(JTextField txt_Email) {
		this.txt_Email = txt_Email;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JComboBox<String> getCb_Sexo() {
		return cb_Sexo;
	}

	public void setCb_Sexo(JComboBox<String> cb_Sexo) {
		this.cb_Sexo = cb_Sexo;
	}

	public JComboBox<String> getCb_Altura() {
		return cb_Altura;
	}

	public void setCb_Altura(JComboBox<String> cb_Altura) {
		this.cb_Altura = cb_Altura;
	}

	public JButton getBtn_Agregar() {
		return btn_Agregar;
	}

	public void setBtn_Agregar(JButton btn_Agregar) {
		this.btn_Agregar = btn_Agregar;
	}

	public JButton getBtn_Cancelar() {
		return btn_Cancelar;
	}

	public void setBtn_Cancelar(JButton btn_Cancelar) {
		this.btn_Cancelar = btn_Cancelar;
	}

	public JLabel getLbl_Mensaje() {
		return lbl_Mensaje;
	}

	public void setLbl_Mensaje(JLabel lbl_Mensaje) {
		this.lbl_Mensaje = lbl_Mensaje;
	}

	public JComboBox<String> getCb_Kg() {
		return cb_Kg;
	}

	public void setCb_Kg(JComboBox<String> cb_Kg) {
		this.cb_Kg = cb_Kg;
	}

	public JComboBox<String> getCb_Gramos() {
		return cb_Gramos;
	}

	public void setCb_Gramos(JComboBox<String> cb_Gramos) {
		this.cb_Gramos = cb_Gramos;
	}

	public JTextField getTxt_Comunidad() {
		return txt_Comunidad;
	}

	public void setTxt_Comunidad(JTextField txt_Comunidad) {
		this.txt_Comunidad = txt_Comunidad;
	}

	public JTextField getTxt_Provincias() {
		return txt_Provincias;
	}

	public void setTxt_Provincias(JTextField txt_Provincias) {
		this.txt_Provincias = txt_Provincias;
	}

	public JTextField getTxt_Municipio() {
		return txt_Municipio;
	}

	public void setTxt_Municipio(JTextField txt_Municipio) {
		this.txt_Municipio = txt_Municipio;
	}

	/*
	 * posteriormente cambiar a public void crearVentana()
	 */
	public void crearVentana() {
		/*
		 * caracteristicas del Frame
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 462);
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		setTitle("Medico");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		/*
		 * Creamos los elementos a utilizar en el panel
		 */
		lbl_Nuevo = new JLabel("Nuevo Paciente");
		lbl_Nuevo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

		txt_Nombre = new JTextField();
		TextPrompt placeholder_nombre = new TextPrompt("Nombre", txt_Nombre);
		placeholder_nombre.changeAlpha(0.75f);
		placeholder_nombre.changeStyle(Font.ITALIC);
		txt_Nombre.setColumns(10);

		txt_Apellido = new JTextField();
		TextPrompt placeholder_apellido = new TextPrompt("Apellido", txt_Apellido);
		placeholder_apellido.changeAlpha(0.75f);
		placeholder_apellido.changeStyle(Font.ITALIC);
		txt_Apellido.setColumns(10);

		txt_DNI = new JTextField();
		TextPrompt placeholder_dni = new TextPrompt("DNI", txt_DNI);
		placeholder_dni.changeAlpha(0.75f);
		placeholder_dni.changeStyle(Font.ITALIC);
		txt_DNI.setColumns(10);

		dateChooser = new JDateChooser();

		cb_Sexo = new JComboBox<String>();
		cb_Sexo.setModel(new DefaultComboBoxModel<String>(sexoCombo));
		cb_Sexo.setRenderer(new JComboBoxPrompt("-Sexo-"));
		cb_Sexo.setSelectedIndex(-1);

		// cb_Altura de momento esta Hardcodeado
		cb_Altura = new JComboBox<String>();
		cb_Altura.setModel(new DefaultComboBoxModel<String>(alturaCombo));
		cb_Altura.setRenderer(new JComboBoxPrompt("-Altura(cm)-"));
		cb_Altura.setSelectedIndex(-1);
		((JLabel) cb_Altura.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) cb_Altura.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		cb_Kg = new JComboBox<String>();
		cb_Kg.setRenderer(new JComboBoxPrompt("-Peso(Kg)-"));
		cb_Kg.setModel(new DefaultComboBoxModel<String>(kgCombo));
		cb_Kg.setSelectedIndex(-1);
		((JLabel) cb_Kg.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) cb_Kg.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);

		cb_Gramos = new JComboBox<String>();
		cb_Gramos.setModel(new DefaultComboBoxModel<String>(gramosCombo));
		cb_Gramos.setRenderer(new JComboBoxPrompt("-Peso(Gr.)-"));
		cb_Gramos.setSelectedIndex(-1);
		((JLabel) cb_Gramos.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) cb_Gramos.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		DefaultComboBoxModel<String> value = new DefaultComboBoxModel<String>();

		txt_Comunidad = new JTextField();
		TextPrompt placeholder_comunidad = new TextPrompt("Comunidad", txt_Comunidad);
		placeholder_comunidad.changeAlpha(0.75f);
		placeholder_comunidad.changeStyle(Font.ITALIC);
		txt_Comunidad.setColumns(10);

		txt_Provincias = new JTextField();
		TextPrompt placeholder_provincias = new TextPrompt("Provincia", txt_Provincias);
		placeholder_provincias.changeAlpha(0.75f);
		placeholder_provincias.changeStyle(Font.ITALIC);
		txt_Provincias.setColumns(10);

		txt_Municipio = new JTextField();
		TextPrompt placeholder_municipio = new TextPrompt("Municipio", txt_Municipio);
		placeholder_municipio.changeStyle(Font.ITALIC);
		txt_Municipio.setColumns(10);

		txt_Direccion = new JTextField();
		TextPrompt placeholder_direccion = new TextPrompt("Direccion", txt_Direccion);
		placeholder_direccion.changeAlpha(0.75f);
		placeholder_direccion.changeStyle(Font.ITALIC);
		txt_Direccion.setColumns(10);

		txt_CP = new JTextField();
		TextPrompt placeholder_cp = new TextPrompt("Codigo Postal", txt_CP);
		placeholder_cp.changeAlpha(0.75f);
		placeholder_cp.changeStyle(Font.ITALIC);
		txt_CP.setColumns(10);

		txt_Tel = new JTextField();
		TextPrompt placeholder_telefono = new TextPrompt("Telefono", txt_Tel);
		placeholder_telefono.changeAlpha(0.75f);
		placeholder_telefono.changeStyle(Font.ITALIC);
		txt_Tel.setColumns(10);

		txt_Email = new JTextField();
		TextPrompt placeholder_email = new TextPrompt("E-mail", txt_Email);
		placeholder_email.changeAlpha(0.75f);
		placeholder_email.changeStyle(Font.ITALIC);
		txt_Email.setColumns(10);

		lbl_Mensaje = new JLabel("");

		btn_Agregar = new JButton("Agregar");
		btn_Agregar.setOpaque(true);
		btn_Agregar.setBorderPainted(false);
		btn_Agregar.setForeground(Color.WHITE);
		btn_Agregar.setBackground(new Color(139, 0, 0));

		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setOpaque(true);
		btn_Cancelar.setBorderPainted(false);
		btn_Cancelar.setForeground(Color.WHITE);
		btn_Cancelar.setBackground(new Color(139, 0, 0));

		/*
		 * Autogenerado de WindowsBuilder
		 */
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(txt_Tel, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE).addGap(513))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(txt_Email, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE).addGap(379))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(205)
						.addComponent(btn_Agregar, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE).addGap(103)
						.addComponent(btn_Cancelar, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE).addGap(220))
				.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_Direccion, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(txt_Comunidad, GroupLayout.PREFERRED_SIZE, 192,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txt_Provincias, GroupLayout.DEFAULT_SIZE, 310,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(285).addComponent(lbl_Nuevo,
								GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(txt_Nombre, GroupLayout.DEFAULT_SIZE, 253,
														Short.MAX_VALUE)
												.addGap(18))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 149,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(cb_Sexo, GroupLayout.PREFERRED_SIZE, 107,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txt_Apellido, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(cb_Altura, GroupLayout.PREFERRED_SIZE, 126,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(cb_Kg, 0, 123, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(txt_CP)
														.addGap(114))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(txt_DNI, GroupLayout.DEFAULT_SIZE, 215,
																Short.MAX_VALUE)
														.addGap(29))
												.addGroup(Alignment.LEADING,
														gl_contentPane.createSequentialGroup()
																.addComponent(txt_Municipio, GroupLayout.DEFAULT_SIZE,
																		241, Short.MAX_VALUE)
																.addContainerGap())))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(46)
										.addComponent(cb_Gramos, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lbl_Mensaje,
						GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lbl_Nuevo, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_DNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb_Sexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cb_Altura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cb_Kg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cb_Gramos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_Comunidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Provincias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Municipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_Direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_CP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(txt_Tel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(txt_Email, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lbl_Mensaje, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(btn_Agregar).addComponent(btn_Cancelar))
						.addGap(16)));
		contentPane.setLayout(gl_contentPane);
		this.controlador = new ControladorAgregarPaciente(this);
		this.controlador.setVentanaControlada(this);
		btn_Agregar.addActionListener(controlador);
		btn_Cancelar.addActionListener(controlador);

	}

	private void rellenarCombos() {
		int aux1 = 0;
		for (int i = Constantes.PRIMERA_ALTURA; i <= Constantes.ULTIMA_ALTURA; i++) {
			alturaCombo[aux1] = Integer.toString(i);
			aux1++;
		}
		int aux2 = 0;
		for (int i = Constantes.PRIMER_KG; i <= Constantes.ULTIMO_KG; i++) {
			kgCombo[aux2] = Integer.toString(i);
			aux2++;
		}
	}

	public void rellenarDatos(Paciente pacienteActual) throws ParseException {
		this.txt_Nombre.setText(pacienteActual.getNombre());
		this.txt_Apellido.setText(pacienteActual.getApellido());
		this.txt_DNI.setText(pacienteActual.getDni());
		// Fecha Nacimiento
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fecha = pacienteActual.getFechaNacimiento();
		Date fechaNac = sdf.parse(fecha);
		this.dateChooser.setDate(fechaNac);
		this.txt_Nombre.setText(pacienteActual.getNombre());
		// COMBOBOX SEXO
		int indiceSexo = 2;
		String sexo = pacienteActual.getSexo();
		if (sexo.equalsIgnoreCase(Constantes.HOMBRE)) {
			indiceSexo = 0;
		} else if (sexo.equalsIgnoreCase(Constantes.MUJER)) {
			indiceSexo = 1;
		}
		this.cb_Sexo.setSelectedIndex(indiceSexo);
		// COMBOBOX ALTURA
		int alturaAux = pacienteActual.getAltura();
		int indiceAltura = alturaAux - Constantes.PRIMERA_ALTURA;
		this.cb_Altura.setSelectedIndex(indiceAltura);
		// COMBOBOX KG
		int kgAux = pacienteActual.getKg();
		int indiceKg = kgAux - Constantes.PRIMER_KG;
		this.cb_Kg.setSelectedIndex(indiceKg);
		// COMBOBOX GRAMOS
		int gramosAux = pacienteActual.getGramos();
		int indiceGramos = 0;
		if (gramosAux == 250) {
			indiceGramos = 1;
		} else if (gramosAux == 500) {
			indiceGramos = 2;
		} else if (gramosAux == 750) {
			indiceGramos = 3;
		}
		this.cb_Gramos.setSelectedIndex(indiceGramos);
		this.txt_Comunidad.setText(pacienteActual.getComunidad());
		this.txt_Provincias.setText(pacienteActual.getProvincia());
		this.txt_Municipio.setText(pacienteActual.getMunicipio());
		this.txt_Direccion.setText(pacienteActual.getCalle());
		this.txt_CP.setText(pacienteActual.getCp());
		this.txt_Tel.setText(pacienteActual.getTelefono());
		this.txt_Email.setText(pacienteActual.getEmail());

	}
}
