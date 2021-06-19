package it.unibs.ing.fp.veterinario;

public class Orario 
{
	int ore; 
	int minuti; 
	
	public Orario(int ore, int minuti)
	{
		this.ore = ore; 
		this.minuti = minuti; 
	}
	
	public boolean isOrarioValid(Orario orario)
	{
		return orario.getMinuti() <= 59 && orario.getOre() <= 23; 
	}
	
	public int getNumeroSecondi()
	{
		System.out.println(ore * minuti * 60 * 60);
		return ore * minuti * 60 * 60; 
	}
	
	/**
	 * ritorna true se l'orario passato viene prima dell'orario corrente
	 * @param orario
	 * @return
	 */
	public boolean confrontaOrari(Orario orario)
	{
		return this.getNumeroSecondi() < orario.getNumeroSecondi(); 
	}
	
	@Override
	public String toString()
	{
		return ore + ":" + minuti; 
	}
	
	public int getOre()
	{
		return ore; 
	}
	
	public void setOre(int ore)
	{
		this.ore = ore; 
	}
	
	public int getMinuti()
	{
		return minuti; 
	}
	
	public void setMinuti(int minuti)
	{
		this.minuti = minuti; 
	}
}