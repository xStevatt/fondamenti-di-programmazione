package it.unibs.fp.titoliazionari;

import java.io.Serializable;

import it.unibs.mylib.RandomNumbers;

public class Titolo implements Serializable
{
	private static final double MAX = +20.0 / 100.0;
	private static final double MIN = -20.0 / 100.0;
	private String nome;
	private double prezzo;

	public void variazioneGiornaliera()
	{
		this.prezzo = prezzo + prezzo * RandomNumbers.getRandomDouble(MIN, MAX);
	}

	@Override
	public String toString()
	{
		return "Nome: " + nome + ", prezzo: " + prezzo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public double getPrezzo()
	{
		return prezzo;
	}

	public void setPrezzo(double prezzo)
	{
		this.prezzo = prezzo;
	}
}
