package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
	public final static String PACIENTE = "Paciente";
	private String fechaNacimiento;
	private int altura;
	private int kg;
	private int gramos;
	private int edad;
	private String comentario;
	private String comunidad;
	private String provincia;
	private String municipio;
	private String calle;
	private String estado;
	private String cp;
	private String telefono;
	private List<String> electros;

	public Paciente(String dni, String nombre, String apellido, String email, String sexo, String fechaNacimiento,
			int altura, int kg, int gramos, String comentario, String comunidad, String provincia, String municipio,
			String calle, String estado, String cp, String telefono, List<String> electros) {
		super(null, null, null, nombre, apellido, dni, email, sexo);
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.kg = kg;
		this.gramos = gramos;
		this.edad = edad();
		this.comentario = comentario;
		this.comunidad = comunidad;
		this.provincia = provincia;
		this.municipio = municipio;
		this.calle = calle;
		this.estado = estado;
		this.cp = cp;
		this.telefono = telefono;
		this.electros = electros;
	}
	// hola

	public Paciente(String nombreUsuario, String contrasena, String tipoUsuario, String nombre, String apellido,
			String dni, String email, String sexo) {
		super(nombreUsuario, contrasena, tipoUsuario, nombre, apellido, dni, email, sexo);
		this.electros = new ArrayList<String>();
	}
	public Paciente(){
		super();
	}

	public Paciente(String dni) {
		super(dni);
		this.electros = new ArrayList<String>();
	}

	

	public Paciente(String dni, String nombre, String apellidos, String email, String municipio, String calle,
			String estado, String sexo, String comentario, String fechaNac, int altura, int peso, int gramos,
			String provincia, String cp, String ccaa, String telefono) {
		super(dni, nombre, apellidos, email, sexo);
		this.fechaNacimiento = fechaNac;
		this.altura = altura;
		this.kg = peso;
		this.gramos = gramos;
		this.edad = edad();
		this.comentario = comentario;
		this.comunidad = ccaa;
		this.provincia = provincia;
		this.municipio = municipio;
		this.calle = calle;
		this.estado = estado;
		this.cp = cp;
		this.telefono = telefono;

		// TODO Auto-generated constructor stub
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public int getGramos() {
		return gramos;
	}

	public void setGramos(int gramos) {
		this.gramos = gramos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<String> getElectros() {
		return electros;
	}

	public void setElectros(List<String> electros) {
		this.electros = electros;
	}

	public int edad() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);// Fecha de
																	// nacimiento
		LocalDate ahora = LocalDate.now();// Fecha actual

		Period periodo = Period.between(fechaNac, ahora);// Diferencia entre
															// fecha nacimiento
															// y fecha actual
		return periodo.getYears();
	}

}

/*[17:39, 5/10/2018] +34 629 04 04 28: select Provincias.Nombre 
from Provincias 
join CCAA on Provincias.id_CCAA = CCAA.id_CCAA
where nombreID ='Galicia';
[17:39, 5/10/2018] +34 629 04 04 28: para sumar los km2 de todos los municipios de pontevedra
[17:39, 5/10/2018] +34 629 04 04 28: select Provincias.nombre, sum(km2.Superficie)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre ='León';
[17:39, 5/10/2018] +34 629 04 04 28: para contar los municipios de pontevedra
[17:39, 5/10/2018] +34 629 04 04 28: select Provincias.nombre, count(km2.Superficie)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre ='Pontevedra';
[17:39, 5/10/2018] +34 629 04 04 28: contar las provincias cuyo id es 24 y 25
[17:39, 5/10/2018] +34 629 04 04 28: select count(*)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.ID_PRV in (24,25);
[17:39, 5/10/2018] +34 629 04 04 28: ahora lo mismo pero cuyo nombre es lugo o pontevedra
[17:39, 5/10/2018] +34 629 04 04 28: select count(*)
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre in ('Pontevedra', 'Lugo');
[17:39, 5/10/2018] +34 629 04 04 28: el as es para cambiar el nombre de la columna que se visualiza
[17:39, 5/10/2018] +34 629 04 04 28: select count(*) as NumeroDeMunicipios
from Municipios 
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join km2 on km2.ID_MUN = Municipios.ID_MUN
where Provincias.nombre in ('Pontevedra', 'Lugo');
[17:39, 5/10/2018] +34 629 04 04 28: para sacar las que empiezan por M
[17:39, 5/10/2018] +34 629 04 04 28: select * from CCAA 
where nombreID like'M%'
[17:39, 5/10/2018] +34 629 04 04 28: para sacar las ccaa con id 10 12 o 15
[17:39, 5/10/2018] +34 629 04 04 28: select * from CCAA 
where ID_CCAA in (10,12,15);
[17:39, 5/10/2018] +34 629 04 04 28: las ccaa que tienen a como segunda letra
[17:39, 5/10/2018] +34 629 04 04 28: select * from CCAA 
where nombreid like '_a%';
[17:39, 5/10/2018] +34 629 04 04 28: MUNICIPIOS CON MAYOR NUMERO DE POBLACION Y LA PROVINCIA A LA QUE PERTENECEN
[17:39, 5/10/2018] +34 629 04 04 28: select Municipios.Nombre, Provincias.Nombre, HYM FROM Municipios
join Habitantes on Habitantes.ID_MUN = Municipios.ID_MUN
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
order by hym desc
limit 10;
[17:39, 5/10/2018] +34 629 04 04 28: cambiar base de datos
[17:39, 5/10/2018] +34 629 04 04 28: update Provincias
set nombre = 'Varcelona'
where id_PRV = 8;
[17:39, 5/10/2018] +34 629 04 04 28: Municipios de madrid
[17:39, 5/10/2018] +34 629 04 04 28: select Municipios.nombre from Municipios 
join provincias on  Provincias.ID_PRV=Municipios.ID_PRV
where Provincias.Nombre ='Madrid';
[17:39, 5/10/2018] +34 629 04 04 28: sacar el numero total de habitantes de cada ccaa
[17:39, 5/10/2018] +34 629 04 04 28: select CCAA.Nombre, sum(habitantes.hym) as 'Habitantes totales' from Municipios
join habitantes on Municipios.ID_MUN = habitantes.ID_MUN
join Provincias on Provincias.ID_PRV = Municipios.ID_PRV
join CCAA on Provincias.ID_CCAA = CCAA.ID_CCAA
group by CCAA.Nombre
[17:39, 5/10/2018] +34 629 04 04 28: BASE DE DATOS LIBROS
[17:39, 5/10/2018] +34 629 04 04 28: para ver cual es el libro mas leido nos vamos a la tabla de ratings
[17:39, 5/10/2018] +34 629 04 04 28: y contamos el isbn que mas se repite
[17:39, 5/10/2018] +34 629 04 04 28: select RATINGS.ISBN, count(ratings.isbn) as num
from ratings
group by ratings.isbn
order by num desc;
[17:39, 5/10/2018] +34 629 04 04 28: los libros mas leidos son:
[17:39, 5/10/2018] +34 629 04 04 28: select books.Title, books.Author, count(ratings.isbn) as num
from ratings
join Books on books.ISBN = Ratings.ISBN
group by ratings.isbn
order by num desc;
[17:39, 5/10/2018] +34 629 04 04 28: el niño que mas libros ha leido
[17:39, 5/10/2018] +34 629 04 04 28: select ratings.UserID,Users.Age,count(ratings.UserID) as num
from ratings
join Users on ratings.UserID=Users.UserID
where Users.Age >7 and Users.Age <15
group by ratings.UserID
order by num desc;
[17:39, 5/10/2018] +34 629 04 04 28: libros mas leidos por españoles
[17:39, 5/10/2018] +34 629 04 04 28: select books.Title, count(Books.isbn) as num
from Books
join ratings on Books.ISBN=Ratings.Isbn
join Users on Users.UserID = Ratings.Userid
where Users.Location like '%spain%'
group by books.ISBN
order by num desc;
[17:39, 5/10/2018] +34 629 04 04 28: PARA CREAR UNA TABLA NUEVA QUE CONTENGA TITULO Y LOCATION DEL USUARIO QUE LO HA LEIDO:
[17:39, 5/10/2018] +34 629 04 04 28: create view librouser as 
select books.Title, users.Location
from Books
join Ratings on ratings.ISBN=books.ISBN
join Users on Users.UserID=Ratings.UserID 
INSERT INTO nombre_tabla 
VALUES (valor1, valor2, valor3, .)
*/

