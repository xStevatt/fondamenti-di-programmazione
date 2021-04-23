package it.unibs.fp.lab.tamagotchi;
import java.util.Scanner; 

/**
 * 
 * @author Stefano Valloncini
 * @author Luigi Amarante
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class InputDati 
{
	private static final String IL_NUMERO_INSERITO_NON_È_UN_INTERO_RIPROVARE = "Il numero inserito non è un intero! Riprovare: ";
	private static final String HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE = "Hai scelto una possibilità non valida! Riprovare: ";
	private static final String INSERIMENTO_VUOTO_RIPROVARE = "Inserimento vuoto! Riprovare: ";
	
	static Scanner input_scanner = new Scanner(System.in); 
	
	/***
	 * 
	 * @param messaggio_richiesta - indica il messaggio che viene mostrato all'utente che dà indicazioni sull'inserimento
	 * @return string_input - la stringa inserita
	 */
	public static String inputString(String messaggio_richiesta)
	{
		String string_input = ""; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.nextLine().trim(); 
			
			if(string_input.length() == 0)
				System.out.print(INSERIMENTO_VUOTO_RIPROVARE);
		}
		while(string_input.length() == 0); 
		
		return string_input; 
	}
	
	/***
	 * 
	 * @param messaggio_richiesta - indica il messaggio che viene mostrato all'utente che dà indicazioni sull'inserimento
	 * @param string_asset - array di stringhe: si verifica che la stringa inserita corrisponda ad uno degli elementi dell'array
	 * @return string_input - la stringa inserita
	 */
	public static String inputString(String messaggio_richiesta, String [] string_asset)
	{
		String string_input = ""; 
		boolean isValid = false; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.nextLine().trim(); 
			
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
						isValid = !isValid; 
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
		
		return string_input; 
	}	
	
	/***
	 * 
	 * @param messaggio_richiesta - indica il messaggio che viene mostrato all'utente che dà indicazioni sull'inserimento
	 * @return intero - ritorna l'intero inserito 
	 */
	public static int inputInteger(String messaggio_richiesta) 
	{
		int intero = 0; 
		System.out.print(messaggio_richiesta); 

		try
		{
			intero = input_scanner.nextInt(); 
		}
		catch (java.util.InputMismatchException e) 
		{
			System.out.println(IL_NUMERO_INSERITO_NON_È_UN_INTERO_RIPROVARE);
		}
		
		return intero; 
	}
	
	/***
	 * 
	 * @param messaggio_richiesta - indica il messaggio che viene mostrato all'utente che dà indicazioni sull'inserimento
	 * @param min - indica il minimo numero ammesso all'input (compreso)
	 * @param max - indica il massimo numero ammesso all'input (compreso)
	 * @return intero - ritorna l'intero inserito in input, dopo aver verificato che esso sia valido
	 */
	public static int inputInteger(String messaggio_richiesta, int min, int max) 
	{
		int intero = 0; 
		boolean isValid = false;
		boolean isSuccessful = false; 
		
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
				System.out.print(IL_NUMERO_INSERITO_NON_È_UN_INTERO_RIPROVARE);
				String stringa_catch = input_scanner.next();
			}
			
			if(isSuccessful)
			{
				if(intero >= min && intero <= max)
					isValid = !isValid;
				else
					System.out.print(HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE);
			}
		}
		while(!isValid && !isSuccessful); 
		
		return intero; 
	}	
}