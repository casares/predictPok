package com.predictpok01.principal;

import java.sql.*;
import java.util.ArrayList;

import com.predictpok.db.*;
import com.predictpok.poker.*;

public class Aplicacion {

	public static void main(String[] args) throws SQLException {
		String[] apuestas={"call","raise"};
		PredictPreflop predic=null;
		try {
			predic = new PredictPreflop("doyle","dd",apuestas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total Jugadas: "+predic.getTotalJugadas());
		System.out.println("Numero de filas: "+predic.numeroFilas());
		System.out.println("Tabla de frecuencias");
		System.out.println(predic.toStringFrecuencias());
		System.out.println(predic.media());
		System.out.println(predic.desviacion());
		System.out.println(predic.toStringFrecuencias());
		System.out.println("Prediccion:");
		try {
			System.out.println(predic.prediccionPreflop());
			System.out.println("Estimacion de acierto: "+predic.pearson());
			System.out.println("Oblicuidad: "+predic.oblicuidad());
		} catch (Exception e) {
			System.out.println("No hay suficiente informacion en la BD");
		}
		System.out.println("Mejores Manos");
		try {
			System.out.println(predic.getMasFrecuentes(3));
		} catch (Exception e) {
			System.out.println("No hay suficiente informacion en la BD");
		}
		System.out.println("Peor Mano:");
		try {
			System.out.println(predic.getMenosFrecuente());
		} catch (Exception e) {
			System.out.println("No hay suficiente informacion en la BD");
		}
		System.out.println("Proximo Movimiento: "+predic.sigMovimiento());
	
	}

}
