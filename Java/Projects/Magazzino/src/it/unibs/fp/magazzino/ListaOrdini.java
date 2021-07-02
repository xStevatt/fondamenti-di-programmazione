package it.unibs.fp.magazzino;

import java.util.ArrayList;

public class ListaOrdini
{
	private ArrayList<Ordine> listaOrdini;

	public ListaOrdini()
	{
		listaOrdini = new ArrayList<Ordine>();
	}

	/**
	 * Metodo che aggiunge un ordine alla lista degli ordini.
	 * 
	 * @param ordine l'ordine da aggiungere viene passato come parametro
	 */
	public void aggiungiOrdine(Ordine ordine)
	{
		listaOrdini.add(ordine);
	}

	@Override
	public String toString()
	{
		StringBuffer messaggioStringa = new StringBuffer("");

		for (Ordine ordine : listaOrdini)
		{
			messaggioStringa.append(ordine.toString() + "\n");
		}

		return messaggioStringa.toString();
	}

	public ArrayList<Ordine> getListaOrdini()
	{
		return listaOrdini;
	}

	public void setListaOrdini(ArrayList<Ordine> listaOrdini)
	{
		this.listaOrdini = listaOrdini;
	}
}
