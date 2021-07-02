package it.unibs.fp.esame.massaia;

import java.util.ArrayList;

import it.unibs.fp.esame.mylib.InputDati;
import it.unibs.fp.esame.mylib.MyMenu;

public class MassaiaMain
{
	public static void main(String[] args)
	{
		mostraMenu();
	}

	public static void mostraMenu()
	{
		String nomeRistorante = InputDati.inputString("Benvenuto! Inserisci nome ristorante");
		Ristorante ristorante = new Ristorante(nomeRistorante);

		String[] scelte = { "Crea un nuovo ingrediente", "Crea una nuova ricetta", "Crea un nuovo menu",
				"Visualizza elenco ricette", "Visualizza elenco ingredienti" };

		MyMenu menu = new MyMenu("Menu Ristorante " + nomeRistorante, scelte);
		int scelta = -1;

		do
		{
			scelta = menu.mostraMenu();

			switch (scelta)
			{
			case 1:
				Ingrediente ingrediente = creaIngrediente();
				ristorante.aggiungiIngrediente(ingrediente);
				break;
			case 2:
				Ricetta ricetta = creaRicetta();
				ristorante.aggiungiRicetta(ricetta);
				break;
			case 3:
				int apportoCaloricoMassimo = InputDati.inputInteger("Inserisci il menu", 0);
				creaMenuRistorante(ristorante.getListaRicette(), apportoCaloricoMassimo);
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
		while (scelta != 0);

		System.out.println("\nGrazie per aver usato MASSAIA!");
	}

	public static Ingrediente creaIngrediente()
	{
		String nomeIngrediente = InputDati.inputString("Inserisci il nome dell'ingrediente");
		int assettoCalorico = InputDati.inputInteger("Inserisci l'assetto calorico di " + nomeIngrediente, 0);

		return new Ingrediente(nomeIngrediente, assettoCalorico);
	}

	public static Ricetta creaRicetta()
	{
		String nome = InputDati.inputString("Inserisci il nome della ricetta");
		String descrizione = InputDati.inputString("Inserisci una descrizione della ricetta");

		int scelta = -1;
		String[] scelte = { "Inserisci ingrediente", "Termina inserimento" };
		ArrayList<Ingrediente> listaIngredientiRicetta;
		MyMenu menuIngredienti = new MyMenu("Inserimento ingredienti ricetta", scelte);

		do
		{
			listaIngredientiRicetta = new ArrayList<Ingrediente>();
			scelta = menuIngredienti.inserisciScelta();
			listaIngredientiRicetta.add(creaIngrediente());
		}
		while (scelta != 0);

		boolean primoPiatto;

		String[] rispostePossibili = { "SI", "NO" };
		String sceltaTipoPiatto = InputDati.inputString("Il piatto è un primo piatto? [SI/NO]", rispostePossibili);

		if (sceltaTipoPiatto.equalsIgnoreCase("SI"))
			primoPiatto = true;
		else
			primoPiatto = false;

		return new Ricetta(nome, descrizione, listaIngredientiRicetta, primoPiatto);
	}

	public static void creaMenuRistorante(ArrayList<Ricetta> listaRicette, int apportoCaloricoMassimo)
	{
		boolean primoPiattoTrovato = false; 
		boolean secondoPiattoTrovato = false; 
		Ricetta ricettaPrimoPiatto = null; 
		Ricetta ricettaSecondoPiatto = null; 
		
		int counterRicette = 0; 
		
		while((primoPiattoTrovato == false || secondoPiattoTrovato == false) && counterRicette < listaRicette.size())
		{
†			if(listaRicette.get(counterRicette).ge)
			
			if(ricettaPr)
			
			counterRicette++; 
		}
	}
}
