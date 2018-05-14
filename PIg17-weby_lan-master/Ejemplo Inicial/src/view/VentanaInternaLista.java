package view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import control.*;


public class VentanaInternaLista extends JInternalFrame{
	

	public JPanel panel;
	public JButton botonSeleccionar;
	public JComboBox usersList; 
	public JTextField campoNombre;
	public JTextField campoApellido;
	public JButton botonModificar;
	public UsersController controlador;
	
	static int xPos=100;
	static int yPos=100;
	
	
    /**
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 * @param iconifiable
	 */
	public VentanaInternaLista() {
		super("Usuarios", true, true, true, true);
	}

	public void crearVista() {
    	this.getContentPane().setLayout(new FlowLayout());
		
		JPanel panelDelCombo = new JPanel();
		JPanel panelDelUsuario = new JPanel();
		
		
		this.getContentPane().add(panelDelCombo);
		this.getContentPane().add(panelDelUsuario);
		this.setSize(450,250);
		this.setLocation(xPos, yPos);
        xPos=xPos+10;
        yPos=yPos+10;

		// Dibujo el panel del Combo

		JLabel label1 = new JLabel ("Gestión de Usuarios");
        panelDelCombo.add (label1);
       		
        usersList = new JComboBox(controlador.controlPrincipal.listaUsuarios);
        usersList.setSelectedIndex(0);
        panelDelCombo.add (usersList);
       
        botonSeleccionar = new JButton ("Seleccionar");
        panelDelCombo.add (botonSeleccionar);
        
        // Añado el controlador como Listener
        botonSeleccionar.addActionListener(controlador);
		botonSeleccionar.setActionCommand(UsersController.SELECCIONAR);
		
		// Dibujo el panel del Usuario
 
		panelDelUsuario.setLayout(new FlowLayout());
		 
        JLabel labelNombre = new JLabel ("Nombre");
        labelNombre.setSize(200,30);
        panelDelUsuario.add (labelNombre);
        
        campoNombre = new JTextField ("Sin Seleccionar");
        panelDelUsuario.add (campoNombre);
 		
        JLabel labelApellido = new JLabel ("Apellido");
        labelNombre.setSize(200,30);
        panelDelUsuario.add (labelApellido);
        
        campoApellido = new JTextField ("Sin Seleccionar");
        panelDelUsuario.add (campoApellido);
        
        botonModificar = new JButton ("Modificar");
        panelDelUsuario.add (botonModificar);
        
        // Añado el controlador como Listener
        botonModificar.addActionListener(controlador);
        botonModificar.setActionCommand(UsersController.MODIFICAR);

//      this.setResizable(false);
        this.setVisible(true);
        
    }
    
    public void addController (UsersController uc)
	{
    	
    	controlador = uc;
	}

}
