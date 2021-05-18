package it.unibs.fp.lab.polverisottili;

import java.util.ArrayList;
import it.unibs.fp.lab.mylib.GenerateMenu;
import it.unibs.fp.lab.mylib.InputDati;

/**
 * Classe per mostrare a schermo il menu di scelta
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class GestoreSettimane 
{
	// COSTANTI STRINGHE
	private static final String TITOLO_MENU = "Polveri Sottili";
	private static final String MESSAGGIO_NUMERO_DELLA_SETTIMANA_CORRENTE = "Inserisci il numero della settimana corrente: ";
	private static final String MESSAGGIO_INSERIMENTO_ANNO_SETTIMANA = "Inserisci l'anno della settimana corrente: ";
	private static final String STAMPO_I_DATI = "STAMPO I DATI: ";
	private static final String SCELTA_4 = "Visualizza i dati di tutte le settimane inserite";
	private static final String SCELTA_3 = "Aggiungi una settimana (senza considerare le precedenti)";
	private static final String SCELTA_2 = "Visualizza dati delle settimane consecutive inserite";
	private static final String SCELTA_1 = "Aggiungi una settimana (verranno conisderati i dati anche delle settimane precedenti)";
	private static final String STAMPA_VALORE_MASSIMO = "Massimo: ";
	private static final String STAMPA_VALORE_MEDIA = "Media: ";
	private static final String VAI_A_CAPO = "\n";
	private static final String MESSAGGIO_CHIUSURA = "\n\nGrazie per aver usato Polveri Sottili!";
	private static final String MESSAGGIO_ANALISI_DEI_DATI_RACCOLTI = "Analisi dei dati raccolti: ";
	private static final String AVVISO_DATI_NELLA_NORMA = "Dati nella norma. Respirate a pieni polmoni!";
	private static final String AVVISO_MAX_ALTO = "ATTENZIONE! - È stata superata la soglia massima di sicurezza!";
	private static final String AVVISO_MEDIA_ALTA = "ATTENZIONE! - La media settimanale è troppo alta!";
	
	// COSTANTI INTERE
	private static final int GIORNI_SETTIMANA = 7;
	private static final int VALORE_SOGLIA_MASSIMO = 75;
	private static final int VALORE_SOGLIA_MEDIA = 50;
	
	private ArrayList<Settimana> lista_settimane;

	public GestoreSettimane() 
	{
		lista_settimane = new ArrayList<Settimana>();
	}

	/**
	 * Metodo si occupa di gestire il menu e le scelte. 
	 */
	public void mostraMenu() 
	{
		String[] scelte = { SCELTA_1, SCELTA_2, SCELTA_3, SCELTA_4 };

		GenerateMenu menu = new GenerateMenu(TITOLO_MENU, scelte);

		int scelta = -1;
		ArrayList<Settimana> settimana_list_temp = new ArrayList<Settimana>();
		
		do 
		{
			System.out.println(VAI_A_CAPO);
			scelta = menu.mostraMenu();

			Settimana settimana = null; 
			
			switch (scelta) 
			{
			case 0: 	// Caso di chiusura del programma									
				System.out.println(MESSAGGIO_CHIUSURA);
				break;
			case 1:		// Aggiunge una settimana considerando i dati anche delle precedenti
				settimana = creaSettimana();
				settimana_list_temp.add(settimana); // aggiunge la settimana alla lista delle settimane consecutive
				calcolaInfoSettimaneTotali(settimana_list_temp);
				lista_settimane.add(settimana); // aggiunge la settimana alla lista totale delle settimane
				break;
			case 2:
				if(settimana_list_temp.size() > 0)
					calcolaInfoSettimaneTotali(settimana_list_temp);
				else
					System.out.println("Nessun elemento inserito");
				break;
			case 3:		// Aggiunge una nuova settimana senza considerare quelle precedenti
				settimana_list_temp.clear();
				settimana = creaSettimana();
				calcolaMassimoMedia(settimana.media_dati(), settimana.trovaMassimo());
				lista_settimane.add(settimana); 
				break; 
			case 4: 	// Visualizza tutte le informazioni riguardanti tutte le settimane inserite
				calcolaInfoSettimaneTotali(lista_settimane);
				break; 
			}
		} 
		while (scelta != 0);
	}
	
	/**
	 * Metodo per la creazione della settimana (statico)
	 * @return settimana - l'oggetto di tipo settimana che è stato creato viene ritornato
	 */
	public static Settimana creaSettimana()
	{
		int anno = InputDati.inputInteger(MESSAGGIO_INSERIMENTO_ANNO_SETTIMANA); 
		int n_settimana = InputDati.inputInteger(MESSAGGIO_NUMERO_DELLA_SETTIMANA_CORRENTE, 1, 53); 
		double [] dati_giornalieri = new double[GIORNI_SETTIMANA]; 
		
		for(int i = 0; i < dati_giornalieri.length; i++)
		{
			dati_giornalieri[i] = InputDati.inputDouble("Inserisci i dati per il giorno " + (i + 1) + " della settimana: "); 
		}
		
		Settimana settimana = new Settimana(anno, n_settimana, dati_giornalieri); 
		return settimana;
	}
	
	/**
	 * Metodo che serve a calcolare le statistiche di tutte le settimane inserite fino a quel momento
	 */
	public void calcolaInfoSettimaneTotali(ArrayList<Settimana> settimane)
	{
		double somma_pol_sottili = 0.0; 
		double media = 0.0; 
		double max = 0.0; 
		
		for(int i = 0; i < settimane.size(); i++)
		{
			somma_pol_sottili += settimane.get(i).somma_dati(); 
		}
		
		media = somma_pol_sottili / (GIORNI_SETTIMANA * settimane.size()); 
		
		for(int i = 0; i < settimane.size(); i++)
		{
			max = Math.max(max, settimane.get(i).trovaMassimo()); 
		}
		calcolaMassimoMedia(media, max);
	}
	
	/**
	 * Metodo che serve ad analizzare i dati inseriti. 
	 * - Se la media è maggiore di 50 allora verrà stampato a schermo il relativo avviso
	 * - Se il massimo  valore settimanale è maggiore di 75 allora verrà stampato a schermo il relativo avviso
	 * - Se nessuna delle precedenti allora stampa un messaggio diverso dai precedenti
	 * - Mostra i valori di media e massimo
	 */
	public void calcolaMassimoMedia(double media, double max)
	{
		System.out.println(MESSAGGIO_ANALISI_DEI_DATI_RACCOLTI);
		if(media > VALORE_SOGLIA_MEDIA)
		{
			System.out.println(AVVISO_MEDIA_ALTA);
			System.out.println(STAMPA_VALORE_MEDIA + media);
		}
		
		if(max > VALORE_SOGLIA_MASSIMO)
		{
			System.out.println(AVVISO_MAX_ALTO);
			System.out.println(STAMPA_VALORE_MASSIMO + max);
		}
		if(media <= VALORE_SOGLIA_MEDIA && max <= VALORE_SOGLIA_MASSIMO)
		{
			System.out.println(AVVISO_DATI_NELLA_NORMA);
		}
		stampaDati(media, max);
	}
	
	public void stampaDati(double media, double max)
	{
		System.out.println(STAMPO_I_DATI);
		System.out.println(STAMPA_VALORE_MEDIA + media);
		System.out.println(STAMPA_VALORE_MASSIMO + max);
	}
}
