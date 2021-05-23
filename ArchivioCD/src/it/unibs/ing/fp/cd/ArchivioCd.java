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
	
	public Cd cdCasuale()
	{
		return 	lista_CD.get(RandomNumbers.getRandomInteger(0, lista_CD.size())); 
	}
	
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
	
	public boolean contiene(String titolo)
	{
		int index = cercaTitoloCD(titolo); 
		
		if(index != -1)
			return true; 
		else
			return false; 
	}
	
	public int cercaTitoloCD(String titolo)
	{
		for(int i = 0; i < lista_CD.size(); i++)
		{
			if(titolo.equalsIgnoreCase(lista_CD.get(i).getTitolo()))
				return i; 
		}
		return -1; 
	}
	
	public String visualizzaContenutoCD(int index_elemento)
	{
		return lista_CD.get(index_elemento).toString();
	}
	
	@Override
	public String toString() {
		return "ArchivioCd [lista_CD=" + lista_CD + "]";
	}

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
