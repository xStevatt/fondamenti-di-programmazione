package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public class Azienda extends Soggetto
{
	private String ragioneSociale;
	private String descrizione;

	public Azienda(ArrayList<Contatto> listaContatti, String ragioneSociale, String descrizione)
	{
		super(listaContatti);
		this.ragioneSociale = ragioneSociale;
		this.descrizione = descrizione;
	}

	@Override
	public String toString()
	{
		return "Azienda [ragioneSociale=" + ragioneSociale + ", descrizione=" + descrizione + ", toString()="
				+ super.toString() + "]";
	}

	public String getRagioneSociale()
	{
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale)
	{
		this.ragioneSociale = ragioneSociale;
	}

	public String getDescrizione()
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}
}
