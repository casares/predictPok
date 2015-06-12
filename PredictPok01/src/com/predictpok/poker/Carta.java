package com.predictpok.poker;

public class Carta {
	private int valor;
	private String palo;
	
	public Carta(int valor, String palo){
		this.valor=valor;
		this.palo=palo;
	}
	public int getValor(){
		return this.valor;		
	}
	public String getPalo(){
		return this.palo;
	}
	public void setValor(int valor){
		this.valor=valor;
	}
	public void setPalo(String palo){
		this.palo=palo;
	}
	public boolean igualValorQue(Carta carta){
		return this.valor==carta.getValor();
	}
	
	public boolean igualPalo(Carta carta){
		return this.palo.equals(carta.palo);
	}
	
	public boolean mayorValorQue(Carta carta){
		return this.valor>carta.getValor();
	}
	public boolean menorValorQue(Carta carta){
		return this.valor<carta.getValor();
	}
	public Carta cartaSiguiente() throws Exception{
		Carta carta=new Carta(0,"0");
		if(this.valor==14){ throw new Exception("No tiene siguiente");}
		carta.setValor(this.valor+1);
		carta.setPalo(this.palo);
		return carta;	
	}
	public Carta cartaAnterior() throws Exception{
		Carta carta=new Carta(0,"0");
		if(this.valor==2){ throw new Exception("No tiene anterior");}
		carta.setValor(this.valor-1);
		carta.setPalo(this.palo);
		return carta;	
	}
	
	public boolean equals(Carta carta){
		if(this.igualValorQue(carta)&&this.igualPalo(carta)) return true;
		else return false;
	}
	public String toString(){
		return this.valor+this.palo;
	}
	
}
