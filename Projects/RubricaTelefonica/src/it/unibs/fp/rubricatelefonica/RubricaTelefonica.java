package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public class RubricaTelefonica
{
	private ArrayList<Soggetto> listaSoggetti;

	public RubricaTelefonica()
	{
		listaSoggetti = new ArrayList<Soggetto>();
	}

	public void aggiungiSoggetto(Soggetto soggetto)
	{
		listaSoggetti.add(soggetto);
	}

	public void eliminaContatto(String nomeSoggetto, String nomeContatto)
	{
		for (int i = 0; i < listaSoggetti.size(); i++)
		{
			if (listaSoggetti.get(i) instanceof Azienda)
			{
				if (nomeSoggetto.equalsIgnoreCase(((Azienda) listaSoggetti.get(i)).getRagioneSociale()))
				{
					for (int j = 0; j < listaSoggetti.get(j).getListaContatti().size(); j++)
					{
						if (listaSoggetti.get(i).getListaContatti().get(j).getNome().equalsIgnoreCase(nomeContatto))
						{
							listaSoggetti.get(i).eliminaContatto(j);
						}
					}
				}
			}
			else
			{
				if (nomeSoggetto.equalsIgnoreCase(((Persona) listaSoggetti.get(i)).getCognome()))
				{
					for (int j = 0; j < listaSoggetti.get(j).getListaContatti().size(); j++)
					{
						if (listaSoggetti.get(i).getListaContatti().get(j).getNome().equalsIgnoreCase(nomeContatto))
						{
							listaSoggetti.get(i).eliminaContatto(j);
						}
					}
				}
			}
		}
	}

	public void ricercaSoggetto(String nomeRicerca, Contatto contatto)
	{
		for (int i = 0; i < listaSoggetti.size(); i++)
		{
			if (listaSoggetti.get(i) instanceof Azienda)
			{
				if (nomeRicerca.equalsIgnoreCase(((Azienda) listaSoggetti.get(i)).getRagioneSociale()))
				{
					listaSoggetti.get(i).aggiungiContatto(contatto);
					System.out.println(listaSoggetti.get(i).toString());
				}
			}
			else
			{
				if (nomeRicerca.equalsIgnoreCase(((Persona) listaSoggetti.get(i)).getCognome()))
				{
					listaSoggetti.get(i).aggiungiContatto(contatto);
					System.out.println(listaSoggetti.get(i).toString());
				}
			}
		}
	}

	public void ricercaContatto(String nomeRicerca)
	{
		for (int i = 0; i < listaSoggetti.size(); i++)
		{
			ArrayList<Contatto> listaContatti = listaSoggetti.get(i).getListaContatti();
			if (nomeRicerca.equalsIgnoreCase(listaContatti.get(i).getNome()))
			{
				System.out.println(listaContatti.get(i).toString());
			}
		}
	}

	public void ricercaSoggetto(String nomeRicerca)
	{
		for (int i = 0; i < listaSoggetti.size(); i++)
		{
			if (listaSoggetti.get(i) instanceof Azienda)
			{
				if (nomeRicerca.equalsIgnoreCase(((Azienda) listaSoggetti.get(i)).getRagioneSociale()))
				{
					System.out.println(((Azienda) listaSoggetti.get(i)).toString());
				}
			}
			else
			{
				if (nomeRicerca.equalsIgnoreCase(((Persona) listaSoggetti.get(i)).getCognome()))
				{
					System.out.println(((Persona) listaSoggetti.get(i)).toString());
				}
			}
		}
	}

	@Override
	public String toString()
	{
		return "\nRubricaTelefonica [listaSoggetti=" + listaSoggetti + "]";
	}
}