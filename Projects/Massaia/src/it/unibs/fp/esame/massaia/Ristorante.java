package it.unibs.fp.esame.massaia;

import java.util.ArrayList;

public class Ristorante
{
	private String nomeRistorante;
	private ArrayList<Ricetta> listaRicette;
	private ArrayList<Ingrediente> listaIngredienti;

	public Ristorante(String nomeRistorante)
	{
		this.nomeRistorante = nomeRistorante;
		listaRicette = new ArrayList<Ricetta>();
		listaIngredienti = new ArrayList<Ingrediente>();
	}

	public void aggiungiRicetta(Ricetta ricetta)
	{
		listaRicette.add(ricetta);
	}

	public void aggiungiIngrediente(Ingrediente ingrediente)
	{
		listaIngredienti.add(ingrediente);
	}
}
