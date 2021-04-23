package it.unibs.fp.lab.tamagotchi;

/**
 * 
 * @author Stefano Valloncini
 * @author Luigi Amarante
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class Tamagotchi 
{
	// DICHIARAZIONE COSTANTI 
	private static final int MIN_AFF_VALUE= 0;
	private static final int MIN_SAZ_VALUE = 0;
	private static final int MAX_AFF_VALUE= 100;
	private static final int MAX_SAZ_VALUE = 100;
	
	private static final int GOOD_SAZ_VALUE = 30; 
	private static final int BAD_SAZ_VALUE = 90;
	private static final int GOOD_AFF_VALUE = 30; 
	
	private static final String CAUSA_MORTE_TROPPO_CIBO_SAZIETÀ_MAGGIORE_DI_90 = "Troppo cibo. Sazietà maggiore di 90.";
	private static final String CAUSA_MORTE_NECESSITÀ_CIBO_E_AFFETTO_AFFETTO_E_SAZIETÀ_0 = "Necessità cibo e affetto. Affetto e sazietà = 0";
	private static final String CAUSA_MORTE_NECESSITÀ_CIBO_CIBO_0 = "Necessità cibo. Cibo = 0.";
	private static final String CAUSA_MORTE_MANCANZA_AFFETTO_AFFETTO_0 = "Mancanza affetto. Affetto = 0.";
	private static final String[] CAUSA_MORTE = {CAUSA_MORTE_MANCANZA_AFFETTO_AFFETTO_0, CAUSA_MORTE_NECESSITÀ_CIBO_CIBO_0, CAUSA_MORTE_NECESSITÀ_CIBO_E_AFFETTO_AFFETTO_E_SAZIETÀ_0, CAUSA_MORTE_TROPPO_CIBO_SAZIETÀ_MAGGIORE_DI_90}; 
	
	// DICHIARAZIONE ATTRIBUTI
	private String nome; 
	private int sodd_affettiva; 
	private int grado_sazieta; 
	private boolean isAlive; 
	private boolean isFelice; 
	
	public Tamagotchi(String nome, int sodd_affettiva, int grado_sazieta)
	{
		this.sodd_affettiva = sodd_affettiva; 
		this.grado_sazieta = grado_sazieta; 
		this.nome = nome; 
		this.isTamaAlive(); 
	}
	
	/***
	 * Controlla che il tamagotchi sia ancora vivo. 
	 * Il controllo si basa sulle due condizioni:
	 * 	1. Soddisfazione affettiva > MIN_SAZ_VALUE (default: 0) e contemporaneamente grado_sazietà > MIN_AFF_VALUE (default: 0). 
	 * 	   Entrambe le soddisfazioni dunque devono essere maggiori del valore MIN impostato. 
	 * 	2. Grado sazietà < MAX_SAZ_VALUE (default: 90). Il grado di sazietà dunque deve essere minore di un valore massimo impostato, 
	 * 	   oltre il quale il tamagotchi muore. 
	 */
	public void isTamaAlive()
	{
		this.isAlive = (sodd_affettiva > MIN_SAZ_VALUE && grado_sazieta > MIN_AFF_VALUE)
					    && grado_sazieta < MAX_SAZ_VALUE; 
	}
	
	/***
	 * Determina se il tamagotchi è felice o meno. Se è felice allora isFelice = true, altrimenti isFelice = false; 
	 */
	public void isTamaFelice()
	{
		this.isFelice = sodd_affettiva >= 30 && grado_sazieta >= 30 && grado_sazieta <= 90; 
	}
	
	/***
	 * Determina qual è la causa della morte del tamagotchi a seconda dei valori assunti da sodd_affettiva e grado_sazieta. 
	 * @return String - una stringa (costante) che contiene la causa della morte del tamagotchi
	 */
	public String determinaCausaMorte()
	{
		if(sodd_affettiva == MIN_SAZ_VALUE && grado_sazieta == MIN_AFF_VALUE)
		{
			this.setAlive(false);
			return CAUSA_MORTE_NECESSITÀ_CIBO_E_AFFETTO_AFFETTO_E_SAZIETÀ_0; 
		}
		else if(sodd_affettiva == MIN_AFF_VALUE)
		{
			this.setAlive(false);
			return CAUSA_MORTE_MANCANZA_AFFETTO_AFFETTO_0; 
		}
		else if(grado_sazieta == MIN_SAZ_VALUE)
		{
			this.setAlive(false);
			return CAUSA_MORTE_NECESSITÀ_CIBO_CIBO_0; 
		}
		else if(grado_sazieta == MAX_AFF_VALUE)
		{
			this.setAlive(false);
			return CAUSA_MORTE_TROPPO_CIBO_SAZIETÀ_MAGGIORE_DI_90; 
		}
		else
		{
			this.setAlive(true);
		}
		return ""; 
	}
		
	/***
	 * Permette di dare al tamagotchi dei biscotti e cambia i valori grado_sazieta e sodd_affettiva di conseguenza
	 * Verifica che il tamagotchi sia ancora vivo ogni volta che diamo dei biscotti con il metodo isAlive()
	 * @param n_biscotti - il numero di biscotti che diamo al tamagotchi
	 */
	public void riceviBiscotti(int n_biscotti)
	{
		this.grado_sazieta = Math.min(100, this.grado_sazieta + ((this.grado_sazieta * 10 / 100) * n_biscotti)); 
		this.sodd_affettiva = Math.max(0, this.sodd_affettiva - n_biscotti / 4); 
		this.isTamaAlive(); 
	}
	
	/***
	 * Permette di dare al tamagotchi delle carezze e cambia i valori grado_sazieta e sodd_affettiva di conseguenza
	 * Verifica che il tamagotchi sia ancora vivo ogni volta che diamo dei biscotti con il metodo isAlive()
	 * @param n_carezze - il numero di carezze che diamo al tamagotchi
	 */
	public void riceviCarezze(int n_carezze)
	{
		this.sodd_affettiva = Math.min(100, this.sodd_affettiva + n_carezze); 
		this.grado_sazieta = Math.max(0, this.grado_sazieta - n_carezze / 2); 
		this.isTamaAlive(); 
	}
	
	/***
	 * 
	 * @return boolean - ritorna se il tamgotchi è vivo o morto. 
	 * 1. Ritorna true: controlla se isAlive == false (cioè non è vivo, dunque morto)												   
	 * 2. Ritorna false: controlla se isAlive == true (cioè è vivo, dunque NON è morto)
	 */
	public boolean sonoMorto() 
	{
		return isAlive == true ? false : true; 
	}
	 
	/***
	 * 
	 * @return boolean - ritorna se il tamagotchi è triste o felice
	 * 1. Ritorna true: tamagotchi è triste (isFelice = falso)
	 * 2. Ritorna false: tamagotchi è felice (isFelice = true) 
	 */
	public boolean sonoTriste()
	{
		isTamaFelice();
		return isFelice == true ? false : true; 
	}
	
	// GETTERS AND SETTERS
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSodd_affettiva() {
		return sodd_affettiva;
	}

	public void setSodd_affettiva(int sodd_affettiva) {
		this.sodd_affettiva = sodd_affettiva;
	}

	public int getGrado_sazieta() {
		return grado_sazieta;
	}

	public void setGrado_sazieta(int grado_sazieta) {
		this.grado_sazieta = grado_sazieta;
	}

	public boolean isAlive(){
		return isAlive; 
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isFelice() {
		return isFelice;
	}

	public void setFelice(boolean isFelice) {
		this.isFelice = isFelice;
	}
}
