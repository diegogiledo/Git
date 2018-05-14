package Modelo;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AgregarArchivo {

	public String abrir() throws FileNotFoundException {
		JFileChooser jf = new JFileChooser();
		// Restringimos archivos txt
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
		jf.setFileFilter(filtro);
		// Sobreescribimos a falso la posibilidad de utilizar cualquier archivo
		jf.setAcceptAllFileFilterUsed(false);
		String ruta = Constantes.VACIO;
		if (jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jf.getSelectedFile();
			ruta = file.getAbsolutePath();
		} else {
			ruta = Constantes.NOSELECCION;
		}
		return ruta;
	}

}
