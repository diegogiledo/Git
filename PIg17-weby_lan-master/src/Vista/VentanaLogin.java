package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Control.ControladorLogin;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private ControladorLogin controlador;
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JPanel panelLogo = new JPanel();
	public JPanel panelUsuario = new JPanel();
	public JPanel panelContrasena = new JPanel();
	public JPanel panelLogin = new JPanel();
	public JLabel usuario = new JLabel();
	public JLabel contrasena = new JLabel();
	public JTextField cajaUsuario = new JTextField();
	public JPasswordField cajaContrasena = new JPasswordField();
	public JLabel cajaVacia = new JLabel();
	public JButton btn_aceptar = new JButton();

	public VentanaLogin() throws HeadlessException {
		this.controlador = new ControladorLogin();
		this.controlador.setVentanaControlada(this);
		this.crearVentana();

	}

	public void crearVentana() {
		// configuramos el frame principal
		frame.addKeyListener(controlador);
		frame.setMinimumSize(new Dimension(700, 500));
		frame.setTitle("Weby_lan LOGIN");

		// le damos un color al panel del fondo
		panel.setBackground(Color.white);

		// cofiguramos el panel donde se situa el logo
		panelLogo.setBackground(Color.white);
		panelLogo.setSize(100, 100);
		// configuramos el panel donde esta el label de usuario:
		panelUsuario.setBackground(Color.white);
		panelUsuario.setLayout(new GridLayout(0, 2)); // Gridlayout(int filas,int columnas)
		panelUsuario.setMaximumSize(new Dimension(300, 30));

		usuario.setText("USUARIO:");
		usuario.setFont(new Font("Tahoma", Font.BOLD, 15));

		// configuramos el panel donde esta el label de Contrasena:
		panelContrasena.setBackground(Color.white);
		panelContrasena.setLayout(new GridLayout(0, 2));
		panelContrasena.setMaximumSize(new Dimension(300, 30));

		contrasena.setText("CONTRASEÑA:");
		contrasena.setFont(new Font("Tahoma", Font.BOLD, 15));

		// configuramos el panel donde se situa el boton de aceptar
		panelLogin.setBackground(Color.white);

		// definicion de elementos
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// establecemos el logo en el panel superior
		ImageIcon image = new ImageIcon("." + File.separator + "img" + File.separator + "LOGOPRUEBA.png");
		JLabel imagelabel = new JLabel(image);
		imagelabel.setBounds(100, 100, 1, 1);

		// configuramos el boton de aceptar
		btn_aceptar.setText("ACEPTAR");
		btn_aceptar.setOpaque(true);
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setForeground(Color.WHITE);
		btn_aceptar.setBackground(new Color(139, 0, 0));

		// le pasamos el controlador a los distitos elementos
		cajaUsuario.addKeyListener(controlador);
		cajaContrasena.addKeyListener(controlador);
		btn_aceptar.addActionListener(controlador);

		// le damos los bordes coloreados a las cajas que contienen el usuario y la contrasena
		cajaUsuario.setBorder(new LineBorder(new Color(139, 0, 0), 3, true));
		cajaContrasena.setBorder(new LineBorder(new Color(139, 0, 0), 3, true));

		// ensamblaje de elementos en sus paneles correspondientes
		panelLogo.add(imagelabel);

		cajaUsuario.setBorder(new LineBorder(new Color(139, 0, 0), 3, true));
		cajaContrasena.setBorder(new LineBorder(new Color(139, 0, 0), 3, true));

		panelUsuario.add(usuario);
		panelUsuario.add(cajaUsuario);
		panelUsuario.add(cajaVacia);

		panelContrasena.add(contrasena);
		panelContrasena.add(cajaContrasena);

		panelLogin.add(btn_aceptar);

		panel.add(panelLogo);
		panel.add(panelUsuario);
		panel.add(panelContrasena);
		panel.add(new JSeparator(JSeparator.VERTICAL));
		panel.add(panelLogin);

		frame.add(panel);

		frame.setVisible(true); // hacemos el frame visible
		frame.setResizable(true); // hacemos el frame redimensionable
		frame.setSize(700, 500); // le damos al frame un tamaño por defecto

	}
}