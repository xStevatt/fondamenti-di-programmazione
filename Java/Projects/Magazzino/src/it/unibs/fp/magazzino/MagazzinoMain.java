package it.unibs.fp.magazzino;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.RandomNumbers;

/**
 * Classe main, completamente statica per la gestione del menu, e la creazione
 * degli oggetti
 * 
 * @author Stefano Valloncini
 *
 */
public class MagazzinoMain
{
	private static final String MAGAZZINO2 = "Magazzino ";
	private static final int MIN_QUANTITA_POSSIBILE = 0;
	private static final String VUOI_FARE_UN_ORDINE_PER_UN_ALTRO_OGGETTO_SI_NO = "Vuoi fare un ordine per un altro oggetto? [SI/NO]";
	private static final String IMPOSSIBILE_TROVARE_UN_ARTICOLO_CON_IL_NOME_INSERITO = "Impossibile trovare un articolo con il nome inserito.";
	private static final String INSERIRE_LA_QUANTITÀ_DESIDERATA = "Inserire la quantità desiderata";
	private static final String INSERIRE_IL_NOME_DELL_ARTICOLO_DA_ORDINARE = "Inserire il nome dell'articolo da ordinare";
	private static final String SI = "SI";
	private static final String NO = "NO";
	private static final String INSERISCI_IL_NUMERO_DI_GIORNI_NECESSARIO_PER_PRODURRE_UN_OGGETTO = "Inserisci il numero di giorni necessario per produrre un oggetto ";
	private static final String INSERISCI_LA_QUANTITÀ_MASSIMA_PRESENTE_NEL_MAGAZZINO = "Inserisci la quantità massima presente nel magazzino";
	private static final String INSERISCI_LA_QUANTITÀ_MINIMA_PRESENTE_NEL_MAGAZZINO = "Inserisci la quantità minima presente nel magazzino";
	private static final String INSERISCI_IL_NOME_DELL_ARTICOLO_DA_INSERIRE_NEL_MAGAZZINO = "Inserisci il nome dell'articolo da inserire nel magazzino";
	private static final String INSERISCI_IL_NOME_DEL_MAGAZZINO = "Inserisci il nome del magazzino";
	private static final String IMPOSSIBILE_ELIMINARE_CORRETTAMENTE_L_ARTICOLO = "Impossibile eliminare correttamente l'articolo!";
	private static final String RIMOZIONE_DELL_ARTICOLO_EFFETTUATA_CORRETTAMENTE = "Rimozione dell'articolo effettuata correttamente!";
	private static final String INSERISCI_IL_NOME_DELL_ARTICOLO_DA_ELIMINARE = "Inserisci il nome dell'articolo da eliminare";
	private static final String ORDINE_EFFETTUATO_CORRETTAMENTE = "Ordine effettuato correttamente.";
	private static final String IMPOSSIBILE_AGGIUNGERE_L_ARTICOLO_ALLA_LISTA = "Impossibile aggiungere l'articolo alla lista";
	private static final String ARTICOLO_AGGIUNTO_CORRETTAMENTE = "Articolo aggiunto correttamente";
	private static final String VISUALIZZA_TUTTI_GLI_ARTICOLI_DEL_MAGAZZINO = "Visualizza tutti gli articoli del magazzino";
	private static final String ELIMINA_UN_ARTICOLO_DAL_MAGAZZINO = "Elimina un articolo dal magazzino";
	private static final String CREA_ORDINE = "Crea Ordine";
	private static final String CREA_ARTICOLO = "Crea articolo";

	public static Magazzino magazzino;

	public static void main(String[] args)
	{
		gestisciMenu();
	}

	/**
	 * Metodo statico per la gestione del menù per l'interazione con l'utente.
	 * 
	 * Le opzioni possibili sono: 1. Creare un articolo 2. Creare un ordine 3.
	 * Eliminare un articolo dal magazzino 4. Visualizzare tutti gli articoli del
	 * magazzino
	 */
	public static void gestisciMenu()
	{
		magazzino = creaMagazzino();

		String[] scelte = { CREA_ARTICOLO, CREA_ORDINE, ELIMINA_UN_ARTICOLO_DAL_MAGAZZINO,
				VISUALIZZA_TUTTI_GLI_ARTICOLI_DEL_MAGAZZINO };

		MyMenu menu = new MyMenu(MAGAZZINO2 + magazzino.getNomeMagazzino(), scelte);
		int scelta = -1;

		do
		{
			System.out.println("\n");
			scelta = menu.mostraMenu();

			switch (scelta)
			{
			case 1:
				Articolo articolo = creaArticolo();
				boolean successfulAdd = magazzino.aggiungiArticolo(articolo);
				if (successfulAdd)
				{
					System.out.println(articolo.toString());
					System.out.println(ARTICOLO_AGGIUNTO_CORRETTAMENTE);
				}
				else
				{
					System.out.println(IMPOSSIBILE_AGGIUNGERE_L_ARTICOLO_ALLA_LISTA);
				}
				break;
			case 2:
				Ordine ordine = creaOrdine();
				System.out.println(ordine.toString());
				int qtaDopoOrdine = magazzino.aggiungiOrdine(ordine);

				if (qtaDopoOrdine == 0)
				{
					System.out.println(ORDINE_EFFETTUATO_CORRETTAMENTE);
				}
				else
				{
					int giorniNecessari = ordine.getArticolo().getTempoProduzione() * qtaDopoOrdine;
					System.out.println("Si ripassi tra " + giorniNecessari + " giorni per trovare il suo ordine");
				}
				break;
			case 3:
				String nomeArticolo = InputDati.inputString(INSERISCI_IL_NOME_DELL_ARTICOLO_DA_ELIMINARE);

				if (magazzino.eliminaArticolo(nomeArticolo))
				{
					System.out.println(RIMOZIONE_DELL_ARTICOLO_EFFETTUATA_CORRETTAMENTE);
				}
				else
				{
					System.out.println(IMPOSSIBILE_ELIMINARE_CORRETTAMENTE_L_ARTICOLO);
				}
				break;
			case 4:
				System.out.println(magazzino.toString());
				break;
			}
		}
		while (scelta != 0);
	}

	/**
	 * Metodo statico per la creazione di un oggetto di tipo Magazzino. Vengono
	 * richiesti in input i dati necessari alla creazione dell'oggetto all'utente
	 * 
	 * @return viene ritornato l'oggetto di tipo Magazzino che è stato creato con i
	 *         dati inseriti in input
	 */
	public static Magazzino creaMagazzino()
	{
		String nomeMagazzino = InputDati.inputString(INSERISCI_IL_NOME_DEL_MAGAZZINO);

		return new Magazzino(nomeMagazzino, new ListaOrdini());
	}

	/**
	 * Metodo statico per la creazione di un oggetto di tipo Articolo. Vengoo
	 * richiesti in input i dati necessari alla creazione dell'oggetto
	 * 
	 * @return viene ritornato l'oggetto di tipo Articolo, creato con i dati
	 *         inseriti in input
	 */
	public static Articolo creaArticolo()
	{
		String nomeArticolo = InputDati.inputString(INSERISCI_IL_NOME_DELL_ARTICOLO_DA_INSERIRE_NEL_MAGAZZINO);
		int qtaMinima = InputDati.inputInteger(INSERISCI_LA_QUANTITÀ_MINIMA_PRESENTE_NEL_MAGAZZINO, 0);
		int qtaMassima = InputDati.inputInteger(INSERISCI_LA_QUANTITÀ_MASSIMA_PRESENTE_NEL_MAGAZZINO, qtaMinima + 1);
		int tempoProduzione = InputDati.inputInteger(
				INSERISCI_IL_NUMERO_DI_GIORNI_NECESSARIO_PER_PRODURRE_UN_OGGETTO + nomeArticolo,
				MIN_QUANTITA_POSSIBILE);

		int qtaDisponibile = RandomNumbers.getRandomInteger(qtaMinima, qtaMassima);

		return new Articolo(nomeArticolo, qtaMinima, qtaMassima, qtaDisponibile, tempoProduzione);
	}

	/**
	 * Metodo statico per la creazione di un oggetto di tipo Ordine. Vengono
	 * richiesti in input i dati necessari all'utente.
	 * 
	 * @return viene ritornato l'oggetto di tipo ordine creato con i dati inseriti
	 *         in input
	 */
	public static Ordine creaOrdine()
	{
		String scelta = NO;
		Articolo articoloOrdine = null;
		int qtaArticoliDesiderata = -1;

		String[] sceltePossibili = { NO, SI };

		do
		{
			String nomeArticolo = InputDati.inputString(INSERIRE_IL_NOME_DELL_ARTICOLO_DA_ORDINARE);
			int indexOggettoRicercato = magazzino.ricercaArticolo(nomeArticolo);

			if (indexOggettoRicercato != -1)
			{
				qtaArticoliDesiderata = InputDati.inputInteger(INSERIRE_LA_QUANTITÀ_DESIDERATA, 0);
				articoloOrdine = magazzino.getListaArticoli().get(indexOggettoRicercato);
			}
			else
			{
				System.out.println(IMPOSSIBILE_TROVARE_UN_ARTICOLO_CON_IL_NOME_INSERITO);
			}

			scelta = InputDati.inputString(VUOI_FARE_UN_ORDINE_PER_UN_ALTRO_OGGETTO_SI_NO, sceltePossibili);
		}
		while (!scelta.equalsIgnoreCase(NO));

		return new Ordine(articoloOrdine, qtaArticoliDesiderata);
	}
}
