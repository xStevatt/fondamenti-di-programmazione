package it.unibs.ing.fp.cd;

public class Brano 
{
	private String titolo; 
	private int durata_minuti; 
	private int durata_secondi; 
	
	public Brano(String titolo, int durata_minuti, int durata_secondi)
	{
		this.titolo = titolo; 
		this.durata_minuti = durata_minuti; 
		this.durata_secondi = durata_secondi; 
	}
	
	@Override
	public String toString()
	{
		return titolo + " durata: " + durata_minuti + ":" + durata_secondi; 
	}
}
