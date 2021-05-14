package it.unibs.fp.lab.polverisottili;

import static org.junit.Assert.*;

import org.junit.Test;

public class SettimanaTest 
{
	@Test
	public void testTrovaSommaCorretta()
	{
		double dati_giornalieri[] = new double[7]; 
		
		dati_giornalieri[0] = 1.0; 
		dati_giornalieri[1] = 3.0; 
		dati_giornalieri[2] = 1.0; 
		dati_giornalieri[3] = 5.0; 
		dati_giornalieri[4] = 1.0; 
		dati_giornalieri[5] = 3.0; 
		dati_giornalieri[6] = 1.0; 
		
		Settimana settimana = new Settimana(2008, 1, dati_giornalieri); 
		assertEquals(settimana.somma_dati(), 15.0, 0.1);
	}
	
	@Test
	public void testTrovaMassimoCorretto()
	{
		double dati_giornalieri[] = new double[7]; 
		
		dati_giornalieri[0] = 1.0; 
		dati_giornalieri[1] = 3.0; 
		dati_giornalieri[2] = 1.0; 
		dati_giornalieri[3] = 5.0; 
		dati_giornalieri[4] = 1.0; 
		dati_giornalieri[5] = 3.0; 
		dati_giornalieri[6] = 1.0; 
		
		Settimana settimana = new Settimana(2008, 1, dati_giornalieri); 
		assertEquals(settimana.trovaMassimo(), 5.0, 0.0);
	}
	
	@Test
	public void testTrovaMediaCorretta()
	{
		double dati_giornalieri[] = new double[7]; 
		
		dati_giornalieri[0] = 1.0; 
		dati_giornalieri[1] = 3.0; 
		dati_giornalieri[2] = 1.0; 
		dati_giornalieri[3] = 5.0; 
		dati_giornalieri[4] = 1.0; 
		dati_giornalieri[5] = 3.0; 
		dati_giornalieri[6] = 1.0; 
		
		Settimana settimana = new Settimana(2008, 1, dati_giornalieri); 
		assertEquals(settimana.media_dati(), 2.14, 0.1);
	}
}
