public class CuoriSolitariMain 
{
	private static final String MESSAGGIO_INIZIALE = "Benvenuto in cuori solitari. Qui puoi trovare una persona a te compatibile."; 
	private static final String MESSAGGIO_INSERIMENTO_NOME = "Inserire il vostro nome: "; 
	private static final String MESSAGGIO_INSERIMENTO_ETA = "Inserire la vostra età: "; 
	private static final String MESSAGGIO_INSERIMENTO_SESSO = "Inserire il vostro genere: "; 
	private static final String MESSAGGIO_INSERIMENTO_SEGNO_ZODIACALE = "Inserire il vostro segno zodiacale: "; 
	private static final String MESSAGGIO_INSERIMENTO_SEGNO_ZODICALE_PREFERITO = "Inserire il vostro segno zodiacale preferito: "; 
	
	private static String MASCHIO = "M"; 
	private static String FEMMINA = "F"; 
	
	private static final int ETA_MINIMA = 18; 
	private static final int ETA_MASSIMA = 120;
	private static final int DIFFERENZA_MASSIMA = 25; 
	
	private static CuoreSolitario utente1 = null; 
	private static CuoreSolitario utente2 = null; 
	private static String [] Segni_Zodiacali = {"Ariete", "Toro", "Gemelli", "Cancro", "Leone", "Vergine", "Bilancia", "Scorpione",
												"Sagittario", "Capricorno", "Acquario", "Pesci"}; 
		
	public static void main(String[] args) 
	{
		System.out.println(MESSAGGIO_INIZIALE);
		utente1 = creaCuoreSolitario(); 
		utente2 = creaCuoreSolitario(); 
		
		System.out.println(utente1.isCompatibile(utente2, DIFFERENZA_MASSIMA) ? utente1.getNome() + " è compatibile con "
				+ utente2.getNome() : "I due utenti non sono compatibili");
		
		InputDati.input_scanner.close(); 
	}
	
	private static CuoreSolitario creaCuoreSolitario()
	{
		String pseudonimo = InputDati.inputString(MESSAGGIO_INSERIMENTO_NOME); 
		String sesso = InputDati.inputString(MESSAGGIO_INSERIMENTO_SESSO); 
		int eta = InputDati.inputInteger(MESSAGGIO_INSERIMENTO_ETA); 
		String segno_zodiacale = InputDati.inputString(MESSAGGIO_INSERIMENTO_SEGNO_ZODIACALE, Segni_Zodiacali); 
		String segno_zodiacale_preferito = InputDati.inputString(MESSAGGIO_INSERIMENTO_SEGNO_ZODICALE_PREFERITO, Segni_Zodiacali); 
		
		CuoreSolitario utente = new CuoreSolitario(pseudonimo, sesso, eta, segno_zodiacale, segno_zodiacale_preferito); 
		
		return utente; 
	}
}
