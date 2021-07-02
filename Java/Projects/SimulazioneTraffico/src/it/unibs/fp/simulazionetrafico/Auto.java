package it.unibs.fp.simulazionetrafico;

class Auto extends Elemento
{
	final static int VELOCITA_ORIZZONTALE = 2;
	final static int RESISTENZA_AUTO = 1;
	final static String SIMBOLO_AUTOMOBILE = ">";

	public Auto()
	{
		super(SIMBOLO_AUTOMOBILE, RESISTENZA_AUTO, true);
	}

	public Coordinate getProssimaPosizione(int riga, int colonna)
	{
		return new Coordinate(riga, colonna + VELOCITA_ORIZZONTALE);
	}
}
