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
	
	public Tamagotchi(int sodd_affettiva, int grado_sazieta, String nome)
	{
		this.sodd_affettiva = sodd_affettiva; 
		this.grado_sazieta = grado_sazieta; 
		this.nome = nome; 
		this.isTamaAlive(); 
	}
	
	public void isTamaAlive()
	{
		this.isAlive = (sodd_affettiva > MIN_SAZ_VALUE && grado_sazieta > MIN_AFF_VALUE)
					    && grado_sazieta < MAX_SAZ_VALUE; 
	}
	
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
	
	public void isTamaFelice()
	{
		this.isFelice = sodd_affettiva > GOOD_AFF_VALUE && (grado_sazieta > GOOD_SAZ_VALUE && grado_sazieta < BAD_SAZ_VALUE); 
	}
	
	public void daiBiscotto(int n_biscotti)
	{
		this.grado_sazieta = Math.min(100, this.grado_sazieta + ((this.grado_sazieta * 10 / 100) * n_biscotti)); 
		this.sodd_affettiva = Math.max(0, this.sodd_affettiva - n_biscotti / 4); 
		this.isTamaAlive();
	}
	
	public void daiCarezze(int n_carezze)
	{
		this.sodd_affettiva = Math.min(100, this.sodd_affettiva + n_carezze); 
		this.grado_sazieta = Math.max(0, this.grado_sazieta - n_carezze / 2); 
		this.isTamaAlive();
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

	public boolean isAlive() {
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
