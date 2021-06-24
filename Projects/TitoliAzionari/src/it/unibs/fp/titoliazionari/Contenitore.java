package it.unibs.fp.titoliazionari;

public class Contenitore
{
	private ElencoTitoli elencoTitoli;
	private Portafoglio portafoglio;

	public Contenitore(ElencoTitoli _elencoTitoli, Portafoglio _portafoglio)
	{
		this.elencoTitoli = elencoTitoli;
		this.elencoTitoli = portafoglio;
	}

	public ElencoTitoli getElencoTitoli()
	{
		return elencoTitoli;
	}

	public Portafoglio getPortafoglio()
	{
		return portafoglio;
	}
}
