package it.unibs.fp.lab.mylib;

/**
 * Classe per mostrare a schermo il menu di scelta
 * @author Stefano
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class GenerateMenu 
{
	private static final String SPAZIO_VUOTO_SINGOLO = " ";
	private static final String CORNICE = "------------";
	private static final String VAI_A_CAPO = "\n";
	private static final String MESSAGGIO_INPUT_SCELTA = "Inserisci la scelta che vuoi effettuare: ";
	
	private String titolo; 
	private String scelte[]; 
	
	public GenerateMenu(String titolo, String scelte[])
	{
		this.titolo = titolo; 
		this.scelte = scelte; 
	}
	
	public void mostraMenu()
	{
		String intestazione = CORNICE + SPAZIO_VUOTO_SINGOLO + titolo + SPAZIO_VUOTO_SINGOLO + CORNICE; 
		System.out.println(intestazione);
		stampaScelte(intestazione.length());
		inserisciScelta(); 
	}
	
	public void stampaScelte(int lunghezza_intestazione)
	{
		System.out.println("0 - ESCI DAL PROGRAMMA");
		for(int i = 0; i < scelte.length; i++)
		{
			System.out.println(i + 1 + " - " + scelte[i]);
		}
		
		for(int i = 0; i < lunghezza_intestazione; i++)
		{
			System.out.print("-");; 
		}
		System.out.println(VAI_A_CAPO);
	}
	
	public int inserisciScelta()
	{
		int scelta = -1; 
		
		scelta = InputDati.inputInteger(MESSAGGIO_INPUT_SCELTA, 0, scelte.length); 
		
		return scelta; 
	}
}
