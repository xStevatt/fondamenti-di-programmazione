package it.unibs.fp.magazzino;

/**
 * Classe che rappresenta un articolo, composto da un nome, da una quantità
 * minima, da una quantità massima, da una quantità effettivamente disponibile,
 * e da un tempo di produzione
 * 
 * @author Stefano Valloncini - Mat. 731270
 *
 */
public class Articolo
{
	private static final String A_CAPO = "\n";
	private static final String TEMPO_PRODUZIONE = "Tempo produzione: ";
	private static final String QUANTITÀ_MASSIMA = "Quantità massima: ";
	private static final String QUANTITÀ_MINIMA = "Quantità minima: ";
	private static final String QUANTITÀ_DISPONIBILE = "Quantità disponibile: ";
	private static final String ARTICOLO = "Articolo: ";

	private String nomeArticolo;
	private int qtaMinima;
	private int qtaMassima;
	private int qtaDisponibile;
	private int tempoProduzione;

	public Articolo(String nomeArticolo, int qtaMinima, int qtaMassima, int qtaDisponibile, int tempoProduzione)
	{
		this.nomeArticolo = nomeArticolo;
		this.qtaMinima = qtaMinima;
		this.qtaMassima = qtaMassima;
		this.qtaDisponibile = qtaDisponibile;
		this.tempoProduzione = tempoProduzione;
	}

	@Override
	public String toString()
	{
		StringBuffer messaggioString = new StringBuffer("");
		messaggioString.append(ARTICOLO + getNomeArticolo() + A_CAPO);
		messaggioString.append(QUANTITÀ_DISPONIBILE + getQtaDisponibile() + A_CAPO);
		messaggioString.append(QUANTITÀ_MINIMA + getQtaMinima() + A_CAPO);
		messaggioString.append(QUANTITÀ_MASSIMA + getQtaMassima() + A_CAPO);
		messaggioString.append(TEMPO_PRODUZIONE + getTempoProduzione() + A_CAPO);

		return messaggioString.toString();
	}

	public String getNomeArticolo()
	{
		return nomeArticolo;
	}

	public void setNomeArticolo(String nomeArticolo)
	{
		this.nomeArticolo = nomeArticolo;
	}

	public int getQtaMinima()
	{
		return qtaMinima;
	}

	public void setQtaMinima(int qtaMinima)
	{
		this.qtaMinima = qtaMinima;
	}

	public int getQtaMassima()
	{
		return qtaMassima;
	}

	public void setQtaMassima(int qtaMassima)
	{
		this.qtaMassima = qtaMassima;
	}

	public int getQtaDisponibile()
	{
		return qtaDisponibile;
	}

	public void setQtaDisponibile(int qtaDisponibile)
	{
		this.qtaDisponibile = qtaDisponibile;
	}

	public int getTempoProduzione()
	{
		return tempoProduzione;
	}

	public void setTempoProduzione(int tempoProduzione)
	{
		this.tempoProduzione = tempoProduzione;
	}
}
