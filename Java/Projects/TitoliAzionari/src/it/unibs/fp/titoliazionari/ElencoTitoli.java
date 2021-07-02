package it.unibs.fp.titoliazionari;

import java.io.Serializable;
import java.util.Vector;

public class ElencoTitoli implements Serializable
{
	private static final long serialVersionUID = 1L;

	private final static String INTRO_TITOLI = "Ecco l'elenco dei titoli:\n";

	private Vector<Titolo> listino;

	public ElencoTitoli()
	{
		listino = new Vector<Titolo>();
	}

	public int getNumeroTitoli()
	{
		return listino.size();
	}

	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append(INTRO_TITOLI);

		for (int i = 0; i < listino.size(); i++)
		{
			result.append(listino.get(i).toString() + "\n");
		}

		return result.toString();
	}

	public void simulaVariazione()
	{
		for (int i = 0; i < listino.size(); i++)
		{
			Titolo tit = listino.get(i);
			tit.variazioneGiornaliera();
		}
	}

	public Vector<Titolo> getListino()
	{
		return listino;
	}

	public void setListino(Vector<Titolo> listino)
	{
		this.listino = listino;
	}
}
