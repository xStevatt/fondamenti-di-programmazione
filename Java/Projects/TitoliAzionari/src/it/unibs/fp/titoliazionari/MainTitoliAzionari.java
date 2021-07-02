package it.unibs.fp.titoliazionari;

import java.io.File;

public class MainTitoliAzionari
{
	File fTitoli = new File(NOMEFILETITOLI);

	Portafoglio patrimonio = null;

	ElencoTitoli listaTitoli = null;

	Contenitore container = null;

	boolean caricamentoRiuscito = false;

	if(fTitoli.exists())
	{
		try
		{
			container = (Contenitore) ServizioFile.caricaSingoloOggetto(fTitoli);
			listaTitoli = container.getElencoTitoli();
			patrimonio = container.getPortafoglio();
		}
		catch (ClassCastException e)
		{
			System.out.println(MSG_NO_CAST);
		}
		finally
		{
			if ((patrimonio != null) && (listaTitoli != null))
			{
				System.out.println(MSG_OK_FILE);
				caricamentoRiuscito = true;
			}
		}

	}

	if(!caricamentoRiuscito)
	{
		System.out.println(MSG_NO_FILE);
		listaTitoli = UtilitaTitoli.creaElencoTitoli();
		patrimonio = UtilitaTitoli.creaPatrimonio(listaTitoli);
	}

	System.out.println(MSG_INTRO_PORTFOLIO);System.out.println(patrimonio);

	int giorni = 0;while(InputDati.yesOrNo(MSG_PROCEDI))
	{
		giorni++;
		listaTitoli.simulaVariazione();
		System.out.println(String.format(MSG_INTRO_GIORNO, giorni));
		System.out.println(patrimonio);
	}

	System.out.println(MSG_SALVA);container=new Contenitore(listaTitoli,patrimonio);ServizioFile.salvaSingoloOggetto(fTitoli,container);

	System.out.println(MSG_SALUTO);
}
