package Modelo;

import Modelo.Conexion;

public class Principal {

	public static void main( String args[] ) {
		String sentencia;

		Conexion bbdd = new Conexion();

//		sentencia = "CREATE TABLE COMPANY " +
//						"(ID INT PRIMARY KEY     NOT NULL," +
//						" NAME           TEXT    NOT NULL, " + 
//						" AGE            INT     NOT NULL, " + 
//						" ADDRESS        CHAR(50), " + 
//						" SALARY         REAL)"; 
//		bbdd.sentenciaSQL(sentencia);
//
//		sentencia = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 32, 'California', 20000.00 );";
//		bbdd.sentenciaSQL(sentencia); 
//
//		sentencia = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//								 "VALUES (2, 'Allen', 25, 'Texas', 15000.00 ), " + 
//									    "(3, 'Teddy', 23, 'Norway', 20000.00 ), " +
//									    "(4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
//		bbdd.sentenciaSQL(sentencia);

		bbdd.consulta();
		
		
	}

}