package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public abstract class Soggetto
{
	private ArrayList<Contatto> listaContatti;

	public Soggetto(ArrayList<Contatto> listaContatti)
	{
		this.listaContatti = listaContatti;
	}

	public void aggiungiContatto(Contatto contatto)
	{
		listaContatti.add(contatto);
	}

	@Override
	public String toString()
	{
		return "Soggetto [listaContatti=" + listaContatti + "]";
	}
}
