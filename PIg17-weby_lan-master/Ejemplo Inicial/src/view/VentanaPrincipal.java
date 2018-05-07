package view;
import control.*;

 


import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



/**
 * @author  pedro
 */
public class VentanaPrincipal extends JFrame
{
	MainController controlador;
	
	public VentanaPrincipal () {
		super();
		
		// Creamos la vista 
		setSize(600, 600);
		setTitle("VentanaPrincipal");
		
		
	}
	
	public void addController (MainController mc)
	{
		controlador=mc;
		
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				System.exit(0);
			}
		});
	}
	
	public void crearVista ()
	{
		crearMenu();
		
		setContentPane(new JDesktopPane());
		setVisible(true);
	}
	
	public void crearMenu ()
	{	

          JMenuBar menuBar;
          JMenu menu, submenu;
          JMenuItem menuItem;
          
          //Crea la barra de menú
          menuBar = new JMenuBar();
          setJMenuBar(menuBar);

          //Primer menú
          menu = new JMenu("Usuario");
          menu.setMnemonic(KeyEvent.VK_U);
 
          //Submenú 1
          menuItem = new JMenuItem("Lista",
                                   KeyEvent.VK_L);
          menuItem.getAccessibleContext().setAccessibleDescription(
                  "Lista");
          // Añadimos controlador al item de menú
          menuItem.addActionListener(controlador);
          // Asociamos un comando del controlador
          menuItem.setActionCommand(MainController.LISTA);
          menu.add(menuItem);
          
          //Submenú 2
          menuItem = new JMenuItem("Tabla",
                                   KeyEvent.VK_T);
          menuItem.getAccessibleContext().setAccessibleDescription(
                  "Tabla");
          // Añadimos controlador al item de menú
          menuItem.addActionListener(controlador);
          // Asociamos un comando del controlador
          menuItem.setActionCommand(MainController.TABLA);
          menu.add(menuItem);
          
         
          
          menuBar.add(menu);
	}


}
