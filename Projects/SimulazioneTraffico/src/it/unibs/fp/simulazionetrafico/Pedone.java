package it.unibs.fp.simulazionetrafico;

class Pedone extends Elemento
{
	private static final boolean SOLIDO = true;
	final static String SIMBOLO_PEDONE = "*";
	final static int VELOCITA_VERTICALE = 1;
	final static int RESISTENZA_PEDONE = 2;

	public Pedone()
	{
		super(SIMBOLO_PEDONE, RESISTENZA_PEDONE, SOLIDO);
	}

	public Coordinate getProssimaPosizione(int riga, int colonna)
	{
		return new Coordinate(riga + VELOCITA_VERTICALE, colonna);
	}
}
