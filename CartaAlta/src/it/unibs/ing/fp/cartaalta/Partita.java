package it.unibs.ing.fp.cartaalta;

public class Partita 
{
	private int credito; 
	private String nomeGiocatore; 
	private Mazzo mazzo; 
	
	public Partita(String nomeGiocatore, int credito, TipoMazzo tipo)
	{
		this.nomeGiocatore = nomeGiocatore; 
		this.credito = credito; 
		
	}
}
