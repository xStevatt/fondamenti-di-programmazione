package it.unibs.ing.fp.lab.TamaZoo;

import java.util.ArrayList;

public class TamaZoo 
{
	ArrayList<Tamagotchi> lista_tama;
	
	public TamaZoo()
	{
		lista_tama = new ArrayList<Tamagotchi>(); 
	}
	
	public void aggiungiTama(Tamagotchi tamagotchi)
	{
		lista_tama.add(tamagotchi); 
	}
	
	public void removeTama(Tamagotchi tamagotchi)
	{
		lista_tama.remove(tamagotchi); 
	}
	
	public void daiCarezze(int carezze)
	{
		for(int i = 0; i < lista_tama.size(); i++)
		{
			if(!lista_tama.get(i).sonoMorto())
			{
				lista_tama.get(i).riceviCarezze(carezze);
			}
		}
	}
	
	public void daiBiscotti(int biscotti)
	{
		for(int i = 0; i < lista_tama.size(); i++)
		{
			if(!lista_tama.get(i).sonoMorto())
			{
				lista_tama.get(i).riceviBiscotti(biscotti);
			}
		}
	}
	
	public boolean areAllTamaDead()
	{
		boolean areAllTamaDead = true; 
		int i = 0; 
		
		while(areAllTamaDead && i < lista_tama.size())
		{
			if(!lista_tama.get(i).sonoMorto())
			{
				areAllTamaDead = false; 
			}
			
			i++; 
		}
		
		return areAllTamaDead; 
	}
}
