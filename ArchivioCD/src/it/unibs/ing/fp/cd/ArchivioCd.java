package it.unibs.ing.fp.cd;

import java.util.ArrayList;

import it.unibs.ing.fp.mylib.RandomNumbers; 

/**
 * Classe che gestisce un archivio di CD. 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class ArchivioCd 
{
	private static final String ERRORE_BRANO_NON_TROVATO = "ERRORE! - Brano non trovato!";
	private static final String ERRORE_TITOLO_GIÀ_ESISTENTE = "ERRORE - Titolo già esistente!";
	private ArrayList<Cd> lista_CD; 
	
	public ArchivioCd()
	{
		lista_CD = new ArrayList<Cd>(); 
	}
	
	/**
	 * Metodo che ritorna un CD estratto dall'ArrayList di CD
	 * @return Cd - ritorna il cd estratto casualmente dalla lista
	 */
	public Cd cdCasuale()
	{
		return 	lista_CD.get(RandomNumbers.getRandomInteger(0, lista_CD.size())); 
	}
	
	/**
	 * Metodo per l'aggiunta di un CD alla lista di CD. 
	 * @param CD - Il CD da aggiungere alla lista
	 * @return viene ritornato true se l'aggiunta è avvenuta correttamente, altrimenti false
	 */
	public boolean aggiungiCd(Cd CD)
	{
		boolean isValid = !contiene(CD.getTitolo()); 
		
		if(isValid)
		{
			lista_CD.add(CD); 
			return true; 
		}
		else 
		{
			return false; 
		}
	}
	
	/**
	 * Metodo per l'eliminazione di un CD all'interno della lista di CD.
	 * @param titolo - viene passato il titolo del CD da eliminare
	 * @return viene ritornato true se la rimozione è andata a buon fine, altrimenti false (ad esempio se il titolo inserito non è presente nella lista)
	 */
	public boolean eliminaCd(String titolo)
	{
		int index = cercaTitoloCD(titolo);
		
		if(index != -1)
		{
			lista_CD.remove(index); 
			return true; 
		}
		else 
		{
			System.out.println(ERRORE_BRANO_NON_TROVATO);
			return false; 
		}
	}
	
	/**
	 * Metodo per verificare se l'archivio contiene il CD. 
	 * @param titolo - viene passato come parametro il titolo del cd da verificare
	 * @return ritorna true se è presente un CD che ha il titolo passato come parametro, altrimenti false
	 */
	public boolean contiene(String titolo)
	{
		int index = cercaTitoloCD(titolo); 
		
		if(index != -1)
			return true; 
		else
			return false; 
	}
	
	/**
	 * Metodo per ricercare un particolare CD (attraverso il titolo).
	 * @param titolo - viene passato come parametro il titolo del cd da cercare
	 * @return viene ritornato l'indice della lista in cui si trova il CD che ha il titolo passato come parametro. Se non esiste un CD con il titolo passato come parametro, allora ritorna -1
	 */
	public int cercaTitoloCD(String titolo)
	{
		for(int i = 0; i < lista_CD.size(); i++)
		{
			if(titolo.equalsIgnoreCase(lista_CD.get(i).getTitolo()))
				return i; 
		}
		return -1; 
	}
	
	/**
	 * Metodo per visualizare gli attributi di un particolare CD (il cui indice (posizione) nella lista viene passata come parametro). 
	 * @param index_elemento - viene passato come parametro la posizione nella lista del CD
	 * @return viene ritornata un oggetto di tipo String che contiene le informazioni del CD prodotte dal metodo toString() della classe CD
	 */
	public String visualizzaContenutoCD(int index_elemento)
	{
		return lista_CD.get(index_elemento).toString();
	}
	
	@Override
	public String toString() {
		return "ArchivioCd [lista_CD=" + lista_CD + "]";
	}

	/**
	 * Metodo per ottenere il numero di CD contenuti nella lista.
	 * @return viene ritornato il numero di elementi contenuti nella lista, ottenuti attraverso il metodo size() di ArrayList
	 */
	public int getNumeroCd()
	{
		return lista_CD.size(); 
	}

	public ArrayList<Cd> getLista_CD() 
	{
		return lista_CD;
	}

	public void setLista_CD(ArrayList<Cd> lista_CD) 
	{
		this.lista_CD = lista_CD;
	}
}
