package it.unibs.ing.fp.veterinario;

public class Veterinario 
{
	private String nome; 
	private Agenda agenda; 
	
	public Veterinario(String nome, Agenda agenda)
	{
		this.agenda = agenda; 
		this.nome = nome; 
	}
		
	public String getNome()
	{
		return this.nome; 
	}
	
	public Agenda getAgenda()
	{
		return this.agenda; 
	}	
}
