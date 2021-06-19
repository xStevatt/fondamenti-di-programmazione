package it.unibs.ing.fp.veterinario;

import java.util.ArrayList;

public class Agenda 
{
	private static final int NUMERO_SETTIMANE = 52;
	
	ArrayList<Settimana> lista_settimane = new ArrayList<Settimana>(); 
	
	public void inizializzaAgenda()
	{
		for(int i = 0; i < NUMERO_SETTIMANE; i++)
		{
			lista_settimane.add(new Settimana(i)); 
		}
	}
}
