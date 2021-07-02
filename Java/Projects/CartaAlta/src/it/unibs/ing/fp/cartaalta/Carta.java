package it.unibs.ing.fp.cartaalta;

/**
 * Carta rappresenta una carta da gioco. È caratterizzata da un seme e da un valore.
 * 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public class Carta 
{
	private String seme;
	private ValoreCarta valore;
	
	public Carta(String seme, ValoreCarta valore)
	{
		this.seme = seme; 
		this.valore = valore; 
	}
	
	/**
	 * Metodo che compara due carte e ritorna la differenza tra i valori delle due carte. 
	 * 
	 * @param carta - la carta che va confrontata 
	 * @return viene ritornata la differenza tra i valori delle due carte. 
	 */
	public int compareTo(Carta carta)
	{
		return this.getValore() - carta.getValore();
	}

	@Override
	public String toString() 
	{
		return "[" + this.seme + "]: " + this.valore.getNome() + " (" + getValore() + ")";
	}
	
	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	public int getValore() 
	{
		return valore.getValore();
	}

	public void setValore(ValoreCarta valore) 
	{
		this.valore = valore;
	}
	
	public String getNome()
	{
		return valore.getNome(); 
	}
}
