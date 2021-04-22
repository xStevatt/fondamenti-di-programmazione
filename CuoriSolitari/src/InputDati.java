import java.util.Scanner; 

public class InputDati 
{
	static Scanner input_scanner = new Scanner(System.in); 
	
	// METODO PER L'INSERIMENTO DI UNA STRINGA SENZA REQUISITI (qualunque stringa inserita sarà considerata valida). 
	public static String inputString(String messaggio_richiesta)
	{
		String string_input = ""; 
		
		System.out.print(messaggio_richiesta);
		do
		{
			string_input = input_scanner.next().trim(); 
			
			if(string_input.length() == 0)
				System.out.print("Inserimento vuoto! Riprovare: ");
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
			string_input = input_scanner.next().trim(); 
			
			if(string_input.length() == 0)
			{
				System.out.print("Inserimento vuoto! Riprovare: ");

			}
			else
			{
				for(int i = 0; i < string_asset.length; i++)
				{
					if(string_input.equalsIgnoreCase(string_asset[i])) // string_asset[0] = "M" string_asset[1] = "F"
					{
						isValid = !isValid; 
						break; 
					}
				}
				if(isValid)
					return string_input; 
				else
					System.out.print("Inserire una stringa valida! Riprovare: ");
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
		do
		{
			intero = input_scanner.nextInt(); 
			
			if(intero != (int) intero)
				System.out.print("Il numero inserito non è un intero! Riprovare: ");
		}
		while(intero != (int) intero); 
		
		return intero; 
	}
	
	// METODO PER L'INSERIMENTO DI UN INTERO CHE DEVE ESSERE COMPRESO TRA UN PARTICOLARE RANGE
	public static int inputInteger(String messaggio_richiesta, int min, int max) 
	{
		int intero = 0; 
		boolean isValid = false; 
		
		System.out.print(messaggio_richiesta); 
		do
		{
			intero = input_scanner.nextInt(); 
			
			if(intero != (int) intero)
			{
				System.out.print("Il numero inserito non è un intero! Riprovare: ");
			}
			else
			{
				if(intero >= min && intero <= max)
					isValid = true;
			}
		}
		while(intero != (int) intero && !isValid); 
		
		return intero; 
	}	
}
