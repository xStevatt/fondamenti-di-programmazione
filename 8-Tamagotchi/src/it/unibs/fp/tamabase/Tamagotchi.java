package it.unibs.fp.tamabase;

public class Tamagotchi {
	private String nome;
	private int soddisfazione_affettiva;
	private int grado_sazieta;
	
	public Tamagotchi(String nome, int soddisfazione_affettiva, int grado_sazieta) {
		this.nome = nome;
		this.soddisfazione_affettiva = soddisfazione_affettiva;
		this.grado_sazieta = grado_sazieta;
	}

	public String getNome()
	{
		return nome; 
	}
	
	public int getSoddisfazione_affettiva() {
		return soddisfazione_affettiva;
	}

	public void setSoddisfazione_affettiva(int soddisfazione_affettiva) {
		this.soddisfazione_affettiva = soddisfazione_affettiva;
	}

	public int getGrado_sazieta() {
		return grado_sazieta;
	}

	public void setGrado_sazieta(int grado_sazieta) {
		this.grado_sazieta = grado_sazieta;
	}
	
	public boolean isFelice() {
		boolean felicita = false;
		if (soddisfazione_affettiva > 80) {
			System.out.println("tama è felice");
			return felicita = true;
		} else
			if (soddisfazione_affettiva < 30 || grado_sazieta < 30 || grado_sazieta > 90) {
				System.out.println("tama è triste");
				return felicita = false;
			}
		return felicita;
	}		
	
	public boolean isAlive()
	{
		if(soddisfazione_affettiva == 0 || grado_sazieta == 0 || grado_sazieta == 100)
		{
			return false; 
		}
		else
		{
			return true; 
		}
	}
	
	public void daiCarezza(int n_carezze_) {
		soddisfazione_affettiva = soddisfazione_affettiva + n_carezze_; 
		if(soddisfazione_affettiva > 100) {
			soddisfazione_affettiva = 100;
		}
		
		int prodotto = n_carezze_ * 5;
		grado_sazieta = grado_sazieta - (n_carezze_ / 2);
		if (grado_sazieta < 0) {
			grado_sazieta = 0;
		}
	}	
		
	public void daiBiscotto(int n_biscotto) {
		grado_sazieta = grado_sazieta + (grado_sazieta * 10 / 100 ) * n_biscotto; 
			
			if(grado_sazieta > 100) 
			{
				grado_sazieta = 100;
			}
			
			int prodotto = n_biscotto * 5;
			soddisfazione_affettiva = soddisfazione_affettiva - (n_biscotto / 4);
			
			if (soddisfazione_affettiva < 0) 
			{
				soddisfazione_affettiva = 0;
			}
	}
	
}
