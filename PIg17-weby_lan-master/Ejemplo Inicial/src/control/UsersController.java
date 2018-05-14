package control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.*;
import view.*;

;/**
 * @author  pedro
 */
public class UsersController implements ActionListener
{
	public final static String SELECCIONAR="S";
	public final static String MODIFICAR="M";

	
	
	public VentanaInternaLista ventanaControlada;
	public MainController controlPrincipal;
	
	public UsersController(VentanaInternaLista win, MainController mc)	{
		ventanaControlada = win;
		controlPrincipal = mc;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// Cambio el cursor por un relog
		Cursor cur = new Cursor(Cursor.WAIT_CURSOR);
        ventanaControlada.setCursor(cur);        

    	String cmd = (String)(e.getActionCommand());
        if (cmd == UsersController.MODIFICAR) {
        	Usuario user = (Usuario)ventanaControlada.usersList.getSelectedItem();
        	user.nombre=ventanaControlada.campoNombre.getText();
        	user.apellido=ventanaControlada.campoApellido.getText();
        	
        	ventanaControlada.usersList.repaint(); //Para que se actualice el cambio en el combo
        	controlPrincipal.mf.escribirUsuarios(controlPrincipal.listaUsuarios);
        	ventanaControlada.dispose();
		} else if (cmd==UsersController.SELECCIONAR) {
        	Usuario user = (Usuario)ventanaControlada.usersList.getSelectedItem();
			
			ventanaControlada.campoNombre.setText(user.nombre);
			ventanaControlada.campoApellido.setText(user.apellido);
			
		}
        
        // Dejo el cursor como estaba
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
        ventanaControlada.setCursor(cur);        
    } 
    
    public void mostrar(String mensaje)
	{
		JOptionPane.showMessageDialog(ventanaControlada, mensaje);	
	}	

}