package com.predictpok01.principal;

import java.sql.*;
import java.util.ArrayList;

import com.predictpok.db.*;
import com.predictpok.poker.*;

public class Aplicacion {

	public static void main(String[] args) {
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
		ArrayList<ManoPreflop> manos =null;
		try {
			manos=predic.getMasFrecuentes(3);
			System.out.println(manos.size());
			for(int i=0;i<manos.size();i++){
				System.out.println("Pasada: "+i);
				System.out.println(manos.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
