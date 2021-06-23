package it.unibs.ing.fp.lab.TamaZoo;

import java.util.ArrayList;

/**
 * TamaZoo
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class TamaZoo 
{
	private ArrayList<Tamagotchi> lista_tama;
	private String nome; 
	
	public TamaZoo()
	{
		lista_tama = new ArrayList<Tamagotchi>(); 
	}
	
	/**
	 * Aggiunge un tamagotchi alla lista lista_tama
	 * 
	 * @param tamagotchi - L'oggetto da aggiungere alla lista dei tamagtochi
	 */
	public void aggiungiTama(Tamagotchi tamagotchi)
	{
		lista_tama.add(tamagotchi); 
	}
	
	/**
	 * Rimuove un oggetto dalla lista lista_tama
	 * 
	 * @param tamagotchi - L'oggetto da rimuovere alla lista dei tamagotchi
	 */
	public void removeTama(Tamagotchi tamagotchi)
	{
		lista_tama.remove(tamagotchi); 
	}
	
	/**
	 * Permette di interagire dando un particolare numero di carezze al tamagotchi
	 * 
	 * @param carezze viene passato come parmetro il numero di carezze da dare al tamagotchi 
	 */
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
	
	/**
	 * Permette di interagire dando un particolare numero di carezze al tamagotchi
	 * 
	 * @param carezze - viene passato come parmetro il numero di carezze da dare al tamagotchi 
	 */
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
	
	/**
	 * Ritorna il numero di tamagotchi vivi presenti nella lista
	 * 
	 * @return counter - il numero di tamagotchi vivi che sono stati trovati nella lista
	 */
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
	
	/**
	 * Controlla se tutti i tamagotchi sono morti. In caso positivo 
	 * (i tamagotchi sono tutti morti), allora ritorna true, altrimenti
	 * ritorna false. 
	 * 
	 * @return areAllTamaDead - se tutti i tamagotchi sono morti allora rimane true, altrimenti false
	 */
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

	/**
	 * Ritorna una stringa che contiene tutte le informazioni dei tamagotchi 
	 */
	public String toString() 
	{
		StringBuffer caratteristiche_tama = new StringBuffer("Nome tamazoo: " + nome + "\n");
		
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
