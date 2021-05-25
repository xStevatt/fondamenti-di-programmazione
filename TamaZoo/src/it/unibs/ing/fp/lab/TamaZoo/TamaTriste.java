package it.unibs.ing.fp.lab.TamaZoo;

public class TamaTriste extends Tamagotchi
{
	public TamaTriste(String nome, int grado_sazietà)
	{
		super(nome, grado_sazietà);
		this.soddisfazione_affettiva = MIN_AFFETTO; 
	}
	
	public boolean sonoMorto()
	{
		return grado_sazietà == 0 || grado_sazietà > 90; 
	}
	
	public boolean sonoTriste()
	{
		return true; 
	}
}
