package it.unibs.ing.fp.lab.TamaZoo;

public class TamaTriste extends Tamagotchi
{
	public TamaTriste(String nome, int grado_sazietà)
	{
		super(nome, grado_sazietà);
		this.soddisfazione_affettiva = MIN_AFFETTO; 
	}
	
	@Override
	public void riceviBiscotti(int biscotti)
	{
		super.riceviBiscotti(biscotti);
		soddisfazione_affettiva = 0; 
	}
	
	@Override
	public void riceviCarezze(int carezze)
	{
		super.riceviCarezze(carezze);
		soddisfazione_affettiva = 0; 
	}
	
	@Override
	public boolean sonoMorto()
	{
		return grado_sazietà == 0 || grado_sazietà > 90; 
	}
	
	@Override
	public boolean sonoTriste()
	{
		return true; 
	}
}
