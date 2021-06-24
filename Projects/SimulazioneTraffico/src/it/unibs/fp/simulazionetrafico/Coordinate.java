package it.unibs.fp.simulazionetrafico;

class Coordinate
{
	private int riga;
	private int colonna;

	public Coordinate(int riga, int colonna)
	{
		this.riga = riga;
		this.colonna = colonna;
	}

	public int getRiga()
	{
		return riga;
	}

	public int getColonna()
	{
		return colonna;
	}

	public boolean staDentro(int maxRiga, int maxColonna)
	{
		return riga < maxRiga && colonna < maxColonna;
	}

	public String toString()
	{
		return "Posizione riga:" + (riga + 1) + "; Posizione colonna:" + (colonna + 1);
	}

}
