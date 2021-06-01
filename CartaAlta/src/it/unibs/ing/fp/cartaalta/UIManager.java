package it.unibs.ing.fp.cartaalta;

import it.unibs.ing.fp.mylib.InputDati;

public class UIManager 
{
	private static final String CREDITTO_ATTUALE = "Creditto attuale: ";
	private static final String VAI_A_CAPO = "\n";
	private static final String HAI_SCOMMESSO = "Hai scommesso ";
	private static final String COMPUTER_CARTA_CASUALE_ESTRATTA_CARTA_SELEZIONATA = "COMPUTER - Carta casuale estratta! Carta selezionata: ";
	private static final String UTENTE_CARTA_CASUALE_ESTRATTA_CARTA_SELEZIONATA = "UTENTE - Carta casuale estratta! Carta selezionata: ";
	private static final String QUANTI_EURO_€_VUOI_SCOMMETTERE = "Quanti euro € vuoi scommettere? -> ";
	private static final String INSERISCI_IL_TUO_SALDO_INIZIALE = "Inserisci il tuo saldo iniziale -> ";
	private static final String INSERISCI_IL_TUO_NOME_UTENTE = "Inserisci il tuo nome utente -> ";
	private static final String AVVISO_CONFIGURAZIONE_GIOCO = "AVVISO - CONFIGURAZIONE GIOCO";
	private static final String RISPOSTA_NO = "no";
	private static final String RISPOSTA_YES = "yes";
	private static final String GRAZIE_PER_AVER_GIOCATO_A_CARTA_PIÙ_ALTA = "Grazie per aver giocato a carta più alta!";
	private static final String VUOI_CONTINUARE_IL_GIOCO_YES_NO = "Vuoi continuare il gioco? [yes/no] -> ";
	private static final String INSERISCI_IL_TIPO_DI_CARTE_CHE_VUOI_UTILIZZARE_FRANCESI_ITALIANE = "Inserisci il tipo di carte che vuoi utilizzare [francesi/italiane] -> ";
	private static final String MESSAGGIO_BENVENUTO = "BENVENUTO NEL GIOCO CARTA PIU' ALTA!";
	private static final String[] tipi_carte = {"Italiane", "Francesi"}; 
	private static final String[] scelte = {RISPOSTA_YES, RISPOSTA_NO}; 
	
	public void mostraMenu()
	{
		System.out.println(MESSAGGIO_BENVENUTO);
		
		String tipo_carta = InputDati.inputString(INSERISCI_IL_TIPO_DI_CARTE_CHE_VUOI_UTILIZZARE_FRANCESI_ITALIANE, tipi_carte); 
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
			
			vuoi_continuare = InputDati.inputString(VUOI_CONTINUARE_IL_GIOCO_YES_NO, scelte); 
		}
		while(vuoi_continuare.equalsIgnoreCase(RISPOSTA_NO)); 
		
		System.out.println(GRAZIE_PER_AVER_GIOCATO_A_CARTA_PIÙ_ALTA);
	}
	
	public void play(TipoMazzo tipo)
	{
		System.out.println(AVVISO_CONFIGURAZIONE_GIOCO);
		String nome_utente = InputDati.inputString(INSERISCI_IL_TUO_NOME_UTENTE); 
		int soldi_iniziali = InputDati.inputInteger(INSERISCI_IL_TUO_SALDO_INIZIALE, 0); 
		
		System.out.print(VAI_A_CAPO);
		
		Partita partita = new Partita(nome_utente, soldi_iniziali, tipo); 
		
		while(!partita.isFinita())
		{
			Carta cartaUtente = partita.estraiCarta(); 
			System.out.println(UTENTE_CARTA_CASUALE_ESTRATTA_CARTA_SELEZIONATA + cartaUtente.getNome() + " di " + cartaUtente.getSeme());
			
			int scommessa = InputDati.inputInteger(QUANTI_EURO_€_VUOI_SCOMMETTERE, 0, partita.getCredito()); 
			System.out.println(HAI_SCOMMESSO + scommessa + "€.");
			
			Carta cartaComputer = partita.estraiCarta(); 
			System.out.println(COMPUTER_CARTA_CASUALE_ESTRATTA_CARTA_SELEZIONATA + cartaComputer.getNome() + " di " + cartaComputer.getSeme());
			
			System.out.print(VAI_A_CAPO);
			
			Scommessa esito = partita.scommetti(scommessa, cartaUtente, cartaComputer); 
			stampaEsitoScommessa(partita, esito, scommessa);
			stampaStatistiche(partita);
		}
	}
	
	public void stampaEsitoScommessa(Partita partita, Scommessa esito_scommessa, int importoScommessa)
	{
		switch(esito_scommessa)
		{
		case VINTA: 
			System.out.println("AVVISO - Il giocatore " + partita.getNomeGiocatore() + " ha vinto!");
			break; 
		case PERSA: 
			System.out.println("AVVISO - Il giocatore " + partita.getNomeGiocatore() + " ha perso!");
			break; 
		case PAREGGIO:
			System.out.println("AVVISO - Il giocatore " + partita.getNomeGiocatore() + " e il computer hanno pareggiato!");
			break; 
		}
	}
	
	public void stampaStatistiche(Partita partita)
	{
		System.out.print(VAI_A_CAPO);
		System.out.println(CREDITTO_ATTUALE + partita.getCredito());
	}
}
