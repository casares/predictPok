package com.predictpok.poker;

import java.util.ArrayList;

public class Mano {
	private String nombre=null;
	private ArrayList<Carta> mano;
	
	public Mano (){
		
	}
	public Mano (ArrayList<Carta> mano){
		this.mano=mano;
	}
	public ArrayList<Carta> getMano(){
		return this.mano;
	}
	public void setMano(ArrayList<Carta> mano){
		this.mano=mano;
	}
	public void setNombreMano(String nombre){
		this.nombre=nombre;
	}
	public String getNombreMano(){
		return this.nombre;
	}
}
