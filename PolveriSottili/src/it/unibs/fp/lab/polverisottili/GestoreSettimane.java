package it.unibs.fp.lab.polverisottili;

import java.util.ArrayList;
import it.unibs.fp.lab.mylib.GenerateMenu;

public class GestoreSettimane 
{
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
		String[] scelte = { "Aggiungi una settimana (verranno conisderati i dati anche delle settimane precedenti)",
							"Visualizza dati delle settimane consecutive inserite",
							"Aggiungi una settimana (senza considerare le precedenti)", 
							"Visualizza i dati di tutte le settimane inserite" };

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
				System.out.println("\n\nGrazie per aver usato Polveri Sottili!");
				break;
			case 1:
				settimana = new Settimana();
				settimana_list_temp.add(settimana);
				lista_settimane.add(settimana);
				break;
			case 2:
				settimana = new Settimana();
				settimana_list_temp.clear();
				break;
			case 3: 
				calcolaInfoSettimaneTotali(settimana_list_temp);
				settimana_list_temp.clear();
				break; 
			case 4: 
				calcolaInfoSettimaneTotali(lista_settimane);
				break; 
			default:
				throw new IllegalArgumentException("Unexpected value: " + scelta);
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
		}
		
		System.out.println("Dati settimane inserite: ");
		determinaStatoMedia(media);
		determinaStatoMassimo(max);
	}
	
	public void determinaStatoMedia(double media)
	{
		if(media > 50)
		{
			System.out.println("ATTENZIONE! - La media settimanale è troppo alta!");
		}
	}
	
	public void determinaStatoMassimo(double max)
	{
		if(max > 75)
		{
			System.out.println("ATTENZIONE! - È stata superata la soglia massima di sicurezza!");
		}
	}
}
