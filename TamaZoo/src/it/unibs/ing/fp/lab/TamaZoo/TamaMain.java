package it.unibs.ing.fp.lab.TamaZoo;

import it.unibs.ing.lab.mylib.*;

public class TamaMain 
{
	private static final String VAI_A_CAPO = "\n";
	private static final String INPUT_VUOI_DARE_BISCOTTI_O_CAREZZE_INSERIRE_CAREZZE_BISCOTTI = "INPUT - Vuoi dare biscotti o carezze? [Inserire: carezze / biscotti] -> ";
	private static final String INPUT_INSERIRE_IL_NUMERO_DI_TAMAGOTCHI_CHE_SI_VOGLIONO_CREARE = "INPUT - Inserire il numero di tamagotchi che si vogliono creare -> ";
	private static final String INPUT_INSERISCI_IL_GRADO_DI_SAZIET�_INIZIALE = "INPUT - Inserisci il grado di saziet� iniziale -> ";
	private static final String INPUT_INSERISCI_IL_GRADO_DI_AFFETTIVIT�_INIZIALE = "INPUT - Inserisci il grado di affettivit� iniziale -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMAGOTCHI = "INPUT - Inserisci il nome del tamagotchi -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE = "INPUT - Inserisci il nome del tamatriste -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO = "INPUT - Inserisci il nome del tamagordo -> ";
	
	private static TamaZoo tamazoo;
	
	public static void main(String[] args) 
	{
		tamazoo = new TamaZoo(); 
		mostraMenu();
	}
	
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
	
	public static void mostraStatoTama()
	{
		System.out.println(tamazoo.toString());
	}
	
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
	
	public static Tamagotchi creaTamaBase()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMAGOTCHI); 
		int grado_saziet�_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIET�_INIZIALE, 0, 100); 
		int grado_affettivit�_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_AFFETTIVIT�_INIZIALE, 0, 100);
		
		return new Tamagotchi(nome, grado_affettivit�_iniziale, grado_saziet�_iniziale); 
	}
	
	public static TamaGordo creaTamaGordo()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO); 
		int grado_saziet�_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIET�_INIZIALE, 0, 100); 
		
		return new TamaGordo(nome, grado_saziet�_iniziale); 
	}
	
	public static TamaTriste creaTamaTriste()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE); 
		int grado_saziet�_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIET�_INIZIALE, 0, 100); 
		
		return new TamaTriste(nome, grado_saziet�_iniziale); 
	}
}
