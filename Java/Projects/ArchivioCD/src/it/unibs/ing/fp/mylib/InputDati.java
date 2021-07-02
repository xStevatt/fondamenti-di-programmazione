package it.unibs.ing.fp.mylib; 
import java.util.Scanner; 
import java.util.ArrayList;

/**
 * Classe per l'input di dati
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class InputDati 
{
	private static final String FROMATO_NON_CORRETTO = "Il numero inserito non è nel formato richiesto! Riprovare: ";
	private static final String HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE = "Hai scelto una possibilità non valida! Riprovare: ";
	private static final String INSERIMENTO_VUOTO_RIPROVARE = "Inserimento vuoto! Riprovare: ";
	
	static Scanner input_scanner = new Scanner(System.in); 
	
	/**
	 * METODO PER L'INSERIMENTO DI UNA STRINGA SENZA REQUISITI (qualunque stringa inserita sarà considerata valida). 
	 * @param messaggio_richiesta - Messaggio di richiesta dell'input all'utente
	 * @return viene ritornata la stringa inserita in input dall'utente dopo aver verificato che essa non sia vuota
	 */
	public static String inputString(String messaggio_richiesta)
	{
		String string_input = ""; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.next().trim(); 
			
			if(string_input.length() == 0)
				System.out.print(INSERIMENTO_VUOTO_RIPROVARE);
		}
		while(string_input.length() == 0); 
		
		input_scanner.nextLine(); 
		
		return string_input; 
	}
	
	/**
	 * METODO PER L'INSERIMENTO DI UNA STRINGA CON IL REQUISITO DI APPARTENERE AD UN "ASSET" (cioè un insieme di valori possibili). 
	 * @param messaggio_richiesta - Messaggio di richiesta dell'input all'utente
	 * @param string_asset - Array con all'interno gli elementi che possono essere inseriti dall'utente 
	 * @return viene ritornata la stringa inserita in input dall'utente dopo aver verificato che essa non sia vuota e sia presente nell'array
	 */
	public static String inputString(String messaggio_richiesta, String [] string_asset)
	{
		String string_input = ""; 
		boolean isValid = false; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.next().trim(); 
			
			if(string_input.length() == 0)
			{
				System.out.print(INSERIMENTO_VUOTO_RIPROVARE);
			}
			else
			{
				for(int i = 0; i < string_asset.length; i++)
				{
					if(string_input.equalsIgnoreCase(string_asset[i]))
					{
						isValid = true; 
						break; 
					}
				}
				if(isValid)
					return string_input; 
				else
					System.out.print(HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE);
			}
		}
		while(string_input.length() == 0 || !isValid); 
		
		input_scanner.nextLine(); // pulisce la stringa
		
		return string_input; 
	}	
	
	/**
	 * METODO PER L'INSERIMENTO DI UNA STRINGA CON IL REQUISITO DI APPARTENERE AD UN "ASSET" (cioè un insieme di valori possibili). 
	 * @param messaggio_richiesta - Messaggio di richiesta dell'input all'utente
	 * @param string_asset - ArrayList con all'interno gli elementi che possono essere inseriti dall'utente 
	 * @return viene ritornata la stringa inserita in input dall'utente dopo aver verificato che essa non sia vuota e sia presente nell'array
	 */
	public static String inputString(String messaggio_richiesta, ArrayList<String> string_asset)
	{
		String string_input = ""; 
		boolean isValid = false; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.next().trim(); 
			
			if(string_input.length() == 0)
			{
				System.out.print(INSERIMENTO_VUOTO_RIPROVARE);
			}
			else
			{
				for(int i = 0; i < string_asset.size(); i++)
				{
					if(string_input.equalsIgnoreCase(string_asset.get(i)))
					{
						isValid = true; 
						break; 
					}
				}
				if(isValid)
					return string_input; 
				else
					System.out.print(HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE);
			}
		}
		while(string_input.length() == 0 || !isValid); 
		
		input_scanner.nextLine(); // pulisce la stringa
		
		return string_input; 
	}
	
	/**
	 * METODO PER L'INSERIMENTO DI UN INTERO QUALUNQUE
	 * @param messaggio_richiesta - Messaggio di richiesta dell'input all'utente
	 * @return viene ritornato l'intero inserito in input 
	 */
	public static int inputInteger(String messaggio_richiesta) 
	{
		int intero = 0; 
		System.out.print(messaggio_richiesta); 
		boolean isValid = false; 
		
		do
		{
			try
			{
				intero = input_scanner.nextInt(); 
				isValid = true; 
			}
			catch (java.util.InputMismatchException e) 
			{
				System.out.print(FROMATO_NON_CORRETTO);
				String stringa_catch = input_scanner.next();
			}
		}
		while(!isValid); 
		
		input_scanner.nextLine();
		return intero; 
	}
	
	/**
	 * METODO PER L'INSERIMENTO DI UN INTERO CHE DEVE ESSERE COMPRESO TRA UN PARTICOLARE RANGE (min - max) 
	 * @param messaggio_richiesta - Messaggio di richiesta dell'input all'utente
	 * @param min - minimo numero estraibile (compreso)
	 * @param max - massimo numero estraibile (compreso)
	 * @return viene ritornato l'intero inserito in input
	 */
	public static int inputInteger(String messaggio_richiesta, int min, int max) 
	{
		int intero = 0; 
		boolean isValid = false;
		boolean isSuccessful = false; 
		
		if(min > max)
		{
			int temp = max; 
			max = min; 
			min = temp; 
		}
		
		System.out.print(messaggio_richiesta); 
		do
		{
			try 
			{
				intero = input_scanner.nextInt();
				isSuccessful = true; 
			}
			catch (java.util.InputMismatchException e) 
			{
				System.out.print(FROMATO_NON_CORRETTO);
				String stringa_catch = input_scanner.next();
			}
			
			if(isSuccessful)
			{
				if(intero >= min && intero <= max)
				{
					isValid = !isValid;
				}
				else
				{
					System.out.print(HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE);
					String stringa_catch = input_scanner.next();
				}
			}
		}
		while(!isValid && !isSuccessful); 
		
		input_scanner.nextLine();
		return intero; 
	}	
	
	public static double inputDouble(String messaggio_richiesta)
	{
		double input = 0.0; 
		boolean isValid = false; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			try
			{
				input = input_scanner.nextDouble(); 
				isValid = true; 
			}
			catch(java.util.InputMismatchException e)
			{
				System.out.print(FROMATO_NON_CORRETTO);
				String stringa_catch = input_scanner.next();
			}
		}
		while(!isValid); 
		
		return input; 
	}
}