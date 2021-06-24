package it.unibs.fp.esame.mylib; 

/**
 * Classe per mostrare a schermo il menu di scelta
 * @author Stefano
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class MyMenu 
{
	private static final String ESCI_DAL_PROGRAMMA = "0 - ESCI DAL PROGRAMMA";
	private static final String SPAZIO_VUOTO_SINGOLO = " ";
	private static final String CORNICE = "------------";
	private static final String VAI_A_CAPO = "\n";
	private static final String MESSAGGIO_INPUT_SCELTA = "Inserisci la scelta che vuoi effettuare: ";
	
	private String titolo; 
	private String scelte[]; 
	
	public MyMenu(String titolo, String scelte[])
	{
		this.titolo = titolo; 
		this.scelte = scelte; 
	}
	
	public int mostraMenu()
	{
		String intestazione = CORNICE + SPAZIO_VUOTO_SINGOLO + titolo + SPAZIO_VUOTO_SINGOLO + CORNICE; 
		System.out.println(intestazione);
		stampaScelte(intestazione.length());
		return inserisciScelta(); 
	}
	
	public void stampaScelte(int lunghezza_intestazione)
	{
		System.out.println(ESCI_DAL_PROGRAMMA);
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
