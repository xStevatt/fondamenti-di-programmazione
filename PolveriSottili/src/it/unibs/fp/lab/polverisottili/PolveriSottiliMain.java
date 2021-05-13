package it.unibs.fp.lab.polverisottili;

/**
 * Classe per mostrare a schermo il menu di scelta
 * @author Stefano
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */

public class PolveriSottiliMain 
{
	public static void main(String[] Args)
	{
		GestoreSettimane gestore = new GestoreSettimane(); 
		gestore.mostraMenu();
	}
}
