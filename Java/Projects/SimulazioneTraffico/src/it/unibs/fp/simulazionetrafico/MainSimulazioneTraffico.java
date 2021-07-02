package it.unibs.fp.simulazionetrafico;

import it.unibs.fp.mylib.InputDati;

public class MainSimulazioneTraffico
{
	final private static int NUMERO_RIGHE_STRADA = 5;
	final private static int NUMERO_COLONNE_STRADA = 20;
	final private static String MESSAGGIO_INIZIALIZZAZIONE = "Benvenuto! Ecco la strada inizializzata -> ";
	final private static String DOMANDA_PROSEGUIMENTO = "Vuoi proseguire la simulazione del traffico? -> ";

	public static void main(String[] args)
	{
		Strada strada = new Strada(NUMERO_RIGHE_STRADA, NUMERO_COLONNE_STRADA);

		strada.inizializza();

		System.out.println(MESSAGGIO_INIZIALIZZAZIONE);
		System.out.println(strada);

		while (InputDati.yesOrNo(DOMANDA_PROSEGUIMENTO))
		{
			strada.evoluzione();
			System.out.println(strada);
		}
	}
}
