package it.unibs.ing.fp.cartaalta;

public class Carta 
{
	private String seme;
	private ValoreCarta valore;
	
	public Carta(String seme, ValoreCarta valore)
	{
		this.seme = seme; 
		this.valore = valore; 
	}
	
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
