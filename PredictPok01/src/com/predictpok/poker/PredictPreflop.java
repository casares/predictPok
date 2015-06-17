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
	
	public int numeroFilas() throws SQLException{
		int numero_filas=0;
		this.frecuencias.beforeFirst();
		while(this.frecuencias.next()){
			numero_filas++;
		}
		return numero_filas;
	}
	
	public int getTotalJugadas(){
		return this.total_jugadas;
	}
	public ResultSet getFrecuencias(){
		return frecuencias;
	}
	
	public String getJugador(){
		return this.jugador;
	}
	
	public String[] getApuestas(){
		return this.apuestas;
	}
	public ArrayList<ManoPreflop> getMasFrecuentes(int primeras) throws Exception{
		ArrayList<ManoPreflop> mejores_manos = new ArrayList<ManoPreflop>();
		if(numeroFilas()<primeras) throw new Exception("No such info");
		this.frecuencias.first();
		for(int i=0; i<primeras;i++){
			ManoPreflop mano = new ManoPreflop(this.frecuencias.getString("mano_preflop"));
			mejores_manos.add(mano);
			this.frecuencias.next();
		}
		return mejores_manos;
	}
	
	public ManoPreflop getMasFrecuente() throws Exception{
		return new ManoPreflop(getMasFrecuentes(1).get(0).toString());
	}
	
	public ManoPreflop getMenosFrecuente() throws SQLException, Exception{
		this.frecuencias.last();
		ManoPreflop menos_frecuente=new ManoPreflop(this.frecuencias.getString("mano_preflop"));
		this.frecuencias.first();
		return menos_frecuente;
	}
	
	public double media() throws SQLException{
		double media=0.0;
		int sumatorio=0;
		this.frecuencias.beforeFirst();
		while(this.frecuencias.next()){
			sumatorio+=Integer.parseInt(this.frecuencias.getString("frecuencia"));
		}
		media=(double)sumatorio/numeroFilas();
		return media;
	}
	
	public double desviacion() throws SQLException{
		double desviacion=0.0;
		double sumatorio=0.0;
		double media=this.media();
		int frecuencia=0;
		this.frecuencias.beforeFirst();;
		while(this.frecuencias.next()){
			frecuencia=Integer.parseInt(this.frecuencias.getString("frecuencia"));
			double sumando=Math.pow((double)frecuencia-media,2);
			sumatorio+=sumando;
		}
		desviacion=Math.sqrt(sumatorio/(double)this.numeroFilas());
		return desviacion;
	}
	
	public double pearson() throws SQLException{
		double desviacion=this.desviacion();
		double media=this.media();
		double pearson=desviacion/media*100;
		return pearson;
	}
	
	public double oblicuidad() throws SQLException{
		double desviacion=this.desviacion();
		double sumatorio=0.0;
		double media=this.media();
		int frecuencia=0;
		this.frecuencias.beforeFirst();;
		while(this.frecuencias.next()){
			frecuencia=Integer.parseInt(this.frecuencias.getString("frecuencia"));
			double sumando=Math.pow(((double)frecuencia-media)/desviacion,3);
			sumatorio+=sumando;
		}
		double oblicuidad=sumatorio/(double)this.numeroFilas();
		return oblicuidad;
	}
	
	public String toStringFrecuencias() throws SQLException{
		String result="";
		this.frecuencias.beforeFirst();
		while(this.frecuencias.next()){
			result+=this.frecuencias.getString("frecuencia")+" - "
					+this.frecuencias.getString("mano_preflop")+"\n";
		}
		return result;
	}
}
