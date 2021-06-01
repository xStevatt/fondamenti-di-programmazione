package it.unibs.ing.fp.cartaalta;

import java.util.ArrayList;

import it.unibs.ing.fp.mylib.RandomNumbers;

/**
 * Mazzo rappresenta un mazzo da gioco. Esso è caratterizzato da una lista di carte. 
 * 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class Mazzo
{
	private ArrayList<Carta> carte = new ArrayList<Carta>(); 
	
	public Mazzo(TipoMazzo tipo_mazzo)
	{
		carte = costruisciMazzo(tipo_mazzo.getSemi(), tipo_mazzo.getValori()); 
	}
	
	public Carta estraiCarta()
	{
		int index_estratto = RandomNumbers.getRandomInteger(0, carte.size()); 
		Carta carta_estratta = carte.get(index_estratto); 
		return carta_estratta; 
	}
	
	public ArrayList<Carta> costruisciMazzo(String[] semi, ValoreCarta[] valori)
	{
		ArrayList<Carta> mazzo = new ArrayList<Carta>(); 
		
		for(int i = 0; i < semi.length; i++)
		{
			for(int j = 0; j < valori.length; j++)
			{
				Carta carta = new Carta(semi[i], valori[j]); 
				mazzo.add(carta); 
			}
		}
		return mazzo; 
	}

	public ArrayList<Carta> getCarte() 
	{
		return carte;
	}

	public void setCarte(ArrayList<Carta> carte) 
	{
		this.carte = carte;
	}
}
