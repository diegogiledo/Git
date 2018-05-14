package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fichero {

	
	

	/**
	 * Funcion que carga todos los medicos del sistema
	 *
	 * @return Lista de Medicos
	 * @throws IOException
	 */


	/**
	 * Funcion que carga un médico por su nickname(NombreUsuario)
	 *
	 * @param nombreUsuario
	 * @return Medico
	 * @throws IOException
	 */
	public Medico cargarMedicoID(String nombreUsuario) throws IOException {
		File ficheroMedico = new File(Constantes.RELATIVO + File.separator + Constantes.CARPETABBDD + File.separator
				+ Constantes.FICHEROMEDICOS);// Indicamos
		BufferedReader lector = new BufferedReader(new FileReader(ficheroMedico)); // establezco
																					// fichero
																					// de
																					// solo
																					// lectura
		String linea;
		Medico medico = null;
		try {
			boolean existe = false;
			while ((linea = lector.readLine()) != null && !existe) { // inicia
																		// búsqueda
																		// del
																		// usuario
				String[] lineatxt = linea.split(Constantes.SEPARADOR);
				String auxNombreUsuario = lineatxt[Constantes.POS_MED_NOMBRE_USUARIO];
				if (auxNombreUsuario.equalsIgnoreCase(nombreUsuario)) {
					existe = true;

					String nombre = lineatxt[Constantes.POS_MED_NOMBRE];
					String apellido = lineatxt[Constantes.POS_MED_APELLIDO];
					String dni = lineatxt[Constantes.POS_MED_DNI];
					String hospital = lineatxt[Constantes.POS_MED_HOSPITAL];
					String ciudad = lineatxt[Constantes.POS_MED_CIUDAD];
					String telefono = lineatxt[Constantes.POS_MED_TELEFONO];
					String email = lineatxt[Constantes.POS_MED_EMAIL];
					String sexo = lineatxt[Constantes.POS_MED_SEXO];
					List<String> lstIdPaciente = new ArrayList<String>();
					for (int i = Constantes.POS_MED_PRIMER_PACIENTE; i < lineatxt.length; i++) {
						lstIdPaciente.add(lineatxt[i]);
					}

					List<Paciente> lstPaciente = cargarPacientesMed(lstIdPaciente);
					medico = new Medico(auxNombreUsuario, nombre, apellido, dni, hospital, ciudad, telefono, email,
							sexo, lstPaciente);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lector.close();
		return medico;
	}

	/**
	 * Funcion que carga todos los pacientes@@@@@@@@@@@@@
	 *
	 * @return Lista todos los pacientes
	 * @throws IOException
	 */
	public List<Paciente> cargarPacientes() throws IOException {
		File ficheroPacientes = new File(Constantes.RELATIVO + File.separator + Constantes.CARPETABBDD + File.separator
				+ Constantes.FICHEROPACIENTES);// Indicamos
		BufferedReader lector = new BufferedReader(new FileReader(ficheroPacientes)); // establezco
																						// fichero
																						// de
																						// solo
																						// lectura
		String linea;
		List<Paciente> lstPaciente = new ArrayList<Paciente>();
		try {
			while ((linea = lector.readLine()) != null) { // inicia búsqueda del
															// usuario
				String[] lineatxt = linea.split(Constantes.SEPARADOR);
				String nombre = lineatxt[Constantes.POS_PAC_NOMBRE];
				String apellido = lineatxt[Constantes.POS_PAC_APELLIDO];
				String dni = lineatxt[Constantes.POS_PAC_DNI];
				String ciudad = lineatxt[Constantes.POS_PAC_CIUDAD];
				String calle = lineatxt[Constantes.POS_PAC_CALLE];
				String estado = lineatxt[Constantes.POS_PAC_ESTADO];
				String sexo = lineatxt[Constantes.POS_PAC_SEXO];
				String comentario = lineatxt[Constantes.POS_PAC_COMENTARIO];
				String fechaNac = lineatxt[Constantes.POS_PAC_FECHANAC];
				int altura = Integer.parseInt(lineatxt[Constantes.POS_PAC_ALTURA]);
				int kg = Integer.parseInt(lineatxt[Constantes.POS_PAC_KG]);
				int gramos = Integer.parseInt(lineatxt[Constantes.POS_PAC_GRAMOS]);
				String comunidad = lineatxt[Constantes.POS_PAC_COMUNIDAD];
				String provincia = lineatxt[Constantes.POS_PAC_PROVINCIA];
				String cp = lineatxt[Constantes.POS_PAC_CP];
				String telefono = lineatxt[Constantes.POS_PAC_TELEFONO];
				String email = lineatxt[Constantes.POS_PAC_EMAIL];
				List<String> electros = new ArrayList<String>();
				// Primer ECG del paciente
				for (int i = Constantes.POS_PAC_PRIMER_ECG; i < lineatxt.length; i++) {
					electros.add(lineatxt[i]);
				}
				Paciente paciente = new Paciente(dni, nombre, apellido, email, sexo, fechaNac, altura, kg, gramos,
						comentario, comunidad, provincia, ciudad, calle, estado, cp, telefono, electros);
				lstPaciente.add(paciente);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lector.close();
		return lstPaciente;
	}

	/**
	 * Funcion que carga los pacientes asociados a un médico@@@@@@@@@@
	 *
	 * @param Lista
	 *            DNI pacientes
	 * @return Lista de pacientes de un medico
	 * @throws IOException
	 */
	public List<Paciente> cargarPacientesMed(List<String> lstIdPaciente) throws IOException {
		File ficheroPacientes = new File(Constantes.RELATIVO + File.separator + Constantes.CARPETABBDD + File.separator
				+ Constantes.FICHEROPACIENTES);// Indicamos
		BufferedReader lector = new BufferedReader(new FileReader(ficheroPacientes)); // establezco
																						// fichero
																						// de
																						// solo
																						// lectura
		String linea;
		List<Paciente> lstPaciente = new ArrayList<Paciente>();
		try {
			while ((linea = lector.readLine()) != null && !lstIdPaciente.isEmpty()) { // inicia
																						// búsqueda
																						// del
																						// usuario
				String[] lineatxt = linea.split(Constantes.SEPARADOR);
				String dni = lineatxt[Constantes.POS_PAC_DNI];
				if (lstIdPaciente.contains(dni)) {
					String nombre = lineatxt[Constantes.POS_PAC_NOMBRE];
					String apellido = lineatxt[Constantes.POS_PAC_APELLIDO];
					String ciudad = lineatxt[Constantes.POS_PAC_CIUDAD];
					String calle = lineatxt[Constantes.POS_PAC_CALLE];
					String estado = lineatxt[Constantes.POS_PAC_ESTADO];
					String sexo = lineatxt[Constantes.POS_PAC_SEXO];
					String comentario = lineatxt[Constantes.POS_PAC_COMENTARIO];
					String fechaNac = lineatxt[Constantes.POS_PAC_FECHANAC];
					int altura = Integer.parseInt(lineatxt[Constantes.POS_PAC_ALTURA]);
					int kg = Integer.parseInt(lineatxt[Constantes.POS_PAC_KG]);
					int gramos = Integer.parseInt(lineatxt[Constantes.POS_PAC_GRAMOS]);
					String comunidad = lineatxt[Constantes.POS_PAC_COMUNIDAD];
					String provincia = lineatxt[Constantes.POS_PAC_PROVINCIA];
					String cp = lineatxt[Constantes.POS_PAC_CP];
					String telefono = lineatxt[Constantes.POS_PAC_TELEFONO];
					String email = lineatxt[Constantes.POS_PAC_EMAIL];
					List<String> electros = new ArrayList<String>();
					// Primer ECG del paciente
					for (int i = Constantes.POS_PAC_PRIMER_ECG; i < lineatxt.length; i++) {
						electros.add(lineatxt[i]);
					}
					Paciente paciente = new Paciente(dni, nombre, apellido, email, sexo, fechaNac, altura, kg, gramos,
							comentario, comunidad, provincia, ciudad, calle, estado, cp, telefono, electros);
					lstPaciente.add(paciente);
					lstIdPaciente.remove(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lector.close();
		return lstPaciente;
	}

	/**
	 * Funcion que carga un electro
	 *
	 * @param Path
	 *            del archivo(Absoluto)
	 * @return Electro
	 * @throws IOException
	 */
	public Electro cargarElectro(String path) throws IOException {
		Electro electro = null;
		File ficheroECG = new File(path);// Indicamos
		BufferedReader lector = new BufferedReader(new FileReader(ficheroECG)); // establezco
																				// fichero
																				// de
																				// solo
																				// lectura
		double intervalo;
		String[] medicion;
		String comentario;
		try {
			intervalo = (1 / Float.parseFloat(lector.readLine()));// Intervalo
																	// (1/mediciones/segundo)
			medicion = lector.readLine().split(Constantes.SEPARADOR);// Mediciones
																		// conjunto
			comentario = lector.readLine();
			if (comentario == null) {
				comentario = Constantes.COMENTARIOINICIALECG;
			}
			electro = new Electro(medicion, intervalo, comentario);

		} catch (IOException e) {
			e.printStackTrace();
		}
		lector.close();
		return electro;
	}

	public Electro cargarElectroMed(String archivo) throws IOException {
		Electro electro = null;
		File ficheroECG = new File(Constantes.RELATIVO + File.separator + Constantes.CARPETABBDD + File.separator
				+ archivo + Constantes.EXTENSIONTXT);// Indicamos
		BufferedReader lector = new BufferedReader(new FileReader(ficheroECG)); // establezco
																				// fichero
																				// de
																				// solo
																				// lectura
		double intervalo;
		String[] medicion;
		String comentario;
		try {
			intervalo = (1 / Float.parseFloat(lector.readLine()));// Intervalo
																	// (1/mediciones/segundo)
			medicion = lector.readLine().split(Constantes.SEPARADOR);// Mediciones
																		// conjunto
			comentario = lector.readLine();
			if (comentario == null) {
				comentario = Constantes.COMENTARIOINICIALECG;
			}
			electro = new Electro(medicion, intervalo, comentario);

		} catch (IOException e) {
			e.printStackTrace();
		}
		lector.close();
		return electro;
	}

}