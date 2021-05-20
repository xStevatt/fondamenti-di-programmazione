package it.unibs.ing.fp.cd;

import java.util.Random;

import it.unibs.ing.fp.mylib.*;

/**
 * Classe main, gestisce il menu.
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class CDMain
{
	private static final String ERRORE_NON_È_PRESENTE_ALCUN_CD_NELL_ARCHIVIO = "ERRORE! - Non è presente alcun CD nell'archivio.";
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

	/**
	 * 
	 */
	public static void mostraMenu()
	{
		int scelta = 0; 
		String[] scelte = {SCELTA_1, SCELTA_2, SCELTA_3, SCELTA_4, SCELTA_5, SCELTA_6, SCELTA_7}; 
		MyMenu menu = new MyMenu("Archivio CD", scelte); 
		
		ArchivioCd archivio = new ArchivioCd(); 
		
		do
		{
			scelta = menu.mostraMenu(); 
			
			switch (scelta) 
			{
			case 1: 
				// Aggiunge un CD all'archivio
				Cd cd = creaCD(); 
				archivio.aggiungiCd(cd);
				break; 
			case 2: 
				// Aggiunge un brano ad un CD scelto da tastiera dall'utente
				String titolo = InputDati.inputString("Inserisci il titolo del cd a cui vuoi aggiungere un brano -> "); 
				
				int index = -1; 
				
				if(index != -1)
				{
					try
					{
						index = archivio.cercaBranoTitolo(titolo); 
						archivio.getLista_CD().get(index); 
						System.out.println("AVVISO - Brano aggiunto correttamente.");
					}
					catch(Exception e)
					{
						System.out.println("Errore nell'aggiunta.");
					}
				}
				else
				{
					System.out.println("ERRORE - Impossibile aggiungere il brano: CD inesistente.");
				}
				break; 
			case 3: 
				String titolo_da_eliminare = InputDati.inputString("Inserisci il titolo da eliminare -> "); 
				if(archivio.eliminaCd(titolo_da_eliminare))
				{
					System.out.println("AVVISO - Brano eliminato correttamente.");
				}
				else
				{
					System.out.println("ERRORE - Impossibile eliminare il brano.");
				}
				break; 
			case 4: 
				break; 
			case 5: 
				break; 
			case 6: 
				break; 
			case 7: 
				if(archivio.getNumeroCd() > 0)
				{
					Cd cd_rand = archivio.getLista_CD().get(RandomNumbers.getRandomInteger(0, archivio.getNumeroCd())); 				
					Brano brano_rand = cd_rand.branoCasuale(); 
					visualizzaInfoBrano(brano_rand, cd_rand);
				}
				else
				{
					System.out.println(ERRORE_NON_È_PRESENTE_ALCUN_CD_NELL_ARCHIVIO);
				}
				break; 
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
		}
		while(scelta != 0); 
	}
	
	/**
	 * 
	 * @return
	 */
	public static Cd creaCD()
	{
		String titolo = InputDati.inputString("Inserisci il titolo del CD -> "); 
		String autore = InputDati.inputString("Inserisci l'autore del CD -> "); 
		
		return new Cd(titolo, autore);  
	}
	
	/**
	 * 
	 * @return
	 */
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
	
	/**
	 * 
	 * @param brano
	 * @param cd
	 */
	public static void visualizzaInfoBrano(Brano brano, Cd cd)
	{
		// DA RIFARE CON TO STRING
		System.out.println("BRANO ESTRATTO: " + brano.getTitolo());
		System.out.println("CD: " + cd.getTitolo());
		System.out.println("AUTORE: " + cd.getAutore());
		System.out.println();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArchivioCd archivio = new ArchivioCd(); 
		mostraMenu(); 
	}
}
