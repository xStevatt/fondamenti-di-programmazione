package it.unibs.ing.fp.cd;

import java.util.ArrayList;
import it.unibs.ing.fp.mylib.*;

/**
 * Classe che rappresenta un CD, contente delle canzoni.
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
	
	/**
	 * Metodo per l'aggiunta di un brano all'intero della lista di brani
	 * @param brano - viene passato come parametro il brano da aggiungere
	 */
	public void aggiungiBrano(Brano brano)
	{
		lista_brani.add(brano); 
	}
	
	/**
	 * Metodo per eliminare un brano dalla lista di brani
	 * @param titolo - il titolo del brano da eliminare viene passato come parametro al metodo
	 * @return viene ritornato true se l'eliminazione è avvenuta con successo, altrimenti false.
	 */
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
	
	/**
	 * Metodo per verificare se il Cd contiene un particolare brano
	 * @param titolo - il titolo del brano da verificare viene passato come parametro al metodo
	 * @return viene ritornato true se il Cd contiene (nell'ArrayList) un brano con il titolo passato come parametro, altrimenti false
	 */
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
	
	/**
	 * Metodo per cercare un brano all'interno della lista di brani del CD
	 * @param titolo - viene passato il titolo del brano da cercare
	 * @return viene ritornato l'indice (la posizione) dove è stato trovato il brano che ha il titolo passato come parametro, altrimenti viene ritornato -1. 
	 */
	public int cercaBranoTitolo(String titolo)
	{
		for(int i = 0; i < lista_brani.size(); i++)
		{
			if(titolo.equalsIgnoreCase(lista_brani.get(i).getTitolo()))
				return i; 
		}
		return -1; 
	}
	
	/**
	 * Metodo per l'estrazione di un brano casuale
	 * @return viene ritornato il Brano estratto casualmente 
	 */
	public Brano branoCasuale()
	{
		return lista_brani.get(RandomNumbers.getRandomInteger(0, lista_brani.size())); 
	}
	
	/**
	 * Metodo per verificare se un particolare CD ha un particolare titolo passato come parametro
	 * @param titolo - il titolo del brano viene passato come parametro
	 * @return viene ritornato true se il titolo del brano e il titolo passato come parametro sono uguali, altrimenti false
	 */
	public boolean haTitolo(String titolo)
	{
		return this.titolo == titolo ? true : false; 
	}
	
	/**
	 * Metodo per ottenere il numero di brani all'intero della lista di brani
	 * @return viene ritornato un int (intero) attraverso l'uso del metodo size()
	 */
	public int getNumeroBrani()
	{
		return lista_brani.size(); 
	}
	
	@Override
	public String toString()
	{
		return titolo + " di " + autore + " brani: " + lista_brani;  
	}
	
	// GETTERS AND SETTERS
	
	public String getAutore()
	{
		return autore; 
	}
	
	public void setAutore(String autore)
	{
		this.autore = autore; 
	}
	
	public String getTitolo()
	{
		return titolo; 
	}
	
	public void setTitolo(String titolo)
	{
		this.titolo = titolo; 
	}
	
	public ArrayList<Brano> getListaBrani()
	{
		return lista_brani; 
	}
	
	public void setListaBrani(ArrayList<Brano> lista_brani)
	{
		this.lista_brani = lista_brani; 
	}
}
