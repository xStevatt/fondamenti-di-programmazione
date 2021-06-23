package it.unibs.ing.fp.veterinario;

import java.util.ArrayList; 

public class Settimana 
{
	private static final int GIORNI_IN_UNA_SETTIMANA = 7;
	
	private int numeroSettimana; 
	private Giorno[] listaGiorni;  
		
	public Settimana(int numeroSettimana)
	{
		listaGiorni = new Giorno[GIORNI_IN_UNA_SETTIMANA]; 
		this.numeroSettimana = numeroSettimana; 
		inizializzaSettimana();
	}
	
	public void inizializzaSettimana()
	{
		int counterGiorni = 0; 
		for(GiornoSettimana giorno : GiornoSettimana.values())
		{
			listaGiorni[counterGiorni++] = new Giorno(giorno); 
			System.out.println(listaGiorni[counterGiorni]);
		}
	}
	
	public Giorno[] getListaGiorni()
	{
		return this.listaGiorni; 
	}
	
	public int getNumeroSettimana()
	{
		return this.numeroSettimana; 
	}
}
