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

	public void eliminaContatto(int index)
	{
		listaContatti.remove(index);
	}

	@Override
	public String toString()
	{
		return "Soggetto [listaContatti=" + listaContatti + "]";
	}

	public ArrayList<Contatto> getListaContatti()
	{
		return listaContatti;
	}

	public void setListaContatti(ArrayList<Contatto> listaContatti)
	{
		this.listaContatti = listaContatti;
	}
}
