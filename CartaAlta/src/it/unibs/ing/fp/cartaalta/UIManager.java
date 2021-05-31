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
		
		Partita partita = new Partita(nome_utente, soldi_iniziali, tipo); 
		boolean continua_partita = true; 
		
		while(continua_partita)
		{
			Carta cartaUtente = partita.estraiCarta(); 
			System.out.println("UTENTE - Carta casuale estratta! Carta selezionata: " + cartaUtente.getValore() + " di " + cartaUtente.getSeme());
			
			int scommessa = InputDati.inputInteger("Quanti euro € vuoi scommettere? -> ", 0, partita.getCredito()); 
			System.out.println("Hai scommesso " + scommessa + "€.");
			
			Carta cartaComputer = partita.estraiCarta(); 
			System.out.println("COMPUTER - Carta casuale estratta! Carta selezionata: " + cartaUtente.getValore() + " di " + cartaUtente.getSeme());
			
			if(cartaComputer.getValore() > cartaComputer.getValore())
			{
				System.out.println("Il computer vince. Riprova!");
			}
			else if(cartaComputer.getValore() < cartaComputer.getValore())
			{
				System.out.println("L'utente vince. Congratualazioni!");
			}
			else
			{
				System.out.println("Pareggio. Nessuno dei due vince.");
			}
		}
	}
	
	public void stampaStatistiche(Partita partita)
	{
		System.out.print("\n");
		System.out.println("Creditto attuale: " + partita.getCredito());
	}
}
