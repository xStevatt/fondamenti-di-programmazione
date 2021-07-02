package it.unibs.ing.fp.lab.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.lab.TamaZoo.TamaGordo;
import it.unibs.ing.fp.lab.TamaZoo.TamaTriste;
import it.unibs.ing.fp.lab.TamaZoo.TamaZoo;
import it.unibs.ing.fp.lab.TamaZoo.Tamagotchi;

public class TamaZooTest 
{
	@Test
	public void testAggiungiTamaogtchiBaseTamaZoo() 
	{
		TamaZoo tamazoo = new TamaZoo(); 
		Tamagotchi tamabase = new Tamagotchi("Tamagotchi", 50, 50); 
		
		tamazoo.aggiungiTama(tamabase);
		assertEquals(1, tamazoo.getNumeroTamaVivi());
	}
	
	@Test
	public void testAggiungiTamaogtchiTristeTamaZoo() 
	{
		TamaZoo tamazoo = new TamaZoo(); 
		Tamagotchi tamatriste = new Tamagotchi("TamaTriste", 50, 50); 
		
		tamazoo.aggiungiTama(tamatriste);
		assertEquals(1, tamazoo.getNumeroTamaVivi());
	}
	
	@Test
	public void testAggiungiTamagotchiGordoAllaLista() 
	{
		TamaZoo tamazoo = new TamaZoo(); 
		Tamagotchi tamagordo = new Tamagotchi("TamaGordo", 50, 50); 
		
		tamazoo.aggiungiTama(tamagordo);
		assertEquals(1, tamazoo.getNumeroTamaVivi());
	}
	
	@Test
	public void testAggiungiTamaMorti() 
	{
		TamaZoo tamazoo = new TamaZoo(); 
		Tamagotchi tamagotchi1 = new Tamagotchi("", 50, 50); 
		Tamagotchi tamagotchi2 = new Tamagotchi("", 0, 0); 
		TamaTriste tamatriste1 = new TamaTriste("", 50); 
		TamaTriste tamatriste2 = new TamaTriste("", 0); 
		TamaGordo tamagordo1 = new TamaGordo("", 50); 
		TamaGordo tamagordo2 = new TamaGordo("", 0); 
		
		tamazoo.aggiungiTama(tamagotchi1);
		tamazoo.aggiungiTama(tamagotchi2);
		tamazoo.aggiungiTama(tamatriste1);
		tamazoo.aggiungiTama(tamatriste2);
		tamazoo.aggiungiTama(tamagordo1);
		tamazoo.aggiungiTama(tamagordo2);
		
		assertEquals(3, tamazoo.getNumeroTamaVivi()); 
	}
}
