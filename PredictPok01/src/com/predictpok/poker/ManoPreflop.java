package com.predictpok.poker;

public class ManoPreflop {
	private String valor_carta1;
	private String valor_carta2;
	private boolean mismo_palo;
	
	private boolean esValorValido(String valor){
		valor=valor.toUpperCase();
		String valoresPosibles="23456789TJQKA";
		if (valoresPosibles.contains(valor)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean esTipoColorValido(String tipoColor){
		tipoColor=tipoColor.toUpperCase();
		String valoresPosibles="DE";
		if(valoresPosibles.contains(tipoColor)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean esCadenaPreflop(String cadena_preflop){
		if (cadena_preflop.length()!=3) return false;
		//Del mismo valor no pueden ser del mismo palo
		if(cadena_preflop.substring(0,1).equals(cadena_preflop.substring(1,2))
				&& ("eE").contains(cadena_preflop.substring(2,3))) return false;
		if(!esValorValido(cadena_preflop.substring(0,1))) return false;
		if(!esValorValido(cadena_preflop.substring(1,2))) return false;
		if(!esTipoColorValido(cadena_preflop.substring(2,3))) return false;
		return true;
	}
	
	public ManoPreflop(String cadena_mano_preflop) throws Exception{
		if(!esCadenaPreflop(cadena_mano_preflop)){
			throw new Exception("No es una cadena preflop bien construida");
		}
		this.valor_carta1=cadena_mano_preflop.substring(0,1).toUpperCase();
		this.valor_carta2=cadena_mano_preflop.substring(1,2).toUpperCase();
		String palo=cadena_mano_preflop.substring(2,3).toUpperCase();
		if(palo.equals("D")) this.mismo_palo=false;
		if(palo.equals("E")) this.mismo_palo=true;
	}
	public ManoPreflop(String valor1, String valor2, boolean mismo_palo) throws Exception{
		String cadena_mano_preflop=valor1+valor2;
		if(mismo_palo){
			cadena_mano_preflop+="E";
		}else{
			cadena_mano_preflop+="D";
		}
		if(!esCadenaPreflop(cadena_mano_preflop)){
			throw new Exception("No es una cadena preflop bien construida");
		}
		this.valor_carta1=valor1.toUpperCase();
		this.valor_carta2=valor2.toUpperCase();
		if(mismo_palo){
			this.mismo_palo=true;
		}else{
			this.mismo_palo=false;
		}
	}
	
	public boolean sonMismoPalo(){
		return this.mismo_palo;
	}
	
	public boolean sonPareja(){
		return valor_carta1.equals(valor_carta2);
	}
	public boolean sonColor(){
		return this.mismo_palo;
	}
	
	public boolean sonMismoValor(){
		return valor_carta1.equals(valor_carta2);
	}
	
	public String getValor1(){
		return this.valor_carta1;
	}
	
	public String getValor2(){
		return this.valor_carta2;
	}
	
	public String toString(){
		String resultado="";
		resultado+=valor_carta1+valor_carta2;
		if(this.mismo_palo){
			resultado+="E";
		}else{
			resultado+="D";
		}
		return resultado;
	}
	
	public String toStringValor(){
		return valor_carta1+valor_carta2;
	}
	
	public String toStringMayusculas(){
		return this.toString();
	}
	
	public String toStringMinusculas(){
		return this.toString().toLowerCase();
	}
	
	
}
