package com.predictpok01.principal;

import java.sql.*;
import java.util.ArrayList;

import com.predictpok.db.*;
import com.predictpok.poker.*;

public class Aplicacion {

	public static void main(String[] args) throws SQLException {
		/*ControlDB database = new ControlDB();
		database.conectar();
		String consulta="SELECT COUNT(*) AS numero FROM Preflop WHERE id_jugador='doyle'";
		ResultSet tabla= database.consultar(consulta);
		
		try {
			if (tabla.next()) System.out.println("tiene elementos");
			int numero_elementos=Integer.parseInt(tabla.getString("numero"));
			System.out.println(numero_elementos);
			consulta="SELECT DISTINCT mano_preflop FROM Preflop "
					+ "WHERE id_jugador='doyle' "
					+ "GROUP BY mano_preflop";
			tabla=database.consultar(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
		
		database.desconectar();*/
		String[] apuestas={"call","raise"};
		PredictPreflop predic=null;
		try {
			predic = new PredictPreflop("doyle","dd",apuestas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(predic.getTotalJugadas());
		//System.out.println(predic.toStringFrecuencias());
		/*ArrayList<ManoPreflop> manos =null;
		try {
			manos=predic.getMasFrecuentes(3);
			for(int i=0;i<manos.size();i++){
				if(i==0)System.out.println("Prediccion: "+manos.get(i).toString() );
				System.out.println(manos.get(i).toString());
			}
			System.out.println("Numero de filas: "+predic.numeroFilas());
			predic.mostrarFrecuencias();
			System.out.println("Media: "+predic.media());
			//System.out.println("Desviacion: "+predic.desviacion());
			//System.out.println(predic.fiabilidad());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		//System.out.println(predic.media());
	}

}
