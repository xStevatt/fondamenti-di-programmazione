package it.unibs.fp.tamabase;


import java.util.Random;

import it.unibs.fp.mylib.InputDati;

public class TBMain {

	private static final String SALUTO = "Benvenuto in Tamagotchi";

	
		public static void main(String[] args) 
		{
			menu();
		}
			
		public static void menu()
		{
			int scelta;
			salutare();
			Tamagotchi tama1 = creaTama();
			Random random = new Random(); 
			
			do
			{
				scelta = InputDati.leggiIntero("0. Esci dal programma\n"
											 + "1. Dai carezze\n"
											 + "2. Dai biscotto\n"
											 + "Inserimento scelta: "); 
				
				switch(scelta)
				{
					case 0: 
						System.out.println("Uscita dal programma...");
						break; 
					case 1:
						int range = 20 + 1 - 1; 
						int numeroCarezze = random.nextInt(range); 
						tama1.daiCarezza(numeroCarezze + 1);
						break; 
					case 2:
						int numeroBiscotti = InputDati.leggiIntero("inserisci biscotti", 1, 20);
						tama1.daiBiscotto(numeroBiscotti);
						break; 
					default: 
						System.out.println("Hai inserito un numero non valido!"); 
				}
				
				if(scelta != 0)
				{
					tama1.isFelice();
					System.out.println(tama1.getGrado_sazieta());
					System.out.println(tama1.getSoddisfazione_affettiva());
					System.out.println(tama1.isAlive() == false ? "è morto" : ""); 
					/*
					if(tama1.isAlive() == false)
						System.out.print("è morto"); 
					else
						System.out.print("è vivo");
						*/ 
				}
			}
			while(scelta != 0); 
		}
		
		public static void salutare() 
		{
			System.out.println(SALUTO);
		}
		
		public static Tamagotchi creaTama() 
		{
			String nome = InputDati.leggiStringa("Inserisci il nome del Tama: ");
			int affetto = InputDati.leggiIntero("inserisci la quantità della soddisfazione affettiva iniziale: ", 0, 100);
			int sazieta = InputDati.leggiIntero("inserisci la quantità del grado di sazietà iniziale: ", 0, 100);
			Tamagotchi tama = new Tamagotchi(nome, affetto, sazieta);
			return tama;
		}
}
