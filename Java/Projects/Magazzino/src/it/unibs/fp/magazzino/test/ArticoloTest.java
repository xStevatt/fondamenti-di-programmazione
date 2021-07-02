package it.unibs.fp.magazzino.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibs.fp.magazzino.Articolo;

class ArticoloTest
{
	@Test
	void testCreazioneArticolo()
	{
		Articolo articolo = new Articolo("iPhone", 10, 100, 10, 1);

		assertEquals(articolo.getNomeArticolo(), "iPhone");
		assertEquals(articolo.getQtaMinima(), 10);
		assertEquals(articolo.getQtaMassima(), 100);
		assertEquals(articolo.getQtaDisponibile(), 10);
		assertEquals(articolo.getTempoProduzione(), 1);
	}
}
