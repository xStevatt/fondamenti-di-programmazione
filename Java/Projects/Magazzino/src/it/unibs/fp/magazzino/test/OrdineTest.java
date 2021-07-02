package it.unibs.fp.magazzino.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibs.fp.magazzino.Articolo;
import it.unibs.fp.magazzino.Ordine;

class OrdineTest
{
	@Test
	void testCreazioneOrdine()
	{
		Articolo articolo = new Articolo("iPhone", 10, 100, 10, 1);
		Ordine ordine = new Ordine(articolo, 10);

		assertEquals(ordine.getArticolo().getNomeArticolo(), "iPhone");
		assertEquals(ordine.getQuantità(), 10);
	}
}
