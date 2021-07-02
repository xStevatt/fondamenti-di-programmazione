package it.unibs.fp.titoliazionari;

public class Lotto
{
	private Titolo titoloAzione;
	private int quantita;

	public Lotto(Titolo titoloAzione, int quantita)
	{
		this.titoloAzione = titoloAzione;
		this.quantita = quantita;
	}

	@Override
	public String toString()
	{
		return "Titolo azione: " + titoloAzione + ", quantità: " + quantita;
	}

	public double calcolaValore()
	{
		return quantita * titoloAzione.getPrezzo();
	}

	public Titolo getTitoloAzione()
	{
		return titoloAzione;
	}

	public void setTitoloAzione(Titolo titoloAzione)
	{
		this.titoloAzione = titoloAzione;
	}

	public int getQuantita()
	{
		return quantita;
	}

	public void setQuantita(int quantita)
	{
		this.quantita = quantita;
	}
}
