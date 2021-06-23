package it.unibs.ing.fp.veterinario;

public class Appuntamento 
{
	private Orario orario; 
	private Luogo luogo; 
	private Animale animale; 
	private int costo; 
	private boolean isDisponibile; 
	
	public Appuntamento(Orario orario, int costo, Animale animale, Luogo luogo)
	{
		this.orario = orario; 
		this.costo = costo; 
		this.animale = animale; 
		this.luogo = luogo; 
		this.isDisponibile = true; 
	}

	@Override
	public String toString()
	{
		String messaggio = "Appuntamento per " + animale.getNome() + " \n" + "Ore: " + orario.toString() + ", " + luogo.toString() + "\n Costo: " + costo;  
		
		return messaggio; 
	}
	
	public Orario getOrario() {
		return orario;
	}

	public void setOrario(Orario orario) {
		this.orario = orario;
	}

	public Luogo getLuogo() {
		return luogo;
	}

	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

	public Animale getAnimale() {
		return animale;
	}

	public void setAnimale(Animale animale) {
		this.animale = animale;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public boolean isDisponibile() {
		return isDisponibile;
	}

	public void setDisponibile(boolean isDisponibile) {
		this.isDisponibile = isDisponibile;
	}
}
