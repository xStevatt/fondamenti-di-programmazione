package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class RubricaTelefonicaMain
{
	public static void main(String[] args)
	{
		mostraMenu();
	}

	public static void mostraMenu()
	{
		RubricaTelefonica rubrica = new RubricaTelefonica();

		String[] scelte = { "Aggiungi un nuovo soggetto", "Ricerca persona o azienda", "Ricerca contatto",
				"Aggiungi un nuovo contatto", "Modifica il contatto", "Elimina un contatto" };

		MyMenu menu = new MyMenu("Rubrica Telefonica", scelte);

		int scelta = -1;

		do
		{
			scelta = menu.scegli();

			switch (scelta)
			{
			case 1:
				boolean isValid = false;

				do
				{
					String opzione = InputDati.leggiStringa("Azienda o Persona? -> ");
					if (opzione.equalsIgnoreCase("azienda"))
					{
						Azienda azienda = creaAzienda();
						isValid = true;
						rubrica.aggiungiSoggetto(azienda);
					}
					if (opzione.equalsIgnoreCase("persona"))
					{
						Persona persona = creaPersona();
						isValid = true;
						rubrica.aggiungiSoggetto(persona);
					}
					if (!opzione.equalsIgnoreCase("persona") && !opzione.equalsIgnoreCase("azienda"))
					{
						System.out.println("Inserire una scelta valida");
						isValid = false;
					}
				}
				while (isValid == false);

				System.out.println(rubrica.toString());

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				Contatto contatto = creaContatto();
				break;
			case 5:
				break;
			case 6:
				break;
			}
		}
		while (scelta != 0);

		System.out.println("Grazie per aver usato Rubrica Telefonica!");
	}

	public static Contatto creaContatto()
	{
		String nome = InputDati.leggiStringa("Inserisci il nome del contatto -> ");
		ArrayList<String> listaNumeriTelefono = new ArrayList<String>();

		// 0. ESCI
		// 1. Aggiugi un numero di telefono

		int scelta = -1;

		do
		{
			if (scelta != 0)
			{
				String numeroTelefono = InputDati.leggiStringa("Inserisci il numero di telefono -> ");
				listaNumeriTelefono.add(numeroTelefono);
			}

			scelta = InputDati.leggiIntero("Vuoi inserire un altro numero di telefono -> ");
		}
		while (scelta != 0);

		String email = InputDati.leggiStringa("Inserisci l'email -> ");
		String indirizzo = InputDati.leggiStringa("Inserisci l'indrizzo -> ");

		return new Contatto(nome, listaNumeriTelefono, email, indirizzo);
	}

	public static Persona creaPersona()
	{
		String nome = InputDati.leggiStringa("Inserisci il nome -> ");
		String cognome = InputDati.leggiStringa("Inserisci il cognome -> ");
		ArrayList<Contatto> listaContatti = new ArrayList<>();

		int scelta = -1;

		listaContatti.add(creaContatto());
		do
		{
			scelta = InputDati.leggiIntero("Vuoi inserire un altro contatto? -> ");
			if (scelta != 0)
				listaContatti.add(creaContatto());
		}
		while (scelta != 0);

		return new Persona(listaContatti, nome, cognome);
	}

	public static Azienda creaAzienda()
	{
		String nome = InputDati.leggiStringa("Inserisci la ragione sociale -> ");
		String cognome = InputDati.leggiStringa("Inserisci il descrizione -> ");
		ArrayList<Contatto> listaContatti = new ArrayList<>();

		int scelta = -1;

		listaContatti.add(creaContatto());
		do
		{
			scelta = InputDati.leggiIntero("Vuoi inserire un altro contatto? -> ");
			if (scelta != 0)
				listaContatti.add(creaContatto());
		}
		while (scelta != 0);

		return new Azienda(listaContatti, nome, cognome);
	}
}
