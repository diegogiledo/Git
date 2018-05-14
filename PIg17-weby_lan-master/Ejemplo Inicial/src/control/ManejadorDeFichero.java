package control;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import model.*;

class ManejadorDeFichero {
	String fichero;
	String separador;

	public void escribirUsuarios(Vector<Usuario> lista) {

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fichero)));
			for (int i = 0; i < lista.size(); i++) {

				Usuario u = (Usuario)lista.get(i);
				out.println(u.nombre+";"+u.apellido);
				out.flush();
			}
		} catch (IOException e) {
			System.out.println("Error escribiendo el fichero de usuarios");
		}
	}

	public Vector<Usuario> leerUsuarios(String fichero, String separador) {
		this.fichero = fichero;
		this.separador = separador;
		Vector<Usuario> listaUsuarios = new Vector<Usuario>();

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));

			do {
				line = lector.readLine();
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);
					Usuario nuevo = new Usuario(st.nextToken(), st.nextToken());
					listaUsuarios.add(nuevo);
				}
			} while (line != null);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}

		return listaUsuarios;
	}
}
