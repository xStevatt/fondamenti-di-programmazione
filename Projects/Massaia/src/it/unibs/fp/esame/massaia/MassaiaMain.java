package it.unibs.fp.esame.massaia;

import it.unibs.fp.esame.mylib.InputDati;
import it.unibs.fp.esame.mylib.MyMenu;

public class MassaiaMain
{
	public static void main(String[] args)
	{

	}

	public static void mostraMenu()
	{
		String[] scelte = { "Crea un nuovo ingrediente", "Crea una nuova ricetta", "Crea un nuovo menu",
				"Visualizza elenco ricette" };

		MyMenu menu = new MyMenu("Menu Ristorante", scelte);
		int scelta = -1;

		do
		{
			scelta = menu.inserisciScelta();

			switch (scelta)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
		while (scelta != 0);
	}

	public static Ingrediente creaIngrediente()
	{
		String nomeIngrediente = InputDati.inputString("Inserisci il nome dell'ingrediente");
		int assettoCalorico = InputDati.input(nomeIngrediente, 0);
	}
}
