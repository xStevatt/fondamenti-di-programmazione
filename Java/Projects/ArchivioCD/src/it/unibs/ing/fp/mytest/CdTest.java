package it.unibs.ing.fp.mytest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unibs.ing.fp.cd.Brano;
import it.unibs.ing.fp.cd.Cd;

public class CdTest 
{
	@Test
	public void testAggiuntaBrani() 
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Titolo Brano 1", 1, 1));
		cd.aggiungiBrano(new Brano("Titolo Brano 2", 2, 2));
		cd.aggiungiBrano(new Brano("Titolo Brano 3", 3, 3));
		
		assertEquals(3, cd.getNumeroBrani());
	}
	
	@Test 
	public void testSetNewListaBrani()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		ArrayList<Brano> lista_brani = new ArrayList<Brano>(); 
		lista_brani.add(new Brano("Brano 5", 10, 10)); 
		lista_brani.add(new Brano("Brano 6", 10, 10)); 
		lista_brani.add(new Brano("Brano 7", 10, 10)); 
		lista_brani.add(new Brano("Brano 8", 10, 10)); 
		
		cd.setListaBrani(lista_brani);
		
		assertEquals("Brano 5", lista_brani.get(0).getTitolo());
		assertEquals("Brano 6", lista_brani.get(1).getTitolo());
		assertEquals("Brano 7", lista_brani.get(2).getTitolo());
		assertEquals("Brano 8", lista_brani.get(3).getTitolo());
	}
	
	@Test
	public void testEliminaBrano()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		cd.eliminaBrano("Brano 4"); 
		
		assertEquals(3, cd.getNumeroBrani());
	}
	
	@Test
	public void testCercaBranoTitolo()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		int index = cd.cercaBranoTitolo("Brano 3"); 
		
		assertEquals(2, index);
	}
	
	@Test
	public void testContiene()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		assertEquals(true, cd.contiene("Brano 4"));
	}
	
	@Test 
	public void testNonContiene()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		assertEquals(false, cd.contiene("Brano 5"));
	}
	
	@Test
	public void testHaTitolo()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		assertEquals(true, cd.haTitolo("Titolo CD"));
	}
	
	@Test
	public void testNonHaTitolo()
	{
		Cd cd = new Cd("Titolo CD", "Autore CD"); 
		cd.aggiungiBrano(new Brano("Brano 1", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 2", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 3", 10, 10));
		cd.aggiungiBrano(new Brano("Brano 4", 10, 10));
		
		assertEquals(false, cd.haTitolo("TitoloCD 2"));
	}
}
