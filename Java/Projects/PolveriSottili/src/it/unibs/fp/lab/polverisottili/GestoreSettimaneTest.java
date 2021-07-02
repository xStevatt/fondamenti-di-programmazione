package it.unibs.fp.lab.polverisottili;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Classe per mostrare a schermo il menu di scelta
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class GestoreSettimaneTest 
{
	@Test
	public void testAggiuntaSettimana() throws Exception
	{
		double []dati_giornalieri = new double[7];
		ArrayList<Settimana> settimane = new ArrayList<Settimana>(); 
		
		dati_giornalieri[0] = 1.0; 
		dati_giornalieri[1] = 3.0; 
		dati_giornalieri[2] = 1.0; 
		dati_giornalieri[3] = 5.0; 
		dati_giornalieri[4] = 1.0; 
		dati_giornalieri[5] = 3.0; 
		dati_giornalieri[6] = 1.0; 
		
		Settimana settimana1 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana2 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana3 = new Settimana(1, 1, dati_giornalieri); 
		
		settimane.add(settimana1); 
		settimane.add(settimana2); 
		settimane.add(settimana3); 
		assertEquals(3, settimane.size());
	}
	
	@Test
	public void testMaxMediaArrayListZero() throws Exception
	{
		double []dati_giornalieri = new double[7];
		ArrayList<Settimana> settimane = new ArrayList<Settimana>(); 
		
		dati_giornalieri[0] = 0; 
		dati_giornalieri[1] = 0; 
		dati_giornalieri[2] = 0; 
		dati_giornalieri[3] = 0; 
		dati_giornalieri[4] = 0; 
		dati_giornalieri[5] = 0; 
		dati_giornalieri[6] = 0; 
		
		Settimana settimana1 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana2 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana3 = new Settimana(1, 1, dati_giornalieri); 
		settimane.add(settimana1); 
		settimane.add(settimana2); 
		settimane.add(settimana3); 
		
		GestoreSettimane gestore = new GestoreSettimane(); 
		gestore.calcolaInfoSettimaneTotali(settimane);
	}
	
	@Test
	public void testMaxMediaArrayListValoriNormali() throws Exception
	{
		double []dati_giornalieri = new double[7];
		ArrayList<Settimana> settimane = new ArrayList<Settimana>(); 
		
		dati_giornalieri[0] = 1.0; 
		dati_giornalieri[1] = 3.0; 
		dati_giornalieri[2] = 1.0; 
		dati_giornalieri[3] = 5.0; 
		dati_giornalieri[4] = 1.0; 
		dati_giornalieri[5] = 3.0; 
		dati_giornalieri[6] = 1.0; 
		
		Settimana settimana1 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana2 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana3 = new Settimana(1, 1, dati_giornalieri); 
		settimane.add(settimana1); 
		settimane.add(settimana2); 
		settimane.add(settimana3); 
		
		GestoreSettimane gestore = new GestoreSettimane(); 
		gestore.calcolaInfoSettimaneTotali(settimane);
	}
	
	@Test
	public void testMaxMediaArrayListValoriMedi() throws Exception
	{
		double []dati_giornalieri = new double[7];
		ArrayList<Settimana> settimane = new ArrayList<Settimana>(); 
		
		dati_giornalieri[0] = 51; 
		dati_giornalieri[1] = 51; 
		dati_giornalieri[2] = 51; 
		dati_giornalieri[3] = 51; 
		dati_giornalieri[4] = 51; 
		dati_giornalieri[5] = 51; 
		dati_giornalieri[6] = 51; 
		
		Settimana settimana1 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana2 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana3 = new Settimana(1, 1, dati_giornalieri); 
		settimane.add(settimana1); 
		settimane.add(settimana2); 
		settimane.add(settimana3); 
		
		GestoreSettimane gestore = new GestoreSettimane(); 
		gestore.calcolaInfoSettimaneTotali(settimane);
	}
	
	@Test
	public void testMaxMediaArrayListValoriMassimo() throws Exception
	{
		double []dati_giornalieri = new double[7];
		ArrayList<Settimana> settimane = new ArrayList<Settimana>(); 
		
		dati_giornalieri[0] = 76; 
		dati_giornalieri[1] = 76; 
		dati_giornalieri[2] = 76; 
		dati_giornalieri[3] = 76; 
		dati_giornalieri[4] = 76; 
		dati_giornalieri[5] = 76; 
		dati_giornalieri[6] = 76; 
		
		Settimana settimana1 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana2 = new Settimana(1, 1, dati_giornalieri); 
		Settimana settimana3 = new Settimana(1, 1, dati_giornalieri); 
		settimane.add(settimana1); 
		settimane.add(settimana2); 
		settimane.add(settimana3); 
		
		GestoreSettimane gestore = new GestoreSettimane(); 
		gestore.calcolaInfoSettimaneTotali(settimane);
	}
}
