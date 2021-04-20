import java.util.Random; 

public class TamagotchiMain 
{
	private static final int MIN_BISCOTTI = 1;
	private static final int MIN_CAREZZE = 1;
	private static final int MAX_CAREZZE = 20;
	private static final int MAX_BISCOTTI = 20;
	private static final String INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE = "Inserire il grado di sazietà iniziale: ";
	private static final String INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE = "Inserire il grado di soddisfazione affettiva iniziale: ";
	private static String MESSAGGIO_INIZIALE = "Benvenuto nell'applicazione Tamagotchi. Qui puoi gestire il tuo tamagotchi."; 
	private static String MESSAGGIO_MENU = "0. Esci dal programma\n"
										 + "1. Dai biscotti [1 - 20]\n"	
										 + "2. Dai carezze [1 - 20]\n"; 
	
	public static void main(String[] args) 
	{
		mostraMenu();
	}
	
	public static void mostraMenu()
	{
		int scelta; 
		Tamagotchi tamagotchi = creaTamagotchi(); 
		Random random = new Random(); 
		
		do
		{
			scelta = InputDati.inputInteger(MESSAGGIO_MENU, 0, 2); 
			
			switch(scelta)
			{
				case 1: 
					tamagotchi.daiBiscotto(random.nextInt(MAX_BISCOTTI) + MIN_BISCOTTI);
					break; 
				case 2: 
					tamagotchi.daiCarezze(random.nextInt(MAX_CAREZZE) + MIN_CAREZZE);
					break;
				case 0: 
					System.out.println("Mancherai al tuo tamagotchi!");
			}
			
			if(tamagotchi.isAlive())
			{
				if(tamagotchi.isFelice())
				{
					System.out.println("Tamagotchi è felice");
					System.out.println("Soddisfazione affettiva: " + tamagotchi.getSodd_affettiva());
					System.out.println("Grado Sazietà: " + tamagotchi.getGrado_sazieta());
				}
				else
				{
					System.out.println("Tamagotchi è infelice");
					System.out.println("Soddisfazione affettiva: " + tamagotchi.getSodd_affettiva());
					System.out.println("Grado Sazietà: " + tamagotchi.getGrado_sazieta());
				}
			}
			else
			{
				System.out.println("Tamagotchi è morto. RIP Tama.");
			}
		}
		while(scelta != 0 || !tamagotchi.isAlive()); 
	}
	
	public static Tamagotchi creaTamagotchi()
	{
		int sodd_aff_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SODDISFAZIONE_AFFETTIVA_INIZIALE, 0, 100); 
		int grad_saz_ini = InputDati.inputInteger(INSERIRE_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		
		Tamagotchi tamagotchi = new Tamagotchi(sodd_aff_ini, grad_saz_ini); 

		return tamagotchi; 
	}
}
