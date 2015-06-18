package com.predictpok.poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManoPreflopTest {
//CLASES VALIDAS *********************************************************
	@Test
	public void testManoPreflopTresValidos() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("2TD");
		assertEquals(pruebaManoPreflop.toString(),"2TD");
	}
	
	@Test
	public void testManoPreflopTodosValidos() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AKD");
		assertEquals(pruebaManoPreflop.toString(),"AKD");
	}
	
	@Test
	public void testManoPreflopIgualesDistintoColor() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AAD");
		assertEquals(pruebaManoPreflop.toString(),"AAD");
	}
	
	@Test
	public void testManoPreflopTresValidosMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("2td");
		assertEquals(pruebaManoPreflop.toString(),"2TD");
	}
	
	@Test
	public void testManoPreflopTodosValidosMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("aad");
		assertEquals(pruebaManoPreflop.toString(),"AAD");
	}
	
	@Test
	public void testManoPreflopIgualesDistintoColorMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("2TD");
		assertEquals(pruebaManoPreflop.toString(),"2TD");
	}
	
	
//CLASES NO VALIDAS *******************************************************************	
	
	@Test(expected=Exception.class)
	public void testManoPreflopTresNoValidos() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("HGT");
	
	}
	
	@Test(expected=Exception.class)
	public void testManoPreflopDosNoValidosalidos() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AK");
	}
	
	
	@Test(expected=Exception.class)
	public void testManoPrefloPrimeroNoValido() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("HAD");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloSegundoNoValido() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AHD");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloTerceroNoValido() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AAH");
	}
	
	
	@Test(expected=Exception.class)
	public void testManoPrefloIgualesYColor() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("AAE");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloTresNoValidosMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("hgt");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloDosNoValidosMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("ak");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloPrimeroNoValidoMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("had");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloSegundoNoValidoMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("ahd");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloTerceroNoValidoMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("aah");
	}
	
	@Test(expected=Exception.class)
	public void testManoPrefloIgualesYColorMinus() throws Exception {
		ManoPreflop pruebaManoPreflop = new ManoPreflop("aae");
	}

}
