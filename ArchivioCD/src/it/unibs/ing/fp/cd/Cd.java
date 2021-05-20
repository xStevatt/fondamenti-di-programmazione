package it.unibs.ing.fp.cd;

import java.util.ArrayList;
import it.unibs.ing.fp.mylib.*;

/**
 * Classe che rappresenta un CD, contente delle canzoni
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class Cd 
{
	private String autore; 
	private String titolo; 
	private ArrayList<Brano> lista_brani; 
	
	public Cd(String titolo, String autore)
	{
		this.titolo = titolo;
		this.autore = autore;  
		lista_brani = new ArrayList<Brano>(); 
	}
	
	public void aggiungiBrano(Brano brano)
	{
		lista_brani.add(brano); 
	}
	
	public boolean eliminaBrano(String titolo)
	{
		int index = cercaBranoTitolo(titolo); 
		if(contiene(titolo))
		{
			lista_brani.remove(index); 
			return true; 
		}
		else
		{
			return false; 
		}
	}
	
	public boolean contiene(String titolo)
	{
		int index = cercaBranoTitolo(titolo); 
		
		if(index != -1)
		{
			return true;
		}
		else
		{
			return false; 
		}
	}
	
	public int cercaBranoTitolo(String titolo)
	{
		for(int i = 0; i < lista_brani.size(); i++)
		{
			if(titolo.equalsIgnoreCase(lista_brani.get(i).getTitolo()))
				return i; 
		}
		return -1; 
	}
	
	public Brano branoCasuale()
	{
		return lista_brani.get(RandomNumbers.getRandomInteger(0, lista_brani.size())); 
	}
	
	public boolean haTitolo(String titolo)
	{
		return this.titolo == titolo ? true : false; 
	}
	
	@Override
	public String toString()
	{
		return titolo + " di " + autore + " brani: " + lista_brani.size();  
	}
	
	public String getAutore()
	{
		return autore; 
	}
	
	public String getTitolo()
	{
		return titolo; 
	}
	
	public ArrayList<Brano> getListaBrani()
	{
		return lista_brani; 
	}
}
