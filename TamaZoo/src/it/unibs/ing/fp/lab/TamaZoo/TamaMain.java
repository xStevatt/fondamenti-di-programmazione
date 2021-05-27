package it.unibs.ing.fp.lab.TamaZoo;

import it.unibs.ing.lab.mylib.*;

/**
 * TamaMain - Classe Main
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class TamaMain 
{
	private static final String VAI_A_CAPO = "\n";
	private static final String INPUT_VUOI_DARE_BISCOTTI_O_CAREZZE_INSERIRE_CAREZZE_BISCOTTI = "INPUT - Vuoi dare biscotti o carezze? [Inserire: carezze / biscotti] -> ";
	private static final String INPUT_INSERIRE_IL_NUMERO_DI_TAMAGOTCHI_CHE_SI_VOGLIONO_CREARE = "INPUT - Inserire il numero di tamagotchi che si vogliono creare -> ";
	private static final String INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE = "INPUT - Inserisci il grado di sazietà iniziale -> ";
	private static final String INPUT_INSERISCI_IL_GRADO_DI_AFFETTIVITÀ_INIZIALE = "INPUT - Inserisci il grado di affettività iniziale -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMAGOTCHI = "INPUT - Inserisci il nome del tamagotchi -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE = "INPUT - Inserisci il nome del tamatriste -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO = "INPUT - Inserisci il nome del tamagordo -> ";
	
	private static TamaZoo tamazoo;
	
	public static void main(String[] args) 
	{
		tamazoo = new TamaZoo(); 
		mostraMenu();
	}
	
	/**
	 * Metodo per mostrare a schermo il menù delle opzioni
	 */
	public static void mostraMenu()
	{
		int numero_tamagotchi = InputDati.inputInteger(INPUT_INSERIRE_IL_NUMERO_DI_TAMAGOTCHI_CHE_SI_VOGLIONO_CREARE, 1); 
		System.out.print(VAI_A_CAPO);
		creaListaTamagotchi(numero_tamagotchi);
		
		while(!tamazoo.areAllTamaDead())
		{
			interagisciConTama();
			System.out.println(VAI_A_CAPO);
			mostraStatoTama();
		}
		System.out.println("AVVISO - TUTTI I TAMAGOTCHI SONO MORTI");
	}
	
	/**
	 * Metodo per stampare a console lo stato di tutti i tamagotchi
	 */
	public static void mostraStatoTama()
	{
		System.out.println(tamazoo.toString());
	}
	
	/**
	 * Metodo per interagire (dare biscotti o carezze) al tamagotchi
	 */
	public static void interagisciConTama()
	{
		String[] scelte = {"carezze", "biscotti"}; 
		String scelta = InputDati.inputString(INPUT_VUOI_DARE_BISCOTTI_O_CAREZZE_INSERIRE_CAREZZE_BISCOTTI, scelte); 
		int random_number; 
		
		switch (scelta) 
		{		
		case "carezze":
			random_number = RandomNumbers.getRandomInteger(0, 20); 
			System.out.println("MESSAGGIO - Fornisco " + random_number + " " + scelta + " al tamagotchi.");
			tamazoo.daiCarezze(random_number);
			break; 
		case "biscotti": 
			random_number = RandomNumbers.getRandomInteger(0, 20); 
			System.out.println("MESSAGGIO - Fornisco " + random_number + " " + scelta + " al tamagotchi.");
			tamazoo.daiBiscotti(random_number);
			break; 
		}
	}
	
	/**
	 * Metodo per creare la lista iniziale di tamagotchi. Il numero di tamagotchi da creare viene passato come parametro
	 * @param numero_tamagotchi - il numero di tamagotchi che devono essere creati
	 */
	public static void creaListaTamagotchi(int numero_tamagotchi) 
	{
		for(int i = 0; i < numero_tamagotchi; i++)
		{
			System.out.println("Creazione tamagotchi " + (i + 1));
			
			int type_tamagotchi = RandomNumbers.getRandomInteger(0, 2); 
			Tamagotchi tama = null; 
			
			switch(type_tamagotchi)
			{
			case 0: 
				tama = creaTamaBase(); 
				tamazoo.aggiungiTama(tama); 
				break; 			
			case 1: 
				tama = creaTamaGordo(); 
				tamazoo.aggiungiTama(tama);
				break; 
			case 2: 
				tama = creaTamaTriste(); 
				tamazoo.aggiungiTama(tama);
				break; 
			}
			
			System.out.print(VAI_A_CAPO);
		}
	}
	
	/**
	 * Metodo per la creazione di un tamagotchi. I dati richiesti vengono chiesti in input
	 * @return Tamagotchi - viene ritornato un oggetto di tipo tamagotchi creato con dati richiesti in input
	 */
	public static Tamagotchi creaTamaBase()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMAGOTCHI); 
		int grado_sazietà_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		int grado_affettività_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_AFFETTIVITÀ_INIZIALE, 0, 100);
		
		return new Tamagotchi(nome, grado_affettività_iniziale, grado_sazietà_iniziale); 
	}
	
	/**
	 * Metodo per la creazione di un oggetto di tipo TamaGordo.
	 * @return TamaGordo - L'oggetto creato viene ritornato dal metodo
	 */
	public static TamaGordo creaTamaGordo()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO); 
		int grado_sazietà_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		
		return new TamaGordo(nome, grado_sazietà_iniziale); 
	}
	
	/**
	 * Metodo per la creazione di un oggetto di tipo TamaTriste.
	 * @return TamaGordo - L'oggetto creato viene ritornato 
	 */
	public static TamaTriste creaTamaTriste()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE); 
		int grado_sazietà_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		
		return new TamaTriste(nome, grado_sazietà_iniziale); 
	}
}
