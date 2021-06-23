package it.unibs.ing.fp.veterinario.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unibs.ing.fp.veterinario.Orario;

class OrarioTest 
{
	@Test
	public void testCreazioneOrarioValido()
	{
		Orario orario1 = new Orario(10, 10); 
		assertTrue(orario1.isOrarioValid(orario1)); 
	}
	
	@Test
	public void testCreazioneOrarioNonValidoOre()
	{
		Orario orario1 = new Orario(25, 10); 
		assertFalse(orario1.isOrarioValid(orario1)); 
	}
	
	@Test
	public void testCreazioneOrarioNonValidoMinuti()
	{
		Orario orario1 = new Orario(10, 60); 
		assertFalse(orario1.isOrarioValid(orario1)); 
	}
	
	@Test
	public void testCreazioneOrario()
	{
		Orario orario1 = new Orario(10, 50); 
		assertEquals(orario1.toString(), "10:50"); 
	}
	
	@Test
	public void testOrariDiversiConfronto()
	{
		Orario orario1 = new Orario(10, 50); 
		Orario orario2 = new Orario(10, 51); 
		
		assertTrue(orario1.confrontaOrari(orario2)); 
	}
	
	@Test
	public void testConversioneSecondi()
	{
		Orario orario1 = new Orario(1, 0); 
		
		assertEquals(orario1.getNumeroSecondi(), 60 * 60); 
	}
}
