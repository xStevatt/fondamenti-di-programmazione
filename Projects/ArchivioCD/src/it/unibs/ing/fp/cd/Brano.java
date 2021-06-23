package it.unibs.ing.fp.cd;

/**
 * Classe che rappresenta un brano musicale.
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
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
		return titolo + " - durata: " + durata_minuti + ":" + durata_secondi; 
	}
	
	public String getTitolo()
	{
		return titolo; 
	}
	
	public int getDurata_minuti()
	{
		return durata_minuti; 
	}
	
	public int getDurata_secondi()
	{
		return durata_secondi; 
	}
}
