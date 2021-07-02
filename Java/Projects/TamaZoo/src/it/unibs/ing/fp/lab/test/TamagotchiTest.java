package it.unibs.ing.fp.lab.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.lab.TamaZoo.Tamagotchi;

public class TamagotchiTest 
{	
	@Test
	public void testTamaMuoreConSazietaZero()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 50, 0); 
		assertTrue(tamagotchi.sonoMorto()); 
	}
	
	@Test
	public void testTamaMuoreConAffettoZero()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 0, 50); 
		assertTrue(tamagotchi.sonoMorto()); 
	}
	
	@Test
	public void testTamaMuoreConAffettoSazietaZero()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 0, 0); 
		assertTrue(tamagotchi.sonoMorto()); 
	}
	
	@Test
	public void testTamaViveConAffettoSazieta1()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 1, 1); 
		assertFalse(tamagotchi.sonoMorto()); 
	}
	
	@Test
	public void testTamaTristeConAffettoMinore30()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 20, 50); 
		assertTrue(tamagotchi.sonoTriste()); 
	}
	
	@Test
	public void testTamaTristeConSazietaMinore30()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 50, 20); 
		assertTrue(tamagotchi.sonoTriste()); 
	}
	
	@Test
	public void testTamaTristeConSazietaAffettoMinore30()
	{
		Tamagotchi tamagotchi = new Tamagotchi("", 20, 20); 
		assertTrue(tamagotchi.sonoTriste()); 
	}
}
