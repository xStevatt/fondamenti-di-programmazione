package it.unibs.ing.fp.lab.TamaZoo;

import it.unibs.ing.lab.mylib.*;

public class TamaMain 
{
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE = "INPUT - Inserisci il nome del tamatriste -> ";
	private static final String INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE = "INPUT - Inserisci il grado di sazietà iniziale -> ";
	private static final String INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO = "INPUT - Inserisci il nome del tamagordo -> ";
	private static TamaZoo tamazoo;
	
	public static void main(String[] args) 
	{
		tamazoo = new TamaZoo(); 
		mostraMenu();
	}
	
	public static void mostraMenu()
	{
		int numero_tamagotchi = InputDati.inputInteger("INPUT - Inserire il numero di tamagotchi che si vogliono creare -> "); 
		
		creaListaTamagotchi(numero_tamagotchi);
	}
	
	public static void interagisciConTama()
	{
		String[] scelte = {"carezze", "biscotti"}; 
		String scelta = InputDati.inputString("Vuoi dare biscotti o carezze? [Inserire: carezze / biscotti]", scelte); 
		int random_number; 
		
		switch (scelta) 
		{		
		case "carezze":
			random_number = RandomNumbers.getRandomInteger(0, 100); 
			tamazoo.daiCarezze(random_number);
			break; 
		case "biscotti": 
			random_number = RandomNumbers.getRandomInteger(0, 100); 
			tamazoo.daiBiscotti(random_number);
			break; 
		}
	}
	
	public static void creaListaTamagotchi(int numero_tamagotchi) 
	{
		for(int i = 0; i < numero_tamagotchi; i++)
		{
			System.out.println("Creazione tamagotchi " + (i + 1));
			
			String nome_tamagotchi = InputDati.inputString("INPUT - Inserire il nome del tamagotchi che vuoi creare -> "); 
			int type_tamagotchi = RandomNumbers.getRandomInteger(0, 2); 
			Tamagotchi tama = null; 
			
			switch(type_tamagotchi)
			{
			case 1: 
				tama = creaTamaGordo(); 
				tamazoo.aggiungiTama(tama);
				break; 
			case 2: 
				tama = creaTamaTriste(); 
				tamazoo.aggiungiTama(tama);
				break; 
			default: 
				System.out.println("ERRORE - Errore nella selezione.");
			}
			System.out.print("\n");
		}
	}
	
	public static TamaGordo creaTamaGordo()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMAGORDO); 
		int grado_sazietà_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		
		return new TamaGordo(nome, grado_sazietà_iniziale); 
	}
	
	public static TamaTriste creaTamaTriste()
	{
		String nome = InputDati.inputString(INPUT_INSERISCI_IL_NOME_DEL_TAMATRISTE); 
		int grado_sazietà_iniziale = InputDati.inputInteger(INPUT_INSERISCI_IL_GRADO_DI_SAZIETÀ_INIZIALE, 0, 100); 
		
		return new TamaTriste(nome, grado_sazietà_iniziale); 
	}
}
