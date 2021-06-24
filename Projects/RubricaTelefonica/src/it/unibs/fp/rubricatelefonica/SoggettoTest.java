package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SoggettoTest
{
	@Test
	void test()
	{
		ArrayList<Contatto> listaContatti = new ArrayList<Contatto>();
		ArrayList<String> listaTelefoni = new ArrayList<String>();

		listaTelefoni.add("13123123123");
		listaTelefoni.add("13123123123");
		listaTelefoni.add("13123123123");

		for (int i = 0; i < 10; i++)
		{
			listaContatti.add(new Contatto("Casa", listaTelefoni, "asdadasd@gmail.com", "Via ciao 123"));
		}

		Soggetto soggetto = new Soggetto(listaContatti);
		System.out.println(soggetto.toString());
	}
}
