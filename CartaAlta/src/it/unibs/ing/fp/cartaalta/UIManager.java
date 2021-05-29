package it.unibs.ing.fp.cartaalta;

import it.unibs.ing.fp.mylib.InputDati;

public class UIManager 
{
	private static final String[] tipi_carte = {"Italiane", "Francesi"}; 
	private static final String[] scelte = {"yes", "no"}; 
	
	public void mostraMenu()
	{
		System.out.println("BENVENUTO NEL GIOCO CARTA PIU' ALTA!");
		
		String tipo_carta = InputDati.inputString("Inserisci il tipo di carte che vuoi utilizzare [francesi/italiane] -> ", tipi_carte); 
		String vuoi_continuare = null; 
		
		do
		{
			switch (tipo_carta.toLowerCase()) 
			{
				case "italiane": 
					play(TipoMazzo.ITALIANO); 
					break;
				case "francesi": 
					play(TipoMazzo.FRANCESE); 
					break; 
			}
			
			vuoi_continuare = InputDati.inputString("Vuoi continuare il gioco? [yes/no] -> ", scelte); 
		}
		while(vuoi_continuare.equalsIgnoreCase("no")); 
	}
	
	public void play(TipoMazzo tipo)
	{
		System.out.println("AVVISO - CONFIGURAZIONE GIOCO");
		String nome_utente = InputDati.inputString("Inserisci il tuo nome utente -> "); 
		int soldi_iniziali = InputDati.inputInteger("Inserisci il tuo saldo iniziale -> ", 0); 
	}
}
