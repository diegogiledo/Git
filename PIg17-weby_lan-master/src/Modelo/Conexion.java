package Modelo;

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
				lstTecnico.add(tecnico);// A√±adimos los tencnicos a lstTecnico

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

		// si el rol es tecnico lo a√±adimos en la tabla de tecnicos
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
			// si el rol no es tecnico lo a√±adimos en la tabla de medicos
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

	public List<Paciente> cargarPacientesBBDD() {
		List<Paciente> lstPaciente = new ArrayList<Paciente>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Pacientes;");

			while (rs.next()) {

				String dni = rs.getString("DNIPAC");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String email = rs.getString("Email");

				// ampliarinfo
				String municipio = rs.getString("Municipio");
				String calle = rs.getString("Calle");
				String estado = rs.getString("Estado");
				String sexo = rs.getString("Sexo");
				String comentario = rs.getString("Comentario");
				String fechaNac = rs.getString("FechaNac");
				int altura = rs.getInt("Altura");
				int peso = rs.getInt("Peso");
				int gramos = rs.getInt("Gramos");
				String provincia = rs.getString("Provincia");
				String cp = rs.getString("Cp");
				String ccaa = rs.getString("CCAA");
				String telefono = rs.getString("Telefono");
				
			

				Paciente paciente = new Paciente(dni, nombre, apellidos, email, municipio, calle, estado, sexo,
						comentario, fechaNac, altura, peso, gramos, provincia, cp, ccaa, telefono);
				lstPaciente.add(paciente);
			}

			rs.close();
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Consulta terminada");

		return lstPaciente;
	}

//	public void ampliarInfo(String dni){
//		try {
//			Class.forName("org.sqlite.JDBC");
//			c = DriverManager.getConnection("jdbc:sqlite:" + BBDDName);
//			c.setAutoCommit(false);
//
//			stmt = c.createStatement();
//			ResultSet rs = stmt.executeQuery(
//					"select * from Pacientes where Pacientes.DNIPAC = '"+dni+"'");
//
//			while (rs.next()) {
//				String dniPac = rs.getString("DNIPAC");
//				String nombre = rs.getString("Nombre");
//				String apellidos = rs.getString("Apellidos");
//				String email = rs.getString("Email");
//
//				// ampliarinfo
//				 String municipio = rs.getString("Municipio");
//				 String calle = rs.getString("Calle");
//				 String estado = rs.getString("Estado");
//				 String sexo = rs.getString("Sexo");
//				 String comentario = rs.getString("Comentario");
//				 String fechaNac = rs.getString("FechaNac");
//				 int altura = rs.getInt("Altura");
//				 int peso = rs.getInt("Peso");
//				 int gramos = rs.getInt("Gramos");
//				 String provincia = rs.getString("Provincia");
//				 String ccaa = rs.getString("CCAA");
//				 int telefono = rs.getInt("Telefono");
//
//				 Usuario usuario = new Usuario(dni,);
//				
//			}
//
//			rs.close();
//			c.commit();
//			stmt.close();
//			c.close();
//		} catch (Exception e) {
//			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//		}
//		
//		
//	}
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
				lstPaciente.add(newPac);// A√É¬±adimos los pacientes a lstMedico

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
}

/*select Provincias.Nombre 
from Provincias 
join CCAA on Provincias.id_CCAA = CCAA.id_CCAA
where nombreID ='Galicia';
para sumar los km2 de todos los municipios de pontevedra
select Provincias.nombre, sum(km2.Superficie)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre ='LeÛn';
para contar los municipios de pontevedra
select Provincias.nombre, count(km2.Superficie)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre ='Pontevedra';
contar las provincias cuyo id es 24 y 25
select count(*)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.ID_PRV in (24,25);
ahora lo mismo pero cuyo nombre es lugo o pontevedra
select count(*)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre in ('Pontevedra', 'Lugo');
el as es para cambiar el nombre de la columna que se visualiza
select count(*) as NumeroDeMunicipios
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre in ('Pontevedra', 'Lugo');
para sacar las que empiezan por M
select * from CCAA 
where nombreID like'M%'
para sacar las ccaa con id 10 12 o 15
select * from CCAA 
where ID_CCAA in (10,12,15);
las ccaa que tienen a como segunda letra
select * from CCAA 
where nombreid like '_a%';
MUNICIPIOS CON MAYOR NUMERO DE POBLACION Y LA PROVINCIA A LA QUE PERTENECEN
select Municipios.Nombre, Provincias.Nombre, HYM FROM Municipios
join Habitantes on Habitantes.ID_MUN = Municipios.ID_MUN
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
order by hym desc
limit 10;
cambiar base de datos
update Provincias
set nombre = 'Varcelona'
where id_PRV = 8;
Municipios de madrid
select Municipios.nombre from Municipios 
join provincias on  Provincias.ID_PRV=Municipios.ID_PRV
where Provincias.Nombre ='Madrid';
sacar el numero total de habitantes de cada ccaa
select CCAA.Nombre, sum(habitantes.hym) as 'Habitantes totales' from Municipios
join habitantes on Municipios.ID_MUN = habitantes.ID_MUN
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join CCAA on Provincias.ID_CCAA = CCAA.ID_CCAA
group by CCAA.Nombre
BASE DE DATOS LIBROS
para ver cual es el libro mas leido nos vamos a la tabla de ratings
y contamos el isbn que mas se repite
select RATINGS.ISBN, count(ratings.isbn) as num
from ratings
group by ratings.isbn
order by num desc;
los libros mas leidos son:
select books.Title, books.Author, count(ratings.isbn) as num
from ratings
join Books on books.ISBN = Ratings.ISBN
group by ratings.isbn
order by num desc;
el niÒo que mas libros ha leido
select ratings.UserID,Users.Age,count(ratings.UserID) as num
from ratings
join Users on ratings.UserID=Users.UserID
where Users.Age >7 and Users.Age <15
group by ratings.UserID
order by num desc;
libros mas leidos por espaÒoles
select books.Title, count(Books.isbn) as num
from Books
join ratings on Books.ISBN=Ratings.Isbn
join Users on Users.UserID = Ratings.Userid
where Users.Location like '%spain%'
group by books.ISBN
order by num desc;
PARA CREAR UNA TABLA NUEVA QUE CONTENGA TITULO Y LOCATION DEL USUARIO QUE LO HA LEIDO:
create view librouser as 
select books.Title, users.Location
from Books
join Ratings on ratings.ISBN=books.ISBN
join Users on Users.UserID=Ratings.UserID */


