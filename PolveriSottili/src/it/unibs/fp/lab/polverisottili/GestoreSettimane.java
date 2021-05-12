package it.unibs.fp.lab.polverisottili;

import java.util.ArrayList;
import it.unibs.fp.lab.mylib.GenerateMenu;

public class GestoreSettimane 
{
	private static final String STAMPA_VALORE_MASSIMO = "Il valore massimo vale: ";
	private static final String STAMPA_VALORE_MEDIA = "La media vale: ";
	private static final String VAI_A_CAPO = "\n";
	private static final String UNEXPECTED_VALUE = "Unexpected value: ";
	private static final String SCELTA_4 = "Visualizza i dati di tutte le settimane inserite";
	private static final String SCELTA_3 = "Aggiungi una settimana (senza considerare le precedenti)";
	private static final String SCELTA_2 = "Visualizza dati delle settimane consecutive inserite";
	private static final String SCELTA_1 = "Aggiungi una settimana (verranno conisderati i dati anche delle settimane precedenti)";
	private static final String MESSAGGIO_CHIUSURA = "\n\nGrazie per aver usato Polveri Sottili!";
	private static final String MESSAGGIO_ANALISI_DEI_DATI_RACCOLTI = "Analisi dei dati raccolti: ";
	private static final String AVVISO_DATI_NELLA_NORMA = "Dati nella norma. Respirate a pieni polmoni!";
	private static final String AVVISO_MAX_ALTO = "ATTENZIONE! - È stata superata la soglia massima di sicurezza!";
	private static final String AVVISO_MEDIA_ALTA = "ATTENZIONE! - La media settimanale è troppo alta!";
	private static final int GIORNI_SETTIMANA = 7;
	
	private ArrayList<Settimana> lista_settimane;

	public GestoreSettimane() 
	{
		lista_settimane = new ArrayList<Settimana>();
	}

	public Settimana creaSettimana() 
	{
		Settimana settimana = null;

		return settimana;
	}

	public void mostraMenu() 
	{
		String[] scelte = { SCELTA_1,
							SCELTA_2,
							SCELTA_3, 
							SCELTA_4 };

		GenerateMenu menu = new GenerateMenu("Polveri Sottili", scelte);

		int scelta = -1;

		do 
		{
			scelta = menu.mostraMenu();
			ArrayList<Settimana> settimana_list_temp = new ArrayList<Settimana>();
			Settimana settimana = null; 
			
			
			switch (scelta) 
			{
			case 0:
				System.out.println(MESSAGGIO_CHIUSURA);
				break;
			case 1:
				settimana = new Settimana();
				
				settimana_list_temp.add(settimana); // Aggiunge la settimana alla lista delle settimane consecutive
				lista_settimane.add(settimana); // Aggiunge la settimana alla lista contenente tutte le settimane
				break;
			case 2:
				calcolaInfoSettimaneTotali(settimana_list_temp);
				settimana_list_temp.clear();
				break;
			case 3: 
				settimana_list_temp.clear();
				settimana = new Settimana();
				calcolaMassimoMedia(settimana.media_dati(), settimana.trovaMassimo());
				lista_settimane.add(settimana); 
				break; 
			case 4: 
				calcolaInfoSettimaneTotali(lista_settimane);
				break; 
			default:
				throw new IllegalArgumentException(UNEXPECTED_VALUE + scelta);
			}
		} 
		while (scelta != 0);
	}
	
	public void calcolaInfoSettimaneTotali(ArrayList<Settimana> settimane)
	{
		double somma_pol_sottili = 0.0; 
		double media = 0.0; 
		double max = 0.0; 
		
		for(int i = 0; i < settimane.size(); i++)
		{
			somma_pol_sottili += settimane.get(i).somma_dati(); 
		}
		
		media = somma_pol_sottili / GIORNI_SETTIMANA * settimane.size(); 
		
		for(int i = 0; i < settimane.size(); i++)
		{
			max = Math.max(max, settimane.get(i).trovaMassimo()); 
			System.out.println(max);
		}
		calcolaMassimoMedia(media, max);
	}
	
	public void calcolaMassimoMedia(double media, double max)
	{
		System.out.println(MESSAGGIO_ANALISI_DEI_DATI_RACCOLTI);
		if(media > 50)
		{
			System.out.println(AVVISO_MEDIA_ALTA);
			System.out.println(STAMPA_VALORE_MEDIA + media);
		}
		
		if(max > 75)
		{
			System.out.println(AVVISO_MAX_ALTO);
			System.out.println(STAMPA_VALORE_MASSIMO + max);
		}
		if(media < 50 && max < 75)
		{
			System.out.println(AVVISO_DATI_NELLA_NORMA);
			System.out.println(media + " " + max);
		}
		System.out.println(VAI_A_CAPO);
	}
}
