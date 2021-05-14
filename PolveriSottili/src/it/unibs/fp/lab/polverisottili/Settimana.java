package it.unibs.fp.lab.polverisottili;
import it.unibs.fp.lab.mylib.InputDati;

/**
 * Classe rappresentante il 
 * @author Stefano
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class Settimana 
{
	private static final int GIORNI_SETTIMANA = 7;
	
	private int anno; 
	private int n_settimana;
	private double dati_giornalieri[]; 
	
	public Settimana()
	{
		creaSettimana(); 
	}
	
	public Settimana(int anno, int n_settimana, double dati_giornalieri[])
	{
		this.anno = anno; 
		this.n_settimana = n_settimana; 
		this.dati_giornalieri = dati_giornalieri; 
	}
	
	public void creaSettimana()
	{
		anno = InputDati.inputInteger("Inserisci l'anno della settimana corrente: "); 
		n_settimana = InputDati.inputInteger("Inserisci il numero della settimana corrente: ", 1, 53); 
		dati_giornalieri = new double[GIORNI_SETTIMANA]; 
		
		for(int i = 0; i < dati_giornalieri.length; i++)
		{
			dati_giornalieri[i] = InputDati.inputDouble("Inserisci i dati per il giorno " + (i + 1) + " della settimana: "); 
		}
	}

	public double somma_dati()
	{
		double somma = 0.0; 
		
		for(double temp : dati_giornalieri)
		{
			somma += temp; 
		}
		
		return somma; 
	}
	
	public double media_dati()
	{	
		double somma = 0.0;
		
		for(double temp : dati_giornalieri)
		{
			somma += temp; 
		}
		
		return somma / GIORNI_SETTIMANA; 
	}

	public double trovaMassimo()
	{
		double max = 0.0; 
		
		for(double temp : dati_giornalieri)
		{
			max = Math.max(max, temp); 
		}
		return max; 
	}
	
	// GETTERS AND SETTERS
	public int getAnno()
	{
		return anno;
	}

	public void setAnno(int anno) 
	{
		this.anno = anno;
	}

	public int getN_settimana() 
	{
		return n_settimana;
	}

	public void setN_settimana(int n_settimana) 
	{
		this.n_settimana = n_settimana;
	}

	public double[] getDati_giornalieri() 
	{
		return dati_giornalieri;
	}

	public void setDati_giornalieri(double[] dati_giornalieri) 
	{
		this.dati_giornalieri = dati_giornalieri;
	}
}