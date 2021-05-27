package it.unibs.ing.fp.lab.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.lab.TamaZoo.TamaTriste;

public class TamaTristeTest {

	@Test
	public void testTamaSoddisfazioneAffettivaSempreZero()
	{
		TamaTriste tamatriste = new TamaTriste("TamaTriste 1", 90); 
		tamatriste.setSoddisfazione_affettiva(100);
		
		assertEquals(0, tamatriste.getSoddisfazione_affettiva(), 0.0);
	}
	
	@Test
	public void testTamaSempreTriste()
	{
		TamaTriste tamatriste = new TamaTriste("TamaTriste 1", 90); 
		tamatriste.setSoddisfazione_affettiva(100);
		
		assertTrue(tamatriste.sonoTriste());
	}
	
	@Test
	public void testTamaTristeNonMuoreAncheSeSoddisfazioneAffettivaZero()
	{
		TamaTriste tamatriste = new TamaTriste("TamaTriste 1", 90); 
		tamatriste.setSoddisfazione_affettiva(0);
		
		assertFalse(tamatriste.sonoMorto());
	}
	
	@Test
	public void testTamaTristeMuoreSeGradoSazietaZero()
	{
		TamaTriste tamatriste = new TamaTriste("TamaTriste 1", 0); 
		tamatriste.setSoddisfazione_affettiva(0);
		
		assertTrue(tamatriste.sonoMorto());
	}
	
	@Test
	public void testTamaMuoreSeGradoSazietaSupera90()
	{
		TamaTriste tamatriste = new TamaTriste("TamaTriste 1", 91); 
		tamatriste.setSoddisfazione_affettiva(0);
		
		assertTrue(tamatriste.sonoMorto());
	}
}
