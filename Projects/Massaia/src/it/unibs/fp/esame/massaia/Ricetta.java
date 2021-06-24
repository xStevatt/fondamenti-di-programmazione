package it.unibs.fp.esame.massaia;

import java.util.ArrayList;

public class Ricetta
{
	private String nome;
	private String descrizione;
	private ArrayList<Ingrediente> listaIngredienti;
	private int calorie;
	private boolean primoPiatto;

	public Ricetta(String nome, String descrizione, ArrayList<Ingrediente> listaIngredienti, boolean primoPiatto)
	{
		this.nome = nome;
		this.descrizione = descrizione;
		this.listaIngredienti = listaIngredienti;
		this.primoPiatto = primoPiatto;
	}

	public String toString()
	{
		String tipoPiatto;

		if (primoPiatto)
			tipoPiatto = "Primo piatto";
		else
			tipoPiatto = "Secondo piatto";

		String messaggio = "Nome: " + nome + ", descrizione: " + descrizione + ", listaIngredienti: " + listaIngredienti
				+ ", tipo piatto: " + tipoPiatto + ", calorie: " + calorie;

		return messaggio;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescrizione()
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}

	public ArrayList<Ingrediente> getListaIngredienti()
	{
		return listaIngredienti;
	}

	public void setListaIngredienti(ArrayList<Ingrediente> listaIngredienti)
	{
		this.listaIngredienti = listaIngredienti;
	}

	public int getCalorie()
	{
		return calorie;
	}

	public void setCalorie(int calorie)
	{
		this.calorie = calorie;
	}

	public boolean isPrimoPiatto()
	{
		return primoPiatto;
	}

	public void setPrimoPiatto(boolean primoPiatto)
	{
		this.primoPiatto = primoPiatto;
	}
}
