package it.unibs.fp.magazzino.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibs.fp.magazzino.Articolo;
import it.unibs.fp.magazzino.ListaOrdini;
import it.unibs.fp.magazzino.Magazzino;

class MagazzinoTest
{
	@Test
	public void testAggiuntaArticolo()
	{
		Magazzino magazzino = new Magazzino("Amazon", new ListaOrdini());
		Articolo articolo = new Articolo("iPhone 12", 10, 15, 11, 1);

		magazzino.aggiungiArticolo(articolo);
		assertEquals(magazzino.getNumeroElementi(), 1);
	}

	@Test
	public void testAggiuntaArticoli()
	{
		Magazzino magazzino = new Magazzino("Amazon", new ListaOrdini());
		Articolo articolo = new Articolo("iPhone 12", 10, 15, 11, 1);

		for (int i = 0; i < 10; i++)
		{
			magazzino.aggiungiArticolo(new Articolo("iPhone " + i, 10, 15, 11, 1));
		}

		assertEquals(magazzino.getNumeroElementi(), 10);
	}

	@Test
	public void aggiuntaArticoliConNomiUguali()
	{
		Magazzino magazzino = new Magazzino("Amazon", new ListaOrdini());
		Articolo articolo = new Articolo("iPhone 12", 10, 15, 11, 1);
		Articolo articolo1 = new Articolo("iPhone 12", 10, 15, 11, 1);

		magazzino.aggiungiArticolo(articolo);
		magazzino.aggiungiArticolo(articolo1);

		assertEquals(magazzino.getNumeroElementi(), 1);
	}

	@Test
	public void testRimozioneArticolo()
	{
		Magazzino magazzino = new Magazzino("Amazon", new ListaOrdini());
		Articolo articolo = new Articolo("iPhone 12", 10, 15, 11, 1);
		Articolo articolo1 = new Articolo("iPhone 13", 10, 15, 11, 1);

		magazzino.aggiungiArticolo(articolo);
		magazzino.aggiungiArticolo(articolo1);
		magazzino.eliminaArticolo("iPhone 12");
		assertEquals(magazzino.getNumeroElementi(), 1);
	}
}
