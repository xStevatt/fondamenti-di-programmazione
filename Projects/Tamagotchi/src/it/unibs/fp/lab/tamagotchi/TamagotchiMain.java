package it.unibs.fp.lab.tamagotchi;

import java.util.Random;

/**
 * 
 * @author Stefano Valloncini - Leader
 * @author Luigi Amarante
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class TamagotchiMain 
{
	// COSTANTI STRINGHE PER LE RICHIESTE IN INPUT
	private static final String VUOI_LA_MEDIA_PESATA_SI_NO = "Vuoi la media pesata? [SI/NO]: ";
	private static final String INSERISCI_PESO_GRADO_SAZIETÀ = "Inserisci peso grado sazietà: ";
	private static final String INSERISCI_PESO_SODDISFAZIONE_AFFETTIVA = "Inserisci peso soddisfazione affettiva: ";
	private static final String INSERISCI_IL_NOME_DEL_TAMAGOTCHI = "Inserisci il nome del tamagotchi: ";
	private static final String INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE = "Inserire il grado di sazietà iniziale: ";
	private static final String INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE = "Inserire il grado di soddisfazione affettiva iniziale: ";

	// COSTANTI STRINGHE PER VISUALIZZARE INFORMAZIONI
	private static final String VISUALIZZA_GRADO_DI_BENESSERE = "Grado di benessere: ";
	private static final String VISUALIZZA_CAUSA_DELLA_MORTE = "Causa della morte: ";
	private static final String TAMAGOTCHI_È_VERAMENTE_IN_FORMA = "Tamagotchi è veramente in forma";
	private static final String TAMAGOTCHI_È_SANO = "Tamagotchi è sano";
	private static final String TAMAGOTCHI_NON_SI_REGGE_IN_PIEDI = "Tamagotchi non si regge in piedi";
	
	// COSTANTI STRINGHE MESSAGGI E INFORMAZIONI
	private static final String TAMAGOTCHI_MORTE = " è morto. RIP Tamagotchi.";
	private static final String TAMAGOTCHI_È_INFELICE = "Tamagotchi è infelice";
	private static final String GRADO_SAZIETÀ = "Grado Sazietà: ";
	private static final String SODDISFAZIONE_AFFETTIVA = "Soddisfazione affettiva: ";
	private static final String TAMAGOTCHI_È_FELICE = "Tamagotchi è felice";
	private static String MESSAGGIO_INIZIALE = "Benvenuto nell'applicazione Tamagotchi. Qui puoi gestire il tuo tamagotchi.";
	private static String MESSAGGIO_MENU = "0. Esci dal programma\n" + "1. Dai biscotti\n" + "2. Dai carezze\n"
			+ "La tua scelta: ";
	
	// COSTANTI STRINGHE FORMATTAZIONE
	private static final String VAI_A_CAPO = "\n";
	private static final String CORNICE = "-------------------------";
	
	// COSTANTI INTERE PER VALORI DI CONFRONTO
	private static final int GRADO_SAZIETA_MASSIMO_INIZIALE = 100;
	private static final int GRADO_SAZIETA_MINIMO_INIZIALE = 0;
	private static final int SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE = 100;
	private static final int SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE = 0;

	// COSTANTI INTERE PER VALORI DI CONFRONTO
	private static final int MIN_BISCOTTI = 1;
	private static final int MIN_CAREZZE = 1;
	private static final int MAX_CAREZZE = 20;
	private static final int MAX_BISCOTTI = 20;
	private static final int LIMITE_TROPPE_CAREZZE = 20;
	private static final int LIMITE_TROPPI_BISCOTTI = 20;
	private static final int MENO_EFFETTO_BISCOTTI = 1;
	private static final int MENO_EFFETTO_CAREZZE = 1;
	private static final int GRADO_BENESSERE_ALTO = 60;
	private static final int GRADO_BENESSERE_MINIMO = 40;

	// COSTANTI INTERE PER MENU
	private static final int CHIUDI_PROGRAMMA = 0;
	private static final int DAI_BISCOTTI = 1;
	private static final int DAI_CAREZZE = 2;

	public static void main(String[] args) 
	{
		mostraMenu();
	}

	/**
	 * il metodo mostraMenu() si occupa di gestire il menu che viene mostrato a schermo. 
	 * Da esso è possibile intraprendere le funzioni principali, come dare biscotti e 
	 * carezze al tamagotchi. 
	 */
	public static void mostraMenu() 
	{
		Tamagotchi tamagotchi = creaTamagotchi();
		stampaBenessere(tamagotchi);
		stampaStatoTama(tamagotchi);

		Random random = new Random();
		int count_carezze = 0;
		int count_biscotti = 0;

		int scelta = -1;

		while (scelta != 0 && tamagotchi.isAlive()) 
		{
			scelta = InputDati.inputInteger(MESSAGGIO_MENU, 0, 2); 
																		
			switch (scelta) 
			{
				case DAI_BISCOTTI:
					count_carezze = 0;
					int biscotti_dati = random.nextInt(MAX_BISCOTTI) + MIN_BISCOTTI;
					count_biscotti += biscotti_dati;
					
					if (count_biscotti < LIMITE_TROPPI_BISCOTTI) 
					{
						tamagotchi.riceviBiscotti(biscotti_dati);
					} 
					else 
					{
						tamagotchi.riceviBiscotti(MENO_EFFETTO_BISCOTTI);
					}
					
					System.out.println("Hai dato " + biscotti_dati + " biscotti a " + tamagotchi.getNome());
					System.out.println(VAI_A_CAPO);
					break;
					
				case DAI_CAREZZE:
					count_biscotti = 0;
					int carezze_date = random.nextInt(MAX_CAREZZE) + MIN_CAREZZE;
					count_carezze += carezze_date;
	
					if (count_carezze < LIMITE_TROPPE_CAREZZE) 
					{
						tamagotchi.riceviCarezze(carezze_date);
					} 
					else 
					{
						tamagotchi.riceviCarezze(MENO_EFFETTO_CAREZZE);
					}
					
					System.out.println("Hai dato " + carezze_date + " carezze a " + tamagotchi.getNome());
					System.out.println(VAI_A_CAPO);
					break;
					
				case CHIUDI_PROGRAMMA:
					System.out.println("Mancherai a " + tamagotchi.getNome() + "!");
			}
	
			if (scelta != 0) 
			{
				stampaBenessere(tamagotchi);
				stampaStatoTama(tamagotchi);
			}
		}
	}

	/**
	 * Il metodo creaTamagotchi si occupa di richiedere in input tutti i valori necessari alla creazione del tamagotchi
	 * Inoltre, si occupa di chidere all'utente se vuole utilizzare la media pesata o meno. In caso di risposta positiva
	 * dell'utente, allora verranno richiesti i due relativi pesi. 
	 * @return Tamagotchi - ritorna un oggetto di tipo tamagotchi, che è il tamagotchi che è stato creato tramite i valori
	 * richiesti in input
	 * 
	 */
	public static Tamagotchi creaTamagotchi() 
	{
		String nome = InputDati.inputString(INSERISCI_IL_NOME_DEL_TAMAGOTCHI);
		int sodd_aff_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE,
				SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE, SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE);
		int grad_saz_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE, GRADO_SAZIETA_MINIMO_INIZIALE,
				GRADO_SAZIETA_MASSIMO_INIZIALE);

		String scelta = null;
		String[] strings_array = { "SI", "NO" };
		Tamagotchi tamagotchi = null;

		scelta = InputDati.inputString(VUOI_LA_MEDIA_PESATA_SI_NO, strings_array);

		switch (scelta.toUpperCase()) 
		{
			case "SI":
				int peso1 = InputDati.inputInteger(INSERISCI_PESO_SODDISFAZIONE_AFFETTIVA);
				int peso2 = InputDati.inputInteger(INSERISCI_PESO_GRADO_SAZIETÀ);
				tamagotchi = new Tamagotchi(nome, sodd_aff_ini, grad_saz_ini, peso1, peso2);
				break;
			case "NO":
				tamagotchi = new Tamagotchi(nome, sodd_aff_ini, grad_saz_ini);
				break;
		}

		return tamagotchi;
	}

	/**
	 * Il metodo stampaBenessere si occupa di verificare se il tamagotchi è vivo e verificare se è felice o meno
	 * In modo particolare si occupa della SODDISFAZIONE AFFETTIVA e GRADO SAZIETA'. In base ai valori assunti, dalle
	 * due variabili, stabilisce se tama è felice o meno. 
	 * @param tamagotchi - viene passato il tamagotchi di cui stampare le informazioni e fare le eventuali verifiche
	 */
	public static void stampaBenessere(Tamagotchi tamagotchi) 
	{
		System.out.println(CORNICE);
		if (tamagotchi.isAlive() == false) 
		{
			System.out.println(tamagotchi.getNome() + TAMAGOTCHI_MORTE);
			System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
			System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
			System.out.println(VISUALIZZA_CAUSA_DELLA_MORTE + tamagotchi.determinaCausaMorte());
		}

		else if (tamagotchi.isFelice()) 
		{
			System.out.println(TAMAGOTCHI_È_FELICE);
			System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
			System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
		} 
		else 
		{
			System.out.println(TAMAGOTCHI_È_INFELICE);
			System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
			System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
		}
	}

	/**
	 * Il metodo stampaStatoTama() si occupa di stampare a schermo le informazioni riguardanti lo stato del tamagotchi
	 * In modo particolare si occupa del GRADO DI BENESSERE 
	 * @param tamagotchi - viene passato il tamagotchi di cui stampare le informazioni e fare le eventuali verifiche
	 */
	public static void stampaStatoTama(Tamagotchi tamagotchi) 
	{
		if (tamagotchi.isAlive()) 
		{
			tamagotchi.trovaBenessere();
			
			if (tamagotchi.getGrado_benessere() < GRADO_BENESSERE_MINIMO) 
			{
				System.out.println(TAMAGOTCHI_NON_SI_REGGE_IN_PIEDI);
			}
			if (tamagotchi.getGrado_benessere() >= GRADO_BENESSERE_MINIMO 
					&& tamagotchi.getGrado_benessere() <= GRADO_BENESSERE_ALTO) 
			{
				System.out.println(TAMAGOTCHI_È_SANO);
			} 
			else if (tamagotchi.getGrado_benessere() > GRADO_BENESSERE_ALTO) 
			{
				System.out.println(TAMAGOTCHI_È_VERAMENTE_IN_FORMA);
			}
			
			System.out.println(VISUALIZZA_GRADO_DI_BENESSERE + tamagotchi.getGrado_benessere());
		}
	}
}
