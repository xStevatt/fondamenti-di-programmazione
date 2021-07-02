package it.unibs.fp.simulazionetrafico;

import it.unibs.fp.mylib.BelleStringhe;

public class Strada
{

	final static double PROBABILITA_AUTO = 0.1;
	final static double PROBABILITA_PEDONE = 0.1;

	final static char SEPARATORE = '|';
	final static char CORNICE = '-';
	final static char SPAZIO = ' ';
	final static int LARGHEZZA_CASELLA = 4;

	final static String MESSAGGIO_COLLISIONE = "ATTENZIONE! COLLISIONE IN POSIZIONE:";

	private int numeroRighe;
	private int numeroColonne;
	private Elemento[][] mappa;

	public Strada(int numeroRighe, int numeroColonne)
	{
		this.numeroRighe = numeroRighe;
		this.numeroColonne = numeroColonne;

		mappa = new Elemento[numeroRighe][numeroColonne];
	}

	public void inizializza()
	{
		for (int i = 0; i < mappa.length; i++)
		{
			for (int j = 0; j < mappa[i].length; j++)
			{
				mappa[i][j] = oggettoCasuale();
			}
		}
	}

	public void evoluzione()
	{
		Elemento[][] mappaProssima = mappaVuota(mappa.length, mappa[0].length);

		for (int i = 0; i < mappa.length; ++i)
		{
			for (int j = 0; j < mappa[i].length; ++j)
			{
				Elemento esaminato = mappa[i][j];
				Coordinate prossimaPosizione = esaminato.getProssimaPosizione(i, j);

				if (prossimaPosizione.staDentro(mappa.length, mappa[i].length))
				{
					Elemento altro = mappaProssima[prossimaPosizione.getRiga()][prossimaPosizione.getColonna()];
					if (esaminato.collisioneCon(altro))
					{
						System.out.println(MESSAGGIO_COLLISIONE + prossimaPosizione.toString());
					}
					if (esaminato.prevaleSu(altro))
					{
						posizionaElemento(esaminato, prossimaPosizione, mappaProssima);
					}
				}
			}
		}

		mappa = mappaProssima;
	}

	public void posizionaElemento(Elemento daPiazzare, Coordinate dovePiazzarlo, Elemento[][] nuovaMappa)
	{
		nuovaMappa[dovePiazzarlo.getRiga()][dovePiazzarlo.getColonna()] = daPiazzare;
	}

	private Elemento[][] mappaVuota(int numRighe, int numColonne)
	{
		Elemento[][] nuovaMappa = new Elemento[numRighe][numColonne];
		for (int x = 0; x < nuovaMappa.length; ++x)
		{
			for (int y = 0; y < nuovaMappa[x].length; ++y)
			{
				nuovaMappa[x][y] = new Vuoto();
			}
		}
		return nuovaMappa;
	}

	private Elemento oggettoCasuale()
	{
		double numeroCasualeDouble = Math.random();

		if (numeroCasualeDouble < PROBABILITA_AUTO)
		{
			return new Auto();
		}
		else if (numeroCasualeDouble < (PROBABILITA_AUTO + PROBABILITA_PEDONE))
		{
			return new Pedone();
		}
		else
		{
			return new Vuoto();
		}
	}

	@Override
	public String toString()
	{
		StringBuffer stringDescrizioneMessaggio = new StringBuffer();
		String stringaCornice = BelleStringhe.ripetiChar(CORNICE, LARGHEZZA_CASELLA * (mappa[0].length + 1));
		String stringaRientro = BelleStringhe.ripetiChar(SPAZIO, LARGHEZZA_CASELLA);

		stringDescrizioneMessaggio.append(stringaRientro);

		for (int i = 1; i <= mappa[0].length; i++)
			stringDescrizioneMessaggio.append(BelleStringhe.centrata(Integer.toString(i), LARGHEZZA_CASELLA));

		stringDescrizioneMessaggio.append(BelleStringhe.rigaIsolata(stringaCornice));

		for (int x = 0; x < mappa.length; ++x)
		{
			stringDescrizioneMessaggio.append(BelleStringhe.centrata(Integer.toString(x + 1), LARGHEZZA_CASELLA)); // NUMERO
																													// DI
																													// RIGA

			for (int y = 0; y < mappa[x].length; ++y)
			{
				stringDescrizioneMessaggio.append(BelleStringhe.centrata(mappa[x][y].toString(), LARGHEZZA_CASELLA));
			}

			stringDescrizioneMessaggio.append(BelleStringhe.rigaIsolata(stringaCornice));
		}
		return stringDescrizioneMessaggio.toString();
	}
}
