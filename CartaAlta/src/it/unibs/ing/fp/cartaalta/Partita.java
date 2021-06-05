package it.unibs.ing.fp.cartaalta;

/**
 * Classe che rappresenta una partita del gioco. Una partita è caratterizzata dal nome del giocatore,
 * dal credito del giocatore (il denaro) e il mazzo di carte che si usano per giocare.
 * 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
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
	
	/**
	 * Controlla che il credito sia maggiore di zero, altrimenti lancia un'eccezione
	 * @param credito del giocatore da controllare
	 */
	public void checkCredito(int credito)
	{
		if(credito <= 0)
		{
			throw new IllegalArgumentException("Hai inserito un saldo negativo. Il saldo deve essere positivo."); 
		}
	}
	
	/**
	 * Scommette sull'estrazione delle carte e ritorna l'esito della scommessa
	 * @param importoScomessa - l'importo di denaro scommesso (int)
	 * @param utente - viene passata la carta dell'utente
	 * @param computer - viene passata la carta del computer
	 * @return viene ritornato l'esito della scommessa (di tipo Scommessa)
	 */
	public Scommessa scommetti(int importoScomessa, Carta utente, Carta computer)
	{
		int differenza_scommesse = utente.compareTo(computer); 
		Scommessa esisto_scomessa = differenza_scommesse > 0 ? Scommessa.VINTA : (differenza_scommesse < 0 ? Scommessa.PERSA : Scommessa.PAREGGIO); 
		aggiornaCredito(importoScomessa, esisto_scomessa); 
		return esisto_scomessa; 
	}
	
	/**
	 * Aggiorna il credito dopo l'esito della scommessa. 
	 * 
	 * @param importoScomessa - il denaro che era stato scomesso dal giocatore
	 * @param esisto_scommessa - l'esito della scomessa che è stata effettuata. 
	 */
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
	
	/**
	 * Controlla se la partita è terminata o meno. 
	 * 
	 * @return ritorna true se è finita (credito minore o uguale di zero), altrimenti ritorna false. 
	 */
	public boolean isFinita()
	{
		return credito <= 0 ? true : false; 
	}
	
	/**
	 * Estrae una carta casuale e la ritorna. 
	 * 
	 * @return la carta estratta
	 */
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
