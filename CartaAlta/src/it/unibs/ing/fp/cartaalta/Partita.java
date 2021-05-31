package it.unibs.ing.fp.cartaalta;

public class Partita 
{
	private int credito; 
	private String nomeGiocatore; 
	private Mazzo mazzo; 
	
	public Partita(String nomeGiocatore, int credito, TipoMazzo tipo_mazzo)
	{
		checkCredito(credito); 
		this.nomeGiocatore = nomeGiocatore; 
		this.credito = credito; 
		this.mazzo = tipo_mazzo == TipoMazzo.ITALIANO ? new TipoMazzoItaliano() : new TipoMazzoFrancese(); 
	}
	
	public Partita(String nomeGiocatore, int credito)
	{
		checkCredito(credito);
		this.nomeGiocatore = nomeGiocatore; 
		this.credito = credito; 
		this.mazzo = new TipoMazzoItaliano(); 
	}	
	
	public void checkCredito(int credito)
	{
		if(credito <= 0)
		{
			throw new IllegalArgumentException("Hai inserito un saldo negativo. Il saldo deve essere positivo."); 
		}
	}
	
	public Scommessa scommetti(int importoScomessa, Carta utente, Carta computer)
	{
		int differenza_scommesse = utente.compareTo(computer); 
		Scommessa esisto_scomessa = differenza_scommesse > 0 ? Scommessa.VINTA : (differenza_scommesse < 0 ? Scommessa.PERSA : Scommessa.PAREGGIO); 
		aggiornaCredito(importoScomessa, esisto_scomessa); 
		return esisto_scomessa; 
	}
	
	public void aggiornaCredito(int importoScomessa, Scommessa esisto_scommessa)
	{
		switch (esisto_scommessa) 
		{
		case VINTA:
			credito += importoScomessa; 
			break; 
		case PERSA: 
			credito -= importoScomessa; 
			break; 
		case PAREGGIO: 
			break; 
		}
	}
	
	public boolean isFinita()
	{
		return credito <= 0 ? true : false; 
	}
	
	public Carta estraiCarta()
	{
		return this.mazzo.estraiCarta(); 
	}

	public int getCredito() 
	{
		return credito;
	}

	public void setCredito(int credito) 
	{
		this.credito = credito;
	}

	public String getNomeGiocatore() 
	{
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore)
	{
		this.nomeGiocatore = nomeGiocatore;
	}

	public Mazzo getMazzo() 
	{
		return mazzo;
	}

	public void setMazzo(Mazzo mazzo) 
	{
		this.mazzo = mazzo;
	}
}
