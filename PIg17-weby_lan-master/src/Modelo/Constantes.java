package Modelo;

public class Constantes {

	public final static String VACIO = "";
	public final static String SEPARADOR = ";";
	public final static String ESPACIOB = " ";
	public final static String GUIONBAJO = "_";
	public final static String COMA = ",";
	public final static String ROL_MED = "Medico";
	public final static String ROL_TEC = "Tecnico";
	public final static String HOMBRE = "hombre";
	public final static String MUJER = "mujer";
	public final static String PACIENTE = "Paciente";
	public final static String DESCONOCIDO = "n/d";
	public final static String ERRORPACIENTE = "No ha seleccionado ningun paciente";
	public final static String RELATIVO = ".";
	public final static String CARPETABBDD = "BBDD2";
	public final static String CARPETAIMG = "img";
	public final static String LOGOUTFOTO = "apagar.jpg";
	public final static String FICHEROUSUARIO = "FicheroUsuario.txt";
	public final static String FICHEROTECNICOS = "Tecnicos.txt";
	public final static String FICHEROMEDICOS = "Medicos.txt";
	public final static String FICHEROPACIENTES = "Pacientes.txt";
	public final static String FONDOGRAFICA = "fondograficaweby2.jpg";
	public final static String EXTENSIONTXT = ".txt";
	public final static String NOSELECCION = "No fue seleccionado ningun archivo";
	public final static String ACEPTAR = "Aceptar";
	public final static String CANCELAR = "Cancelar";
	public final static String ERR_USUARIO = "El usuario que ha cargado no se encuentra en la BBDD";
	public final static String TIPOFECHA1 = "yyyyMMdd";
	public final static String COMENTARIOINICIALECG = "No hay comentario asociado al ECG";
	// Rellenar combos Agregar Paciente
	public final static int PRIMERA_ALTURA = 110;
	public final static int ULTIMA_ALTURA = 300;
	public final static int PRIMER_KG = 30;
	public final static int ULTIMO_KG = 220;
	public final static String GRAMOS0 = "000";
	public final static String GRAMOS1 = "250";
	public final static String GRAMOS2 = "500";
	public final static String GRAMOS3 = "750";
	// Path imagenes usuarios
	public final static String FOTO_HOMBRE = "hombre.png";
	public final static String FOTO_MUJER = "mujer.png";
	public final static String FOTO_ABSTRACTO = "abstracto.png";
	// Posiciones en la BBDD de los campos del medico
	public final static int POS_MED_NOMBRE_USUARIO = 0;
	public final static int POS_MED_NOMBRE = 1;
	public final static int POS_MED_APELLIDO = 2;
	public final static int POS_MED_DNI = 3;
	public final static int POS_MED_HOSPITAL = 4;
	public final static int POS_MED_CIUDAD = 5;
	public final static int POS_MED_TELEFONO = 6;
	public final static int POS_MED_EMAIL = 7;
	public final static int POS_MED_SEXO = 8;
	public final static int POS_MED_PRIMER_PACIENTE = 9;
	// Posiciones en la BBDD de los campos del tecnico
	public final static int POS_TEC_NOMBRE_USUARIO = 0;
	public final static int POS_TEC_NOMBRE = 1;
	public final static int POS_TEC_APELLIDO = 2;
	public final static int POS_TEC_DNI = 3;
	public final static int POS_TEC_PROVINCIA = 4;
	public final static int POS_TEC_SEXO = 5;
	public final static int POS_TEC_EMAIL = 6;
	// Posiciones en la BBDD de los campos del paciente
	public final static int POS_PAC_NOMBRE = 0;
	public final static int POS_PAC_APELLIDO = 1;
	public final static int POS_PAC_DNI = 2;
	public final static int POS_PAC_CIUDAD = 3;
	public final static int POS_PAC_CALLE = 4;
	public final static int POS_PAC_ESTADO = 5;
	public final static int POS_PAC_SEXO = 6;
	public final static int POS_PAC_COMENTARIO = 7;
	public final static int POS_PAC_FECHANAC = 8;
	public final static int POS_PAC_ALTURA = 9;
	public final static int POS_PAC_KG = 10;
	public final static int POS_PAC_GRAMOS = 11;
	public final static int POS_PAC_COMUNIDAD = 12;
	public final static int POS_PAC_PROVINCIA = 13;
	public final static int POS_PAC_CP = 14;
	public final static int POS_PAC_TELEFONO = 15;
	public final static int POS_PAC_EMAIL = 16;
	public final static int POS_PAC_PRIMER_ECG = 17;

}
