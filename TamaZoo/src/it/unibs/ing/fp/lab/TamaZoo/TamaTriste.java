package it.unibs.ing.fp.lab.TamaZoo;

/**
 * TamaTriste
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class TamaTriste extends Tamagotchi
{
	public TamaTriste(String nome, int grado_sazietà)
	{
		super(nome, grado_sazietà);
		this.soddisfazione_affettiva = MIN_AFFETTO; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void riceviBiscotti(int biscotti)
	{
		super.riceviBiscotti(biscotti);
		soddisfazione_affettiva = 0; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void riceviCarezze(int carezze)
	{
		super.riceviCarezze(carezze);
		soddisfazione_affettiva = 0; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean sonoMorto()
	{
		return grado_sazietà == 0 || grado_sazietà > 90; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean sonoTriste()
	{
		return true; 
	}
	
	@Override
	public void setSoddisfazione_affettiva(double soddisfazione_affettiva)
	{
		soddisfazione_affettiva = 0; 
	}
}
