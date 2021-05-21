package it.unibs.ing.fp.cd;

import it.unibs.ing.fp.mylib.InputDati;
import it.unibs.ing.fp.mylib.MyMenu;
import it.unibs.ing.fp.mylib.RandomNumbers;

public class ArchivioCDMenu 
{
	private static final String ERRORE_NON_�_PRESENTE_ALCUN_CD_NELL_ARCHIVIO = "ERRORE! - Non � presente alcun CD nell'archivio.";
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
	
	/**
	 * Si occupa di gestire la visualizzazione del menu
	 */
	public static void mostraMenu()
	{
		int scelta = 0; 
		String[] scelte = {SCELTA_1, SCELTA_2, SCELTA_3, SCELTA_4, SCELTA_5, SCELTA_6, SCELTA_7, SCELTA_8}; 
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
						index = archivio.cercaTitoloCD(titolo); 
						archivio.getLista_CD().get(index); 
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
				break; 
			case 3: 
				String titolo_cd_da_eliminare = InputDati.inputString("Inserire il titolo del CD da eliminare -> "); 
				if(archivio.eliminaCd(titolo_cd_da_eliminare))
				{
					System.out.println("AVVISO - Brano eliminato correttamente.");
				}
				else
				{
					System.out.println("ERRORE - Impossibile eliminare il brano.");
				}
				break; 
			case 4: 
				System.out.println("Inserire il titolo del brano che vuoi eliminare -> ");
				String titolo_brano_da_eliminare = InputDati.inputString("Inserire il titolo del brano da eliminare -> ");
				
				for(int i = 0; i < archivio.getLista_CD().size(); i++)
				{
					
				}
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
					System.out.println(ERRORE_NON_�_PRESENTE_ALCUN_CD_NELL_ARCHIVIO);
				}
				break; 
			case 8: 
				archivio.toString(); 
				break; 
			case 9: 
				
				break; 
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
			}
			System.out.println("\n");
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
	 * @param brano - � il brano le cui informazioni devono essere stampate a schermo
	 * @param cd - � il cd le cui informazioni devono essere stampate a schermo
	 */
	public static void visualizzaInfoBrano(Brano brano, Cd cd)
	{
		// DA RIFARE CON TO STRING
		System.out.println("BRANO ESTRATTO: " + brano.getTitolo());
		System.out.println("CD: " + cd.getTitolo());
		System.out.println("AUTORE: " + cd.getAutore());
		System.out.println();
	}
}