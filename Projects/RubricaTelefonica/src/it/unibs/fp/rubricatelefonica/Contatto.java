package it.unibs.fp.rubricatelefonica;

import java.util.ArrayList;

public class Contatto
{
	private String nome;
	private ArrayList<String> listaNumeriTelefono;
	private String email;
	private String indrizzo;

	public Contatto(String nome, ArrayList<String> listaNumeriTelefono, String email, String indrizzo)
	{
		this.nome = nome;
		this.listaNumeriTelefono = listaNumeriTelefono;
		this.email = email;
		this.indrizzo = indrizzo;
	}

	@Override
	public String toString()
	{
		return "Contatto [nome=" + nome + ", listaNumeriTelefono=" + listaNumeriTelefono + ", email=" + email
				+ ", indrizzo=" + indrizzo + "]";
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public ArrayList<String> getListaNumeriTelefono()
	{
		return listaNumeriTelefono;
	}

	public void setListaNumeriTelefono(ArrayList<String> listaNumeriTelefono)
	{
		this.listaNumeriTelefono = listaNumeriTelefono;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getIndrizzo()
	{
		return indrizzo;
	}

	public void setIndrizzo(String indrizzo)
	{
		this.indrizzo = indrizzo;
	}
}
