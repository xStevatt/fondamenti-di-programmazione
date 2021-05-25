package it.unibs.ing.fp.lab.TamaZoo;

public class Tamagotchi 
{
	protected static final int MAX_SAZIETA = 100;
	protected static final int MIN_SAZIETA = 0;
	protected static final int MAX_AFFETTO = 100;
	protected static final int MIN_AFFETTO = 0;
	protected static final double PERCENTUALE_DECREMENTO_BISCOTTI = 0.5;
	protected static final double PERCENTUALE_INCREMENTO_CAREZZE = 1;
	protected static final double PERCENTUALE_DECREMENTO_AFFETTO = 0.25;
	protected static final double PERCENTUALE_INCREMENTO_BISCOTTI = 0.1;
	
	protected String nome; 
	protected double soddisfazione_affettiva; 
	protected double grado_sazietà; 
	
	public Tamagotchi(String nome, double soddisfazione_affettiva, double grado_sazietà) throws IllegalArgumentException
	{
		if(soddisfazione_affettiva < 0 || grado_sazietà < 0)
		{
			throw new IllegalArgumentException("ERRORE - Numero minore di zero inserito."); 
		}
		
		this.nome = nome; 
		this.soddisfazione_affettiva = soddisfazione_affettiva; 
		this.grado_sazietà = grado_sazietà; 	
	}
	
	public Tamagotchi(String nome, int grado_sazietà)
	{
		this.nome = nome; 
		this.grado_sazietà = grado_sazietà; 
	}
	
	public boolean sonoMorto()
	{
		return soddisfazione_affettiva == 0 || grado_sazietà == 0 || grado_sazietà > 90; 
	}
	
	public boolean sonoTriste()
	{
		return soddisfazione_affettiva < 30 || grado_sazietà < 30 || grado_sazietà > 90; 
	}
	
	public void riceviBiscotti(int biscotti)
	{
		double incremento_sazietà = PERCENTUALE_INCREMENTO_BISCOTTI * grado_sazietà * biscotti; 
		grado_sazietà += incremento_sazietà; 
		
		double decremento_affetto = PERCENTUALE_DECREMENTO_AFFETTO * biscotti; 
		soddisfazione_affettiva -= decremento_affetto; 
	}
	
	public void riceviCarezze(int carezze)
	{
		double incremento_affetto = PERCENTUALE_INCREMENTO_CAREZZE * carezze; 
		soddisfazione_affettiva += incremento_affetto; 
		
		double decremento_sazietà = PERCENTUALE_DECREMENTO_BISCOTTI * carezze; 
		grado_sazietà -= decremento_sazietà; 
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public double getSoddisfazione_affettiva() 
	{
		return soddisfazione_affettiva;
	}

	public void setSoddisfazione_affettiva(double soddisfazione_affettiva) 
	{
		this.soddisfazione_affettiva = Math.min(MAX_AFFETTO, soddisfazione_affettiva);
	}

	public double getGrado_sazietà() 
	{
		return grado_sazietà;
	}

	public void setGrado_sazietà(double grado_sazietà) 
	{
		this.grado_sazietà = Math.min(MAX_SAZIETA, grado_sazietà);
	}
}
