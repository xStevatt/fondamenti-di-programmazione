package it.unibs.ing.fp.cd;

import java.util.ArrayList; 

public class ArchivioCd 
{
	private static final String ERRORE_BRANO_NON_TROVATO = "ERRORE! - Brano non trovato!";
	private static final String ERRORE_TITOLO_GIÀ_ESISTENTE = "ERRORE - Titolo già esistente!";
	private ArrayList<Cd> lista_CD = new ArrayList<Cd>(); 
	
	public void aggiungiCd(Cd CD)
	{
		boolean isValid = contiene(CD.getTitolo()); 
		
		if(isValid)
		{
			lista_CD.add(CD); 
		}
		else 
		{
			System.out.println(ERRORE_TITOLO_GIÀ_ESISTENTE);
		}
	}
	
	public boolean eliminaCd(String titolo)
	{
		boolean success = false; 
		int index = cercaBranoTitolo(titolo);
		
		if(index != -1)
		{
			lista_CD.remove(index); 
		}
		else 
		{
			System.out.println(ERRORE_BRANO_NON_TROVATO);
		}
		
		return success; 
	}
	
	public boolean contiene(String titolo)
	{
		int index = cercaBranoTitolo(titolo); 
		
		if(index != -1)
			return true; 
		else
			return false; 
	}
	
	public int cercaBranoTitolo(String titolo)
	{
		int index = -1; 
		for(int i = 0; i < lista_CD.size(); i++)
		{
			if(titolo.equalsIgnoreCase(lista_CD.get(i).getTitolo()))
				return index; 
		}
		return index; 
	}
	
	public int getNumeroCd()
	{
		return lista_CD.size(); 
	}
}
