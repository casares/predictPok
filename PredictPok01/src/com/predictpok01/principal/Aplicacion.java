package com.predictpok01.principal;

import java.sql.*;

import com.predictpok.poker.*;

public class Aplicacion {

	public static void main(String[] args) {
		/*ControlDB database = new ControlDB();
		database.conectar();
		ResultSet tabla= database.consultar("SELECT * FROM prueba");
		
		try {
			if(tabla.next()) System.out.println("tiene resultado");
			System.out.println(tabla.getString("nombre_prueba"));
			int edad=Integer.parseInt(tabla.getString("edad_prueba"));
			System.out.println(++edad);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	
		Carta carta1=new Carta(2,"C");
		Carta carta2=new Carta(1,"C");
		if(carta1.menorValorQue(carta2)) System.out.println(carta1.toString()+" = "+carta2.toString());
		else System.out.println("NO");
		//database.ejecutar("INSERT INTO prueba (nombre_prueba,edad_prueba) VALUES ('prueba3','3')");
		//database.ejecutar("UPDATE prueba SET nombre_prueba='prueba4',edad_prueba=4 WHERE id_prueba=3");
		//database.ejecutar("DELETE FROM prueba WHERE nombre_prueba='prueba4'");
		//database.desconectar();

	}

}
