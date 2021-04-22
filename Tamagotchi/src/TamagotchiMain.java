import java.util.Random; 

public class TamagotchiMain 
{
	private static final String VAI_A_CAPO = "\n";
	private static final String INSERISCI_IL_NOME_DEL_TAMAGOTCHI = "Inserisci il nome del tamagotchi: ";
	private static final String TAMAGOTCHI_MORTE = " è morto. RIP Tamagotchi.";
	private static final String TAMAGOTCHI_È_INFELICE = "Tamagotchi è infelice";
	private static final String GRADO_SAZIETÀ = "Grado Sazietà: ";
	private static final String SODDISFAZIONE_AFFETTIVA = "Soddisfazione affettiva: ";
	private static final String TAMAGOTCHI_È_FELICE = "Tamagotchi è felice";
	private static final String INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE = "Inserire il grado di sazietà iniziale: ";
	private static final String INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE = "Inserire il grado di soddisfazione affettiva iniziale: ";
	private static String MESSAGGIO_INIZIALE = "Benvenuto nell'applicazione Tamagotchi. Qui puoi gestire il tuo tamagotchi."; 
	private static String MESSAGGIO_MENU = "0. Esci dal programma\n"
										 + "1. Dai biscotti\n"	
										 + "2. Dai carezze\n"
										 + "La tua scelta: "; 
	
	private static final int GRADO_SAZIETA_MASSIMO_INIZIALE = 100;
	private static final int GRADO_SAZIETA_MINIMO_INIZIALE = 0;
	private static final int SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE = 100;
	private static final int SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE = 0;
	
	private static final int MIN_BISCOTTI = 1;
	private static final int MIN_CAREZZE = 1;
	private static final int MAX_CAREZZE = 20;
	private static final int MAX_BISCOTTI = 20;
	
	private static final int CHIUDI_PROGRAMMA = 0; 
	private static final int DAI_BISCOTTI = 1; 
	private static final int DAI_CAREZZE = 2;
	

	public static void main(String[] args) 
	{
		mostraMenu();
	}
	
	public static void mostraMenu()
	{
		int scelta = -1; 
		Tamagotchi tamagotchi = creaTamagotchi(); 
		Random random = new Random(); 
		
		while(scelta != 0 && tamagotchi.isAlive())
		{
			scelta = InputDati.inputInteger(MESSAGGIO_MENU, 0, 2); // 0 -> scelta minima possibile | 2 -> scelta massima possibile
			
			switch(scelta)
			{
				case DAI_BISCOTTI: 
					int biscotti_dati = random.nextInt(MAX_BISCOTTI) + MIN_BISCOTTI; 
					tamagotchi.daiBiscotto(biscotti_dati);
					System.out.println("Hai dato " + biscotti_dati + " biscotti a " + tamagotchi.getNome());
					System.out.println(VAI_A_CAPO); 
					break; 
				case DAI_CAREZZE: 
					int carezze_date = random.nextInt(MAX_CAREZZE) + MIN_CAREZZE; 
					tamagotchi.daiCarezze(carezze_date);
					System.out.println("Hai dato " + carezze_date + " carezze a " + tamagotchi.getNome());
					System.out.println(VAI_A_CAPO); 
					break; 
				case CHIUDI_PROGRAMMA: 
					System.out.println("Mancherai a " + tamagotchi.getNome() + "!");
			}
			
			if(tamagotchi.isAlive() && scelta != 0)
			{
				if(tamagotchi.isFelice())
				{
					System.out.println(TAMAGOTCHI_È_FELICE);
					System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
					System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
					System.out.println(VAI_A_CAPO); 
				}
				else
				{
					System.out.println(TAMAGOTCHI_È_INFELICE);
					System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
					System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
					System.out.println(VAI_A_CAPO); 
				}
			}
		}
		if(!tamagotchi.isAlive() && scelta != 0)
		{
			System.out.println(tamagotchi.getNome() + TAMAGOTCHI_MORTE);
			System.out.println(SODDISFAZIONE_AFFETTIVA + tamagotchi.getSodd_affettiva());
			System.out.println(GRADO_SAZIETÀ + tamagotchi.getGrado_sazieta());
			System.out.println("Causa della morte: " + tamagotchi.determinaCausaMorte());
		}
	}
	
	public static Tamagotchi creaTamagotchi()
	{
		String nome = InputDati.inputString(INSERISCI_IL_NOME_DEL_TAMAGOTCHI); 
		int sodd_aff_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE, SODDISFAZIONE_AFFETTIVA_MINIMA_INIZIALE, SODDISFAZIONE_AFFETTIVA_MASSIMA_INIZIALE); 
		int grad_saz_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE, GRADO_SAZIETA_MINIMO_INIZIALE, GRADO_SAZIETA_MASSIMO_INIZIALE); 
		
		Tamagotchi tamagotchi = new Tamagotchi(sodd_aff_ini, grad_saz_ini, nome);
		// Controlla che il tamagotchi sia vivo, infatti l'utente potrebbe avere inserito dati iniziali che causano la morte del tamagotchi
		tamagotchi.isTamaAlive(); 
		
		return tamagotchi; 
	}
}
