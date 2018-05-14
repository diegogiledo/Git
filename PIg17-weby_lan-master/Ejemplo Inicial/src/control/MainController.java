package control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import model.*;
import view.*;

;public class MainController implements ActionListener
{
	public final static String LISTA="L";
	public final static String TABLA="T";
	
	public JFrame ventanaControlada;
	public ManejadorDeFichero mf;
	public Vector listaUsuarios;
	
	public MainController(JFrame win){
		ventanaControlada=win;
		listaUsuarios = new Vector<Usuario>();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// Cambio el cursor por un relog
		Cursor cur = new Cursor(Cursor.WAIT_CURSOR);
        ventanaControlada.setCursor(cur);        

    	String cmd = (String)(e.getActionCommand());
        abrirVentana(cmd);
		
		// Dejo el cursor como estaba
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
        ventanaControlada.setCursor(cur);        
    } 
    
    public void abrirVentana(String cmd)
	{
		int respuesta=JOptionPane.showConfirmDialog(ventanaControlada, 
						"¿Seguro?", "¿Seguro?", JOptionPane.YES_NO_OPTION);
		if (respuesta==JOptionPane.YES_OPTION)
		{
			
			if (cmd.equals(MainController.LISTA)) {

				// Creo la ventana para representarlo
				VentanaInternaLista interna = new VentanaInternaLista();

				// Creo el controlador pasando la ventana
				UsersController ic = new UsersController(interna, this);
				
				// Le Asociamos el controlador a la ventana
				interna.addController(ic);
				interna.crearVista();

				// La añado a la ventana principal
				ventanaControlada.getContentPane().add(interna);
				try {
					interna.setSelected(true);
				} catch (Exception e) {
					System.out
							.println("Error tratando de seleccionar la ventana:"
									+ e.getMessage());
					return;
				}
				interna.toFront();
			} else {
				
				// Mostrar Ventana para TABLA
			}
			
		}
	}	

	public void cerrarVentana()
	{
		ventanaControlada.dispose();
		System.exit(0);
	}	

	public static void main(String args[])
	{
		System.out.println("Starting VentanaPrincipal...");
		
		// Leyendo el Properties
		
		Properties appProps = new Properties();
		
		String usersPath="";
		
        try {
        	FileInputStream in = new FileInputStream("ejemplo.properties");
    		appProps.load(in);
        	in.close();
        
        	usersPath=appProps.getProperty("UsersPath");
        	
 		} catch (Exception e) { System.out.println(e.getMessage()); }
		
 		
		// Creo la ventana
		VentanaPrincipal mainFrame = new VentanaPrincipal();
		
		// Creo el controlador pasando la ventana
		MainController mc=new MainController(mainFrame);
		
		// Le Asociamos el controlador a la ventana
		mainFrame.addController(mc);
		mainFrame.crearVista();
		
		//Leer Usuarios
 		mc.mf = new ManejadorDeFichero();
 		mc.listaUsuarios =  mc.mf.leerUsuarios(usersPath, ";");
 		
		
 		System.out.println(mc.listaUsuarios);
	}
}
