package it.unibs.fp.esame.massaia;

public class Ingrediente
{
	private String nome;
	private int apportoCalorico;

	public Ingrediente(String nome, int apportoCalorico)
	{
		this.nome = nome;
		this.apportoCalorico = apportoCalorico;
	}

	@Override
	public String toString()
	{
		String messaggio = "Nome: " + nome + ", apporto calorico: " + apportoCalorico;
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

	public int getApportoCalorico()
	{
		return apportoCalorico;
	}

	public void setApportoCalorico(int apportoCalorico)
	{
		this.apportoCalorico = apportoCalorico;
	}
}
