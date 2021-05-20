package it.unibs.ing.fp.cd;

import it.unibs.ing.fp.mylib.*;

public class CDMain
{
	private static final String ERRORE_INPUT_NON_VALIDO = "Errore! Input non valido!";
	
	private static final int MAX_SECONDI = 59;
	private static final int MAX_MINUTI = 59;
	
	private static final String SCELTA_7 = "Mostra un brano casuale";
	private static final String SCELTA_6 = "Mostra un CD casuale";
	private static final String SCELTA_5 = "Visualizza il contenuto di un CD";
	private static final String SCELTA_4 = "Elimina un brano";
	private static final String SCELTA_3 = "Elimina un cd";
	private static final String SCELTA_2 = "Aggiungi un brano ad un cd esistente";
	private static final String SCELTA_1 = "Crea un nuovo CD";

	public static void mostraMenu()
	{
		int scelta = 0; 
		String[] scelte = {SCELTA_1, SCELTA_2, SCELTA_3, SCELTA_4, SCELTA_5, SCELTA_6, SCELTA_7}; 
		MyMenu menu = new MyMenu("Archivio CD", scelte); 
		
		do
		{
			scelta = menu.mostraMenu(); 
			
			switch (scelta) 
			{
			case 1: 
				Cd cd = creaCD(); 
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
		}
		while(scelta != 0); 
	}
	
	public static Cd creaCD()
	{
		String titolo = InputDati.inputString("Inserisci il titolo del CD -> "); 
		String autore = InputDati.inputString("Inserisci l'autore del CD -> "); 
		
		return new Cd(titolo, autore);  
	}
	
	public static Brano creaBrano()
	{
		String titolo = InputDati.inputString("Inserisci il titolo del brano -> "); 

		boolean isDurataValid = false; 
		int minuti = 0, secondi = 0; 
		
		do
		{
			String durata = InputDati.inputString("Inserisci la durata del brano [mm:ss] -> "); 
			
			minuti = Integer.parseInt(durata.substring(0, 2)); 
			secondi = Integer.parseInt(durata.substring(3, 5)); 
			
			if(minuti < MAX_MINUTI|| secondi < MAX_SECONDI)
				isDurataValid = true; 
			else 
				System.out.println(ERRORE_INPUT_NON_VALIDO);
		}
		while(!isDurataValid); 
		
		return new Brano(titolo, minuti, secondi); 
	}
	
	public static void main(String[] args)
	{
		ArchivioCd archivio = new ArchivioCd(); 
		mostraMenu(); 
	}
}
