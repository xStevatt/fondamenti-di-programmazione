package it.unibs.fp.magazzino;

/**
 * Classe che rappresenta un ordine. Un ordine è caratterizzato da un articolo e
 * da una quantità richiesta
 * 
 * @author Stefano Valloncini
 *
 */
public class Ordine
{
	private static final String TEMPO_DA_ASPETTARE = ", Tempo da aspettare: ";
	private static final String QUANTITÀ2 = ", Quantità: ";
	private static final String NOME_ARTICOLO = "Nome articolo: ";

	private Articolo articolo;
	private int quantità;
	private int giorniAspetto;

	public Ordine(Articolo articolo, int quantità)
	{
		this.articolo = articolo;
		this.quantità = quantità;
	}

	@Override
	public String toString()
	{
		return NOME_ARTICOLO + articolo.getNomeArticolo() + QUANTITÀ2 + quantità + TEMPO_DA_ASPETTARE + giorniAspetto;
	}

	public Articolo getArticolo()
	{
		return articolo;
	}

	public void setArticolo(Articolo articolo)
	{
		this.articolo = articolo;
	}

	public int getQuantità()
	{
		return quantità;
	}

	public void setQuantità(int quantità)
	{
		this.quantità = quantità;
	}

	public int getGiorniAspetto()
	{
		return giorniAspetto;
	}

	public void setGiorniAspetto(int giorniAspetto)
	{
		this.giorniAspetto = giorniAspetto;
	}
}
