package it.unibs.ing.fp.lab.TamaZoo;

import java.util.ArrayList;

public class TamaZoo 
{
	private ArrayList<Tamagotchi> lista_tama;
	private String nome; 
	
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
	
	public int getNumeroTamaVivi()
	{
		int counter = 0; 
		for(int i = 0; i < lista_tama.size(); i++)
		{
			if(!lista_tama.get(i).sonoMorto())
			{
				counter++; 
			}
		}
		return counter; 
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

	public String toString() 
	{
		StringBuffer caratteristiche_tama = new StringBuffer("");
		
		for(int i = 0; i < lista_tama.size(); i++)
		{
			if(lista_tama.get(i) instanceof TamaTriste)
			{
				caratteristiche_tama.append("Tipo: TamaTriste"); 
			}
			else if(lista_tama.get(i) instanceof TamaGordo)
			{
				caratteristiche_tama.append("Tipo: TamaGordo"); 
			}
			else
			{
				caratteristiche_tama.append("Tipo: TamaBase"); 
			}
			
			caratteristiche_tama.append("\n"); 
			
			if(lista_tama.get(i).sonoMorto())
			{
				caratteristiche_tama.append("Stato: morto"); 
			}
			else
			{
				caratteristiche_tama.append("Stato: vivo"); 
			}
			caratteristiche_tama.append("\n"); 
			
			if(lista_tama.get(i).sonoTriste())
			{
				caratteristiche_tama.append("Felicità: triste"); 
			}
			else
			{
				caratteristiche_tama.append("Felicità: felice"); 
			}
			caratteristiche_tama.append("\n"); 
			
			caratteristiche_tama.append("Nome: " + lista_tama.get(i).getNome() + "\n"); 
			caratteristiche_tama.append("Soddifazione affettiva: " + lista_tama.get(i).getSoddisfazione_affettiva() + "\n"); 
			caratteristiche_tama.append("Grado sazietà: " + lista_tama.get(i).getGrado_sazietà() + "\n"); 
			caratteristiche_tama.append("\n"); 
		}
		return caratteristiche_tama.toString(); 
	}
}
