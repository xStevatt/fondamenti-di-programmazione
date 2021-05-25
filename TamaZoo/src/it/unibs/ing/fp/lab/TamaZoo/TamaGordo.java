package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi
{
	protected static final int DECREMENTO_TAMAGORDO = 2;

	public TamaGordo(String nome, int grado_sazietà)
	{
		super(nome, grado_sazietà); 
		soddisfazione_affettiva = MAX_AFFETTO; 
	}
	
	public boolean sonoMorto()
	{
		return grado_sazietà == 0; 
	}
	
	public boolean sonoTriste()
	{
		return grado_sazietà < 30; 
	}
	
	@Override
	public void riceviBiscotti(int biscotti)
	{
		double incremento_sazietà = PERCENTUALE_INCREMENTO_BISCOTTI * grado_sazietà * biscotti; 
		grado_sazietà += incremento_sazietà; 
	}
	
	@Override 
	public void riceviCarezze(int carezze)
	{
		double decremento_sazietà = PERCENTUALE_DECREMENTO_BISCOTTI * carezze * DECREMENTO_TAMAGORDO; 
		grado_sazietà -= decremento_sazietà; 
	}
}
