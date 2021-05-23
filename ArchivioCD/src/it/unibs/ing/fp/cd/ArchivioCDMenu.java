package it.unibs.ing.fp.cd;

import java.util.ArrayList;

import it.unibs.ing.fp.mylib.InputDati;
import it.unibs.ing.fp.mylib.MyMenu;
import it.unibs.ing.fp.mylib.RandomNumbers;

public class ArchivioCDMenu 
{
	private static final String ERRORE_NON_È_PRESENTE_ALCUN_CD_NELL_ARCHIVIO = "ERRORE! - Non è presente alcun CD nell'archivio.";
	private static final String ERRORE_INPUT_NON_VALIDO = "Errore! Input non valido!";
	
	private static final int MAX_SECONDI = 59;
	private static final int MAX_MINUTI = 59;
	
	private static final String SCELTA_9 = "Estrai un lista casuali di brani"; 
	private static final String SCELTA_8 = "Mostra contenuto di tutti i CD";
	private static final String SCELTA_7 = "Mostra un brano casuale";
	private static final String SCELTA_6 = "Mostra un CD casuale";
	private static final String SCELTA_5 = "Visualizza il contenuto di un CD";
	private static final String SCELTA_4 = "Elimina un brano";
	private static final String SCELTA_3 = "Elimina un cd";
	private static final String SCELTA_2 = "Aggiungi un brano ad un cd esistente";
	private static final String SCELTA_1 = "Crea un nuovo CD";
	
	public static ArchivioCd archivio = new ArchivioCd(); 
	
	/**
	 * Si occupa di gestire la visualizzazione del menu
	 */
	public static void mostraMenu()
	{
		int scelta = 0; 
		String[] scelte = {SCELTA_1, SCELTA_2, SCELTA_3, SCELTA_4, SCELTA_5, SCELTA_6, SCELTA_7, SCELTA_8, SCELTA_9}; 
		MyMenu menu = new MyMenu("Archivio CD", scelte); 
		
		do
		{
			scelta = menu.mostraMenu(); 
			
			switch (scelta) 
			{
			case 1: 
				aggiungiCDArchivio();
				break; 
			case 2: 
				aggiungiBranoToCD();
				break; 
			case 3: 
				eliminaCD();
				break; 
			case 4: 
				eliminaBrano();
				break; 
			case 5:
				visualizzaContenutoCD();
				break; 
			case 6: 
				mostraUnCdCasuale(); 
				break; 
			case 7: 
				mostraUnBranoCasuale();
				break; 
			case 8: 
				mostraContenutoTuttiCd(); 
				break; 
			case 9: 
				estraiListaCasualeBrani(); 
				break; 
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
			System.out.println("\n");
		}
		while(scelta != 0); 
	}

	/**
	 * estraiListaCasualeBrani mostra a schermo un numero casuale di brani estratti da CD casuali
	 * @param archivio - l'archivio dei CD dai quali si devono estrarre brani casuali
	 */
	private static void estraiListaCasualeBrani()
	{
		int numbers_amount = RandomNumbers.getRandomInteger(1, 10); 
		for(int i = 0; i < numbers_amount; i++)
		{
			Cd cd_estratto = archivio.cdCasuale(); 
			Brano brano_estratto = cd_estratto.branoCasuale(); 
			System.out.println(brano_estratto.toString());
		}
	}
	
	private static void mostraContenutoTuttiCd()
	{
		for(int i = 0; i < archivio.getNumeroCd(); i++)
		{
			System.out.println(archivio.visualizzaContenutoCD(i));
		}
	}
	
	private static void mostraUnBranoCasuale()
	{
		Cd cd_estratto = archivio.cdCasuale(); 
		
		Brano brano_estratto = cd_estratto.branoCasuale(); 
		
		System.out.println(brano_estratto.toString());
	}
	
	private static void mostraUnCdCasuale()
	{
		Cd cd_estratto = archivio.cdCasuale(); 
		System.out.println(cd_estratto.toString());
	}
	
	private static void visualizzaContenutoCD()
	{
		System.out.println("CD disponibili: \n" + archivio.toString());
		String titolo_cd = InputDati.inputString("Inserisci il titolo del CD che vuoi visualizzare -> "); 
		
		if(archivio.contiene(titolo_cd))
		{
			System.out.println(archivio.visualizzaContenutoCD(archivio.cercaTitoloCD(titolo_cd)));
		}
		else
		{
			System.out.println("ERRORE! - Non è presente un CD con il nome inserito.");
		}
	}
	
	private static void eliminaBrano() {
		System.out.println("Inserire il titolo del brano che vuoi eliminare -> ");
		String titolo_brano_da_eliminare = InputDati.inputString("Inserire il titolo del brano da eliminare -> ");
		
		for(int i = 0; i < archivio.getLista_CD().size(); i++)
		{
			
		}
	}

	private static void eliminaCD() {
		String titolo_cd_da_eliminare = InputDati.inputString("Inserire il titolo del CD da eliminare -> "); 
		if(archivio.eliminaCd(titolo_cd_da_eliminare))
		{
			System.out.println("AVVISO - Brano eliminato correttamente.");
		}
		else
		{
			System.out.println("ERRORE - Impossibile eliminare il brano.");
		}
	}

	private static void aggiungiBranoToCD() {
		String titolo = InputDati.inputString("Inserisci il titolo del cd a cui vuoi aggiungere un brano -> "); 
		
		int index = archivio.cercaTitoloCD(titolo); 
		
		if(index != -1)
		{
			try
			{
				Brano brano = creaBrano(); 
				archivio.getLista_CD().get(index).aggiungiBrano(brano);
				System.out.println("AVVISO - Brano aggiunto correttamente.");
			}
			catch(Exception e)
			{
				System.out.println("ERRORE - Impossibile aggiungere il brano: Errore");
			}
		}
		else
		{
			System.out.println("ERRORE - Impossibile aggiungere il brano: CD inesistente.");
		}
	}

	/**
	 * Aggiunge un CD all'archivio. Utilizza il metodo creaCd() e aggiunge il cd creato alla lista del cd dell'archivio.
	 */
	private static void aggiungiCDArchivio() 
	{
		// Aggiunge un CD all'archivio
		Cd cd = creaCD(); 
		archivio.aggiungiCd(cd);
		System.out.println("AVVISO - " + cd.getTitolo() + " aggiunto correttamente");
	}
	
	/**
	 * Richiesta in input dei dati di input per la creazione del CD
	 * @return Cd - ritorna l'oggetto di tipo Cd che è stato creato
	 */
	private static Cd creaCD()
	{
		String titolo = InputDati.inputString("Inserisci il titolo del CD -> "); 
		String autore = InputDati.inputString("Inserisci l'autore del CD -> "); 
		
		return new Cd(titolo, autore);  
	}
	
	/**
	 * Avviene effettuata la richiesta in input dei dati di input per la creazione del CD
	 * @return Brano - ritorna l'oggetto di tipo Brano che è stato creato
	 */
	private static Brano creaBrano()
	{
		String titolo = InputDati.inputString("Inserisci il titolo del brano -> "); 

		boolean isDurataValid = false; 
		int minuti = 0, secondi = 0; 
		
		do
		{
			String durata = InputDati.inputString("Inserisci la durata del brano [mm:ss] -> "); 
			
			minuti = Integer.parseInt(durata.substring(0, 2)); 
			secondi = Integer.parseInt(durata.substring(3, 5)); 
			
			if(minuti < MAX_MINUTI || secondi < MAX_SECONDI)
				isDurataValid = true; 
			else 
				System.out.println(ERRORE_INPUT_NON_VALIDO);
		}
		while(!isDurataValid); 
		
		return new Brano(titolo, minuti, secondi); 
	}
	
}
