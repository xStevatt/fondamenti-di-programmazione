public class CuoreSolitario 
{
	private String nome; 
	private String sesso; 
	private int eta; 
	private String segno_zodiacale; 
	private String segno_zodiacale_preferito; 
	
	public CuoreSolitario(String nome, String sesso, int eta, String segno_zodiacale, String segno_zodicale_preferito)
	{
		this.nome = nome; 
		this.sesso = sesso; 
		this.eta = eta; 
		this.segno_zodiacale = segno_zodiacale; 
		this.segno_zodiacale_preferito = segno_zodicale_preferito; 
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getSegno_zodiacale() {
		return segno_zodiacale;
	}

	public void setSegno_zodiacale(String segno_zodiacale) {
		this.segno_zodiacale = segno_zodiacale;
	}

	public String getSegno_zodiacale_preferito() {
		return segno_zodiacale_preferito;
	}

	public void setSegno_zodiacale_preferito(String segno_zodiacale_preferito) {
		this.segno_zodiacale_preferito = segno_zodiacale_preferito;
	}

	public boolean isCompatibile(CuoreSolitario utente, int age_difference)	
	{
		boolean isCompatibile = false; 
		
		if(Math.abs(utente.getEta() - this.eta) <= age_difference && this.segno_zodiacale_preferito.equalsIgnoreCase(utente.getSegno_zodiacale())
				&& this.segno_zodiacale_preferito.equalsIgnoreCase(utente.getSegno_zodiacale()) && this.sesso.equalsIgnoreCase(utente.getSesso()) == false)
		{
			isCompatibile = true; 
		}
		
		return isCompatibile; 
	}
}
