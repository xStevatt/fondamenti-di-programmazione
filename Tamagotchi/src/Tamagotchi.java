public class Tamagotchi 
{
	private static final int MIN_AFF_VALUE= 0;
	private static final int MIN_SAZ_VALUE = 0;
	private static final int MAX_AFF_VALUE= 100;
	private static final int MAX_SAZ_VALUE = 100;
	
	private static final int GOOD_SAZ_VALUE = 30; 
	private static final int BAD_SAZ_VALUE = 90;
	private static final int GOOD_AFF_VALUE = 30; 
	
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
	
	public void isTamaFelice()
	{
		this.isFelice = sodd_affettiva > GOOD_AFF_VALUE && (grado_sazieta > GOOD_SAZ_VALUE && grado_sazieta < BAD_SAZ_VALUE); 
	}
	
	public void daiBiscotto(int n_biscotti)
	{
		this.grado_sazieta = Math.min(100, (this.grado_sazieta * 10 / 100) * n_biscotti); 
		this.sodd_affettiva = Math.max(0, this.sodd_affettiva - n_biscotti / 4); 
		this.isTamaAlive();
	}
	
	public void daiCarezze(int n_carezze)
	{
		this.sodd_affettiva = Math.min(100, this.sodd_affettiva + n_carezze); 
		this.grado_sazieta = Math.max(0, grado_sazieta - n_carezze / 2); 
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
