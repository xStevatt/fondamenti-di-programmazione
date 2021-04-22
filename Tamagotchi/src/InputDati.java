import java.util.Scanner; 

public class InputDati 
{
	private static final String IL_NUMERO_INSERITO_NON_È_UN_INTERO_RIPROVARE = "Il numero inserito non è un intero! Riprovare: ";
	private static final String HAI_SCELTO_UNA_POSSIBILITÀ_NON_VALIDA_RIPROVARE = "Hai scelto una possibilità non valida! Riprovare: ";
	private static final String INSERIMENTO_VUOTO_RIPROVARE = "Inserimento vuoto! Riprovare: ";
	
	static Scanner input_scanner = new Scanner(System.in); 
	
	// METODO PER L'INSERIMENTO DI UNA STRINGA SENZA REQUISITI (qualunque stringa inserita sarà considerata valida). 
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
	
	// METODO PER L'INSERIMENTO DI UNA STRINGA CON IL REQUISITO DI APPARTENERE AD UN "ASSET" (cioè un insieme di valori possibili).  
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
	
	// METODO PER L'INSERIMENTO DI UN INTERO QUALUNQUE
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
	
	// METODO PER L'INSERIMENTO DI UN INTERO CHE DEVE ESSERE COMPRESO TRA UN PARTICOLARE RANGE
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