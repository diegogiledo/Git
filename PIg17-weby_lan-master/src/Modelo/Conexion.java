package Modelo;
//Diego
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Control.ControladorAdmin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Conexion {

	String BBDDName = "Weby_Lan BBDD.db";
	Connection c = null;
	Statement stmt = null;

	public Conexion() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			if (c != null) {
				// System.out.println("conectado con la base de datos: " +
				// BBDDName);
			}
		} catch (Exception e) {
			System.err.println("error conectando con la bbdd" + e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public void consulta() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Pacientes;");

			while (rs.next()) {
				String name = rs.getString("Nombre");
				System.out.println("nombre = " + name);
			}

			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public String usuarioCorrecto(String nombreUsuario) {
		String rol = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select Usuarios.Rol from Usuarios where Usuarios.Usuario=" + "'" + nombreUsuario + "'");

			while (rs.next()) {
				rol = rs.getString("rol");
				System.out.println("rol = " + rol);
			}

			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return rol;
	}
	public List<Paciente> cargarPacientesBDD(){
		List<Paciente> lstPaciente = new ArrayList<Paciente>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Pacientes;");

			while (rs.next()) {

				String fechaNacimiento = rs.getString("FechaNac");
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellidos");
				String dni = rs.getString("DNIPAC");
				int altura = rs.getInt("Altura");
				int kg = rs.getInt("Peso");
				int gramos = rs.getInt("Gramos");
				String comentario = rs.getString("Comentario");
				String provincia = rs.getString("Provincia");
				String municipio = rs.getString("Municipio");
				String calle = rs.getString("Calle");
				//String estado = rs.getString("Estado");
				String cp = rs.getString("Cp");
				String telefono = rs.getString("Telefono");
				//List<String> electros;

				Paciente newPac = new Paciente ();
				newPac.setFechaNacimiento(fechaNacimiento);
				newPac.setAltura(altura);
				newPac.setKg(kg);
				newPac.setGramos(gramos);
				newPac.setComentario(comentario);
				newPac.setNombre(nombre);
				newPac.setApellido(apellido);
				newPac.setDni(dni);
				newPac.setProvincia(provincia);
				newPac.setMunicipio(municipio);
				newPac.setCalle(calle);
				//newPac.setEstado(estado);
				newPac.setCp(cp);
				newPac.setTelefono(telefono);
				lstPaciente.add(newPac);// Añadimos los pacientes a lstMedico

			}
			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return lstPaciente;

	}
		
	
	public List<Tecnico> cargarTecnicosBDD() {
		List<Tecnico> lstTecnico = new ArrayList<Tecnico>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Tecnicos;");

			while (rs.next()) {

				String dni = rs.getString("DNITEC");
				String rol = rs.getString("Rol");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String nombreUsuario = rs.getString("Usuario");
				String email = rs.getString("Email");
				String provincia = rs.getString("Provincia");
				String sexo = rs.getString("Genero");

				Tecnico tecnico = new Tecnico(nombreUsuario, nombre, apellidos, dni, email, provincia, sexo);
				lstTecnico.add(tecnico);// Añadimos los tencnicos a lstTecnico

			}
			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return lstTecnico;

	}

	// Cargar los medicos en la tabla del administrador
	public List<Medico> cargarMedicosBBDD() {
		List<Medico> lstMedico = new ArrayList<Medico>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Medicos;");

			while (rs.next()) {

				String dni = rs.getString("DNI");
				String rol = rs.getString("Rol");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String nombreUsuario = rs.getString("Usuario");
				String email = rs.getString("Email");
				String ciudad = rs.getString("Ciudad");
				String sexo = rs.getString("Genero");
				String hospital = rs.getString("Hospital");
				int telefono = rs.getInt("Telefono");

				Medico medico = new Medico(nombreUsuario, rol, nombre, apellidos, dni, email, hospital, ciudad,
						telefono, sexo);
				lstMedico.add(medico);
			}

			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Consulta terminada");

		return lstMedico;

	}

	public void agregarUsuarioBBDD(String id, String nombre, Object rol, String apellidos) {
		System.out.println(id + nombre + rol + apellidos);

		// si el rol es tecnico lo añadimos en la tabla de tecnicos
		if (rol.equals("Tecnico")) {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);

				stmt = c.createStatement();

				stmt.executeUpdate("INSERT INTO Tecnicos (Usuario,Rol,Nombre,Apellidos) " + "VALUES ('" + id + "','"
						+ rol + "','" + nombre + "','" + apellidos + "');");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
			// si el rol no es tecnico lo añadimos en la tabla de medicos
		} else {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);
				stmt = c.createStatement();

				stmt.executeUpdate("INSERT INTO Medicos (Usuario,Rol,Nombre,Apellidos) " + "VALUES ('" + id + "','"
						+ rol + "','" + nombre + "','" + apellidos + "');");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}

		}

	}

	public void modificarUsuario(String dniViejo, String dniNuevo, String rolViejo, String rolNuevo, String nombre,
			String apellidos) {
		if (rolViejo.equals("Tecnico")) {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);
				stmt = c.createStatement();

				stmt.executeUpdate("UPDATE Tecnicos SET DNITEC= '" + dniNuevo + "', Nombre = '" + nombre + "' , Rol = '"
						+ rolNuevo + "', Apellidos = '" + apellidos + "'  WHERE DNITEC='" + dniViejo + "';");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}

		} else {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);
				stmt = c.createStatement();

				stmt.executeUpdate("UPDATE Medicos SET DNI= '" + dniNuevo + "', Nombre = '" + nombre + "' , Rol = '"
						+ rolNuevo + "', Apellidos = '" + apellidos + "'  WHERE DNI='" + dniViejo + "';");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}

		}

	}

	public void eliminarUsuario(String dni, String rol) {

		if (rol.equals("Tecnico")) {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);
				stmt = c.createStatement();

				stmt.executeUpdate("delete from Tecnicos where Tecnicos.DNITEC='" + dni + "';");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}

		} else {
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
				c.setAutoCommit(false);
				stmt = c.createStatement();

				stmt.executeUpdate("delete from Medicos where Medicos.DNI='" + dni + "';");

				stmt.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		}
	}

	public Boolean comprobarUsuario(String usuario, String auxPass) {
		boolean correcto = false;
		String usuarioAux;
		String contrasenaAux;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select Usuario, Contrasena from Usuarios where Usuarios.Usuario =('" + usuario + "');");

			while (rs.next()) {
				usuarioAux = rs.getString("Usuario");
				contrasenaAux = rs.getString("Contrasena");
				System.out.println("Usuario procedente de bbdd: " + usuarioAux);
				System.out.println("Contrasena procedente de bbdd: " + contrasenaAux);
				if (usuario.equals(usuarioAux) && auxPass.equals(contrasenaAux)) {
					correcto = true;

				} else {
					System.out.println("usuario y/o contrasena incorrectos");
				}
			}

			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return correcto;
	}

}
