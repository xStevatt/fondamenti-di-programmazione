package it.unibs.ing.fp.veterinario;

public class Animale 
{
	private String nome; 
	private TipoAnimale tipoAnimale; 
	
	public Animale(String nome, TipoAnimale tipoAnimale)
	{
		this.nome = nome; 
		this.tipoAnimale = tipoAnimale; 
	}

	@Override
	public String toString()
	{
		return nome + ", tipo: " + tipoAnimale; 
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAnimale getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(TipoAnimale tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}
}
