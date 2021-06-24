package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public class Persona extends Soggetto
{
	private String nome;
	private String cognome;

	public Persona(ArrayList<Contatto> listaContatti, String nome, String cognome)
	{
		super(listaContatti);
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public String toString()
	{
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", toString()=" + super.toString() + "]";
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
}
