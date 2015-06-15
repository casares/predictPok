package com.predictpok.poker;
import java.sql.*;
import java.util.ArrayList;

import com.predictpok.db.*;

public class PredictPreflop {
	private ControlDB database=new ControlDB();
	private String jugador;
	private int total_jugadas;
	private String[] apuestas;
	private ResultSet frecuencias;
	//private ManoPreflop prediccion_mano;
	//String proximo_movimiento;
	//float fiabilidad_prediccion;
	ArrayList<ManoPreflop> tres_mas_probables;
	//ArrayList<ManoPreflop> rango_manos;
	//ArrayList<ManoPreflop> nunca_jugadas;
	private int totalJugadas(String jugador, String posicion, String[] apuestas) throws SQLException{
		String query="SELECT COUNT(*) AS num FROM preflop "
				+ "WHERE id_jugador='"+jugador+"'";
		for(int i=0;i<apuestas.length;i++){
			int numero_apuesta=i+1;
			query+=" AND apuesta"+numero_apuesta+"_preflop='"+apuestas[i]+"'";
		}
		query+=" AND posicion_preflop='"+posicion+"'";
		System.out.println(query);
		
		ResultSet result=database.consultar(query);
		if (result.next()) System.out.println("tiene elementos");
		int resultado=Integer.parseInt(result.getString("num"));
		
		return resultado;
	}
	
	private ResultSet frecuenciaJugadas(String jugador, String posicion, String[] apuestas){
		ControlDB database=new ControlDB();
		database.conectar();
		String query="SELECT COUNT(mano_preflop) AS frecuencia, mano_preflop "
				   + "FROM preflop "
				   + "WHERE id_jugador='"+jugador+"'";
		for(int i=0;i<apuestas.length;i++){
			int numero_apuesta=i+1;
			query+=" AND apuesta"+numero_apuesta+"_preflop='"+apuestas[i]+"'";
		}
		query+=" AND posicion_preflop='"+posicion+"'";
		query+=" GROUP BY mano_preflop ORDER BY frecuencia DESC";
		System.out.println(query);
		ResultSet result = database.consultar(query);
		
		return result;
	}
		
	public PredictPreflop(String jugador, String posicion, String[] apuestas) throws SQLException{
		database.conectar();
		this.jugador=jugador;
		this.apuestas=apuestas;
		this.total_jugadas=totalJugadas(jugador,posicion,apuestas);
		this.frecuencias=frecuenciaJugadas(jugador,posicion,apuestas);
	}
	
	protected void finalize(){
		this.database.desconectar();
	}
	
	public int getTotalJugadas(){
		return this.total_jugadas;
	}
	public ResultSet getFrecuencias(){
		return frecuencias;
	}
	public ArrayList<ManoPreflop> getMasFrecuentes(int primeras) throws Exception{
		ArrayList<ManoPreflop> tres_mejores = new ArrayList<ManoPreflop>();
		int numero_filas=0;
		try {//contamos el numero de filas del resultado
			while(this.frecuencias.next()){
				numero_filas++;
				System.out.println("Numero de filas: "+numero_filas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frecuencias.first();
		if(numero_filas<primeras) throw new Exception("No such info");
		for(int i=0; i<primeras;i++){
			
			ManoPreflop mano = new ManoPreflop(this.frecuencias.getString("mano_preflop"));
		
			tres_mejores.add(mano);
			this.frecuencias.next();
		}
		return tres_mejores;
	}
	public String toStringFrecuencias(){
		String result="";
		try {
			while(this.frecuencias.next()){
				result+=this.frecuencias.getString("frecuencia")+" - "
						+this.frecuencias.getString("mano_preflop")+"\n";
			}
			this.frecuencias.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
