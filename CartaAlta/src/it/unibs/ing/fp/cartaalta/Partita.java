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
