package it.unibs.fp.magazzino;

import java.util.ArrayList;

/**
 * 
 * Classe che rappresenta un magazzino, caratterizzato da un nome e da una lista
 * di articoli.
 * 
 * @author Stefano Valloncini - Mat. 731270
 *
 */
public class Magazzino
{
	private static final String LISTA_ARITCOLI_MAGAZZINO = "Lista aritcoli magazzino: ";
	private static final String NON_È_PRESENTE_ALCUN_ELEMENTO_NELLA_LISTA = "Non è presente alcun elemento nella lista";
	private static final String A_CAPO = "\n";
	private static final String CORNICE = "-------------------------------------";
	private String nomeMagazzino;
	private ArrayList<Articolo> listaArticoli;
	private ListaOrdini listaOrdini;

	public Magazzino(String nomeMagazzino, ListaOrdini listaOrdini)
	{
		this.nomeMagazzino = nomeMagazzino;
		this.listaArticoli = new ArrayList<Articolo>();
		this.listaOrdini = listaOrdini;
	}

	/**
	 * Metodo per aggiunere alla lista di articoli un particolare articolo che viene
	 * passato come paramentro (se non è già presente nella lista degli articoli)
	 * 
	 * @param articoloDaAggiungere viene passato come parametro l'oggetto di tipo
	 *                             articolo da aggiungere alla lista di articoli
	 * @return viene ritornato true se l'elemento viene aggiunto correttamente (non
	 *         è già presente nella lista), altrimenti false
	 */
	public boolean aggiungiArticolo(Articolo articoloDaAggiungere)
	{
		boolean inserimentoConSuccesso = false;

		if (ricercaArticolo(articoloDaAggiungere.getNomeArticolo()) == -1)
		{
			listaArticoli.add(articoloDaAggiungere);
			return !inserimentoConSuccesso;
		}

		return inserimentoConSuccesso;
	}

	/**
	 * Metodo per la cancellazione di un articolo dalla lista (fornendo il nome
	 * dell'articolo)
	 * 
	 * @param nomeArticoloDaRimuovere - viene passata come paramentro la String
	 *                                contenente il nome dell'articolo da eliminare
	 * @return viene ritornato true se l'elemento è stato eliminato correttamente,
	 *         altrimenti false (se l'elemento non esiste)
	 */
	public boolean eliminaArticolo(String nomeArticoloDaRimuovere)
	{
		int indexElementoDaRimuovere = ricercaArticolo(nomeArticoloDaRimuovere);
		boolean cancellazioneCorretta = false;

		if (indexElementoDaRimuovere != -1)
		{
			listaArticoli.remove(indexElementoDaRimuovere);
			return !cancellazioneCorretta;
		}

		return cancellazioneCorretta;
	}

	/**
	 * Metodo per la ricerca di un particolare articolo all'interno della lista di
	 * articoli
	 * 
	 * @param nomeArticoloDaRicercare - viene passato come paramentro il nome
	 *                                dell'articolo da ricercare (String)
	 * @return viene ritornato l'index (la posizione) dell'ellemento all'interno
	 *         della lista, se non viene trovato alcun elemento, allora viene
	 *         ritornato -1, segnale che non esiste alcun oggetto con il nome
	 *         passato
	 */
	public int ricercaArticolo(String nomeArticoloDaRicercare)
	{
		int indexElemento = -1;

		for (int i = 0; i < listaArticoli.size(); i++)
		{
			if (listaArticoli.get(i).getNomeArticolo().equalsIgnoreCase(nomeArticoloDaRicercare))
			{
				indexElemento = i;
			}
		}
		return indexElemento;
	}

	/**
	 * Metodo che ritorna il numero di articoli attualmente presenti nel magazzino.
	 * 
	 * @return il numero di articoli presenti nella lista degli elementi
	 */
	public int getNumeroElementi()
	{
		return listaArticoli.size();
	}

	/**
	 * Metodo che ritorna true se un elemento è effettivamente presente nella lista
	 * degli articoli
	 * 
	 * @param nomeArticoloDaRicercare
	 * @return
	 */
	public boolean isArticoloPresente(String nomeArticoloDaRicercare)
	{
		if (ricercaArticolo(nomeMagazzino) != -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Metodo che aggiunge alla lista un ordine inserito.
	 * 
	 * @param ordine
	 * @return
	 */
	public int aggiungiOrdine(Ordine ordine)
	{
		int indexElemento = ricercaArticolo(ordine.getArticolo().getNomeArticolo());
		int qtaEffettivaDisponibile = listaArticoli.get(indexElemento).getQtaDisponibile();
		int qtaRichiesta = ordine.getQuantità();

		if (qtaEffettivaDisponibile >= qtaRichiesta)
		{
			int qtaDopoOrdine = qtaEffettivaDisponibile - ordine.getQuantità();
			listaArticoli.get(indexElemento).setQtaDisponibile(qtaDopoOrdine);
			ordine.setGiorniAspetto(0);
			listaOrdini.aggiungiOrdine(ordine);
			return 0;
		}
		else
		{
			int qtaDopoOrdine = qtaEffettivaDisponibile - ordine.getQuantità();
			listaArticoli.get(indexElemento).setQtaDisponibile(qtaDopoOrdine);
			ordine.setGiorniAspetto(Math.abs(qtaEffettivaDisponibile - ordine.getQuantità()));
			listaOrdini.aggiungiOrdine(ordine);
			return Math.abs(qtaEffettivaDisponibile - ordine.getQuantità());
		}
	}

	// GETTERS AND SETTERS

	@Override
	public String toString()
	{
		StringBuffer messaggioString = new StringBuffer(LISTA_ARITCOLI_MAGAZZINO + nomeMagazzino + ": \n");

		if (listaArticoli.size() == 0)
		{
			messaggioString.append(NON_È_PRESENTE_ALCUN_ELEMENTO_NELLA_LISTA);
		}

		for (Articolo articolo : listaArticoli)
		{
			messaggioString.append(A_CAPO + articolo.toString());
			messaggioString.append(CORNICE);
		}

		return messaggioString.toString();
	}

	public String getNomeMagazzino()
	{
		return nomeMagazzino;
	}

	public void setNomeMagazzino(String nomeMagazzino)
	{
		this.nomeMagazzino = nomeMagazzino;
	}

	public ArrayList<Articolo> getListaArticoli()
	{
		return listaArticoli;
	}

	public void setListaArticoli(ArrayList<Articolo> listaArticoli)
	{
		this.listaArticoli = listaArticoli;
	}

	public ListaOrdini getListaOrdini()
	{
		return listaOrdini;
	}

	public void setListaOrdini(ListaOrdini listaOrdini)
	{
		this.listaOrdini = listaOrdini;
	}
}
