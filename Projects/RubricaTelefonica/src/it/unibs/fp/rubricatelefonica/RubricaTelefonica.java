package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public class RubricaTelefonica
{
	private ArrayList<Soggetto> listaSoggetti;

	public RubricaTelefonica()
	{
		listaSoggetti = new ArrayList<Soggetto>();
	}

	public void aggiungiSoggetto(Soggetto soggetto)
	{
		listaSoggetti.add(soggetto);
	}

	@Override
	public String toString()
	{
		return "\nRubricaTelefonica [listaSoggetti=" + listaSoggetti + "]";
	}
}