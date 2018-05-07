package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import Control.ColorearDias;
import Control.ControladorMedico2;
import Modelo.Constantes;
import Modelo.Paciente;

public class VentanaMedico2 extends VentanaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControladorMedico2 controlador;
	private JPanel contentPane;
	private JCalendar calendar;
	private JComboBox<String> comboBox1;
	private JTextField textField;
	private JButton btn_Atras;
	private JButton btn_Visualizar;
	private JScrollPane scrollPane;
	private Paciente paciente;
	private List<String> lstDiasPintados;
	private JComboBox<String> comboBox2;
	private JCheckBox cbx_Comparar;

	public JCheckBox getCbx_Comparar() {
		return cbx_Comparar;
	}

	public void setCbx_Comparar(JCheckBox cbx_Comparar) {
		this.cbx_Comparar = cbx_Comparar;
	}

	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(JComboBox<String> comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public JComboBox<String> getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(JComboBox<String> comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public List<String> getLstDiasPintados() {
		return lstDiasPintados;
	}

	public void setLstDiasPintados(List<String> lstDiasPintados) {
		this.lstDiasPintados = lstDiasPintados;
	}

	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtn_Atras() {
		return btn_Atras;
	}

	public void setBtn_Atras(JButton btn_Atras) {
		this.btn_Atras = btn_Atras;
	}

	public JButton getBtn_Visualizar() {
		return btn_Visualizar;
	}

	public void setBtn_Visualizar(JButton btn_Visualizar) {
		this.btn_Visualizar = btn_Visualizar;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;

	}

	public VentanaMedico2(String nombreUsuario) {
		super(nombreUsuario);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public VentanaMedico2(String nombreUsuario, Paciente paciente) {
		super(nombreUsuario);
		this.paciente = paciente;
		pintarCalendario();
	}

	public void crearVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 718);
		setResizable(false);
		setMinimumSize(new Dimension(900, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		calendar = new JCalendar();

		comboBox1 = new JComboBox<String>();

		scrollPane = new JScrollPane();

		btn_Atras = new JButton("Atras");
		btn_Atras.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btn_Atras.setOpaque(true);
		btn_Atras.setBorderPainted(false);
		btn_Atras.setForeground(Color.WHITE);
		btn_Atras.setBackground(new Color(139, 0, 0));

		btn_Visualizar = new JButton("Visualizar");
		btn_Visualizar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btn_Visualizar.setOpaque(true);
		btn_Visualizar.setBorderPainted(false);
		btn_Visualizar.setForeground(Color.WHITE);
		btn_Visualizar.setBackground(new Color(139, 0, 0));

		cbx_Comparar = new JCheckBox("¿Comparar?");

		comboBox2 = new JComboBox<String>();
		comboBox2.setEnabled(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(calendar, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Visualizar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(btn_Atras, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(cbx_Comparar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox2, 0, 844, Short.MAX_VALUE)
								.addComponent(comboBox1, 0, 844, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbx_Comparar)
							.addGap(93))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Visualizar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Atras, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);

		textField = new JTextField();
		textField.setEditable(false);
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		contentPane.setLayout(gl_contentPane);

		ControladorMedico2 controlador = new ControladorMedico2(this);
		btn_Atras.addActionListener(controlador);
		btn_Visualizar.addActionListener(controlador);
		calendar.addPropertyChangeListener(controlador);
		cbx_Comparar.addMouseListener(controlador);

	}

	public void pintarCalendario() {
		if (paciente != null) {
			List<String> lstEcgs = paciente.getElectros();
			lstDiasPintados = new ArrayList<String>();
			for (String ecg : lstEcgs) {
				String[] aux = ecg.split(Constantes.GUIONBAJO);
				lstDiasPintados.add(aux[1]);
			}
			ColorearDias cd = new ColorearDias(lstDiasPintados);
			JDayChooser dayChooser = calendar.getDayChooser();
			dayChooser.addDateEvaluator(cd);
			dayChooser.setAlwaysFireDayProperty(true);
			calendar.setCalendar(calendar.getCalendar());
		}
	}
}